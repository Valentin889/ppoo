package cs108;

import static java.lang.Math.*;

/**
 * Une image continue et infinie, représentée par une fonction associant une
 * valeur d'un type donné (p.ex. une couleur) à chaque point du plan.
 */

@FunctionalInterface
public interface Image<T> {
    T apply(double x, double y);

    Image<ColorRGB> RedDisk = (x,y) -> {
        double r = sqrt(x * x + y * y);
        return r <= 1d ? ColorRGB.RED : ColorRGB.WHITE;
    };

    Image<Double> HorizontalGradiendMask = (x,y) -> {
        return max(0, min((x + 1d) / 2d, 1d));
    };

    static Image<ColorRGB> Chessboard(ColorRGB c1, ColorRGB c2, double w){
        return (x,y) -> {
            int sqX = (int) floor(x / w), sqY = (int) floor(y / w);
            return (sqX + sqY) % 2 == 0 ? c1 : c2;
        };
    }

    static Image<ColorRGB> Composed(Image<ColorRGB> bg, Image<ColorRGB> fg, Image<Double> mask){
        return (x,y) -> bg.apply(x, y).mixWith(fg.apply(x, y), mask.apply(x, y));
    }

    default Image<T> Rotated(double angle){
        return (x,y) -> {
            double cosA = cos(-angle);
            double sinA = sin(-angle);
            double x1 = x * cosA - y * sinA;
            double y1 = x * sinA + y * cosA;
            return this.apply(x1, y1);
        };
    }

    static Image<Double> mandelbrot(int maxIt) {
        return (x, y) -> {
            Complex c = new Complex(x,y);
            Complex zn = new Complex(0,0);

            for (int i = 1; i < maxIt; i++) {
                zn = zn.squared().add(c);
                if(zn.module() >=2){
                    return (double)i / maxIt;
                }
            }
            return  1.0;
        };
    }

    static <U> Image<U> constant(U param){
        return (x,y) -> param;
    }
}
