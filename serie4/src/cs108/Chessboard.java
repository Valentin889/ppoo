package cs108;

import static java.lang.Math.sqrt;

public final class Chessboard implements ImageRGB {
    public static final ImageRGB IMAGE = new Chessboard(0.5);
    private final double size;

    public Chessboard(double size) {
        this.size = size;
    }

    @Override
    public ColorRGB apply(double x, double y) {

        int xsup = (int)Math.floor(x/size);
        int ysup =  (int)Math.floor(y/size);

        return (xsup+ysup)%2 == 0 ? ColorRGB.BLACK : ColorRGB.WHITE;
    }
}