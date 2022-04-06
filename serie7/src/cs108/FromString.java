package cs108;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class FromString implements TextImage{

    private final String string;
    private final int HEIGHT = 1;

    public FromString(String string) {
        this.string = string;
    }

    @Override
    public int width() {
        return string.length();
    }

    @Override
    public int height() {
        return HEIGHT;
    }

    @Override
    public List<String> drawing() {
        return new ArrayList<>(List.of(string));
    }

}
