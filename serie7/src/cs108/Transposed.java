package cs108;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Transposed implements TextImage{


    private final TextImage image;

    public Transposed(TextImage image) {
        this.image = image;
    }

    @Override
    public int width() {
        return image.width();
    }

    @Override
    public int height() {
        return image.height();
    }

    @Override
    public List<String> drawing() {
        List<String> lstString = image.drawing();
        List<String> valReturn = new ArrayList<>();

        for (int j = 0; j < width(); j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < height(); i++) {
                String string = lstString.get(i);
                sb.append(String.valueOf(string.charAt(j)));
            }
            valReturn.add(sb.toString());
        }

        return valReturn;
    }

    @Override
    public void printOn(PrintStream stream) {
        TextImage.super.printOn(stream);
    }
}
