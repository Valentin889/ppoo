package cs108;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LZWInputStream extends InputStream {

    private final Bits12InputStream bits12InputStream;
    private final List<List<Integer>> dict;
    private List<Integer> lastList;
    private int count;
    private int lastIndex;



    public LZWInputStream(InputStream inputStream) {
        bits12InputStream = new Bits12InputStream(inputStream);
        dict = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            dict.add(new LinkedList<>(List.of(i)));
        }
        lastList = new LinkedList<>();
        lastIndex = 0;

    }

    @Override
    public int read() throws IOException {

        if(lastList.isEmpty()){
            int index = bits12InputStream.readU12();
            if(index == -1){
                return -1;
            }
            if(index >= dict.size()){
                lastList = dict.get(lastIndex);
                List<Integer> lst2 = new LinkedList<>(dict.get(lastIndex));
                lastList.add(lst2.get(lst2.size()-1));
                lastIndex = index;
                if(dict.size() < 4096){
                    dict.add(new LinkedList<>(lastList));
                }
                int val = lastList.get(0);
                lastList.remove(0);
                return val;
            }
            if(lastIndex != 0){
                List<Integer> lst1 = new LinkedList<>(dict.get(lastIndex));
                List<Integer> lst2 = new LinkedList<>(dict.get(index));
                List<Integer> toAdd = new LinkedList<>(lst1);
                toAdd.addAll(lst2);
                if(dict.size() < 4096){
                    dict.add(toAdd);
                }
            }
            lastIndex = index;
            lastList = new LinkedList<>(dict.get(index));
            int val = lastList.get(0);
            lastList.remove(0);
            return val;

        } else {
            int val = lastList.get(0);
            lastList.remove(0);
            return val;
        }
    }

    @Override
    public void close() throws IOException {
        super.close();
    }
}
