package cs108;

import java.util.*;

public class LZWConcreteEncoder implements LZWEncoder{
    private final SortedSet<Character> alphabet;
    private final Map<String, Integer> dict;
    private final int size;

    public LZWConcreteEncoder(SortedSet<Character> alphabet, int size) {
        if(alphabet.size() >= size)
            throw new IllegalArgumentException();
        this.alphabet = alphabet;
        this.size = size;
        dict = new HashMap<>();
        for (int i = 0; i < alphabet.size(); i++) {
            dict.put(alphabet.toArray()[i].toString(), i);
        }
    }

    @Override
    public List<Integer> encode(String s) {

        StringBuilder sb = new StringBuilder(s);


        List<Integer> lstReturn = new ArrayList<>();
        while (!sb.isEmpty()){
            StringBuilder sb2 = new StringBuilder(sb.toString());
            String lastString = "";
            while (!dict.containsKey(sb2.toString())){
                lastString = sb2.toString();
                sb2.delete(sb2.length()-1, sb2.length());
            }
            if(dict.size() < size && !dict.containsKey(lastString)){
                dict.put(lastString, dict.size());
            }
            lstReturn.add(dict.get(sb2.toString()));
            sb.delete(0, sb2.length());
        }

        return lstReturn;
    }
}
