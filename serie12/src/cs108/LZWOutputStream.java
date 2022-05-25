package cs108;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZWOutputStream extends OutputStream {

    private final List<List<Integer>> dict;
    private final List<Integer> lastList;
    private final Bits12OutputStream bits12OutputStream;

    public LZWOutputStream(OutputStream outputStream) {
        dict = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            dict.add(List.of(i));
        }
        lastList = new ArrayList<>();
        bits12OutputStream = new Bits12OutputStream(outputStream);


    }

    @Override
    public void write(int b0) throws IOException {
        int b = b0 & 0xFF;
        lastList.add(b);
        if(!dict.contains(lastList)){
            if(dict.size() < 4096){
                dict.add(new ArrayList<>(lastList));
            }
            lastList.remove(lastList.size()-1);
            bits12OutputStream.writeU12(dict.indexOf(lastList));
            lastList.clear();
            lastList.add(b);
        }

    }

    @Override
    public void close() throws IOException {
        if(lastList.size() != 0){
            bits12OutputStream.writeU12(dict.indexOf(lastList));
        }
        super.close();
    }
}
