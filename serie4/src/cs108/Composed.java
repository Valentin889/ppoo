package cs108;

import java.awt.*;

public class Composed implements Image<ColorRGB> {
    private final Image<ColorRGB> image1;
    private final Image<ColorRGB> image2;
    private static final HorizontalGradientMask MASK = new HorizontalGradientMask();

    public Composed(Image<ColorRGB> im1,Image<ColorRGB> im2){
        image1 = im1;
        image2 = im2;
    }

    @Override
    public ColorRGB apply(double x, double y) {

        ColorRGB color1 = image1.apply(x,y);
        ColorRGB color2 = image2.apply(x,y);




        return color1.mixWith(color2, MASK.apply(x,y));

    }
}
