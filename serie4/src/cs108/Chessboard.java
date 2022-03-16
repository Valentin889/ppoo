package cs108;

public final class Chessboard implements Image<ColorRGB> {
    public static final Image<ColorRGB> IMAGE = new Chessboard(1);
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