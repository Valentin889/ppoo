package cs108;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Above implements TextImage{


    private final TextImage image1;
    private final TextImage image2;

    public Above(TextImage image1, TextImage image2) {
        this.image1 = image1;
        this.image2 = image2;
    }

    @Override
    public int width() {
        return Math.max(image1.width(), image2.width());
    }

    @Override
    public int height() {
        return image1.height() + image2.height();
    }

    @Override
    public List<String> drawing() {
        List<String> lstString1 = image1.drawing();
        List<String> lstString2 = image2.drawing();
        List<String> valReturn = new ArrayList<>();

        for (String string : lstString1) {
            StringBuilder sb = new StringBuilder(string);
            sb.append(" ".repeat(width() - string.length()));
            valReturn.add(sb.toString());
        }

        for (String string : lstString2) {
            StringBuilder sb = new StringBuilder(string);
            sb.append(" ".repeat(width() - string.length()));
            valReturn.add(sb.toString());
        }



        return valReturn;
    }

}
