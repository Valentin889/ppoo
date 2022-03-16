package cs108;

public final class Rotate<T> implements Image<T> {
    private final Image<T> image;
    private static final double ANGLE = Math.toRadians(10);

    public Rotate(Image<T> image) {
        this.image = image;
    }

    @Override
    public T apply(double x, double y) {

        double nx = x * Math.cos(ANGLE) + y * Math.sin(ANGLE);
        double ny = -x * Math.sin(ANGLE) + y * Math.cos(ANGLE);


        return image.apply(nx, ny);
    }
}