package cs108;

public class main {
    public static void main(String[] args) {
        BurrowsWheelerTransform.forward("ab");



        String m = "ssssrs;àtsessten .hmmfffm asnsltsLlll"
                + "ssrlhhhrrr   cl lmmb ll aaii  eaaouoeçstu uuu"
                + "eeeeeeee suuu ennu ceeeeeeeo a";
        Pair<Integer, String> mBWT = new Pair<>(17, m);
        System.out.println(BurrowsWheelerTransform.backward(mBWT));
    }
}
