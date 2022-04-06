package cs108;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class FlippedHorizontally implements TextImage{


    private final TextImage image;

    public FlippedHorizontally(TextImage image) {
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

        for (String s : lstString) {
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            valReturn.add(sb.toString());
        }
        return valReturn;
    }

}
