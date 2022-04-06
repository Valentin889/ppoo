package cs108;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class LeftOf implements TextImage{


    private final TextImage image1;
    private final TextImage image2;

    public LeftOf(TextImage image1, TextImage image2) {
        this.image1 = image1;
        this.image2 = image2;
    }

    @Override
    public int width() {
        return image1.width() + image2.width();
    }

    @Override
    public int height() {
        return Math.max(image1.height(), image2.height());
    }

    @Override
    public List<String> drawing() {
        List<String> lstString1 = image1.drawing();
        List<String> lstString2 = image2.drawing();
        List<String> valReturn = new ArrayList<>();

        for (int i = 0; i < height(); i++) {
            StringBuilder sb = new StringBuilder();
            String s1;
            String s2;
            if(i < image1.height()){
              s1 = lstString1.get(i);
            } else {
                s1 = " ".repeat(image1.width());
            }
            if (i < image2.height()){
                s2 = lstString2.get(i);
            } else {
                s2 = " ".repeat(image2.width());
            }
            sb.append(s1);
            sb.append(s2);
            valReturn.add(sb.toString());
        }

        return valReturn;
    }

}
