package cs108;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class LZWConcreteDecoder implements LZWDecoder{

    private final SortedSet<Character> alphabet;
    private final List<String> dict;
    private final int size;

    public LZWConcreteDecoder(SortedSet<Character> alphabet, int size) {
        if (alphabet.size() >= size)
            throw new IllegalArgumentException();

        this.alphabet = alphabet;
        this.size = size;

        dict = new ArrayList<>();
        for (int i = 0; i < alphabet.size(); i++) {
            dict.add(alphabet.toArray()[i].toString());
        }
    }

    @Override
    public String decode(List<Integer> l) {
        StringBuilder sb = new StringBuilder();
        String lastValue = "";
        for (Integer integer : l) {
            if(dict.size() > integer) {
                if(lastValue != "" && dict.size() <= size && !dict.contains(lastValue + dict.get(integer))){
                    dict.add(lastValue + dict.get(integer));
                }
                lastValue = dict.get(integer);
                sb.append(dict.get(integer));
            } else {
                //special case

                dict.add(lastValue + lastValue.charAt(0));
                if(dict.size() <= size){
                    sb.append(dict.get(dict.size()-1));
                }
                lastValue = dict.get(dict.size()-1);
            }
        }

        return sb.toString();
    }
}
