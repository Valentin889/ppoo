package cs108;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class FromString implements TextImage{

    private final String string;
    private final int WIDTH = 1;

    public FromString(String string) {
        this.string = string;
    }

    @Override
    public int width() {
        return WIDTH;
    }

    @Override
    public int height() {
        return string.length();
    }

    @Override
    public List<String> drawing() {
        return new ArrayList<>(List.of(string));
    }

    @Override
    public void printOn(PrintStream stream) {
        TextImage.super.printOn(stream);
    }
}
