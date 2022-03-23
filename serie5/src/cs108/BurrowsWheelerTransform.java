package cs108;

import java.util.*;

public final class BurrowsWheelerTransform {
    private BurrowsWheelerTransform() {}

    public static Pair<Integer, String> forward(String s) {

        if(s.isEmpty()){
            throw new IllegalArgumentException();
        }

        Queue<Character> queue = new ArrayDeque<>();
        List<String> lstString = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            queue.add(queue.poll());
            StringBuilder sb = new StringBuilder();
            for (Character c: queue) {
                sb.append(c);
            }
            lstString.add(sb.toString());
        }

        Collections.sort(lstString);

        StringBuilder sb = new StringBuilder();
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < lstString.size(); i++) {
            sb.append(lstString.get(i).charAt(s.length()-1));
            if (lstString.get(i).equals(s)){
                index = i;
            }

        }



        return new Pair<>(index, sb.toString());

    }

    public static String backward(Pair<Integer, String> p) {

        if(p.first() >= p.second().length() || p.first() < 0){
            throw new IndexOutOfBoundsException();
        }

        int index = p.first();
        int size = p.second().length();
        List<StringBuilder> lst = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            lst.add(new StringBuilder());
        }

        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                lst.get(i).insert(0, p.second().charAt(i));
            }

            Collections.sort(lst);
        }


        return lst.get(index).toString();

    }
}
