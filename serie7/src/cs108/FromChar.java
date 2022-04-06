package cs108;

import java.io.PrintStream;
import java.util.*;

public class FromChar implements TextImage{

    private final int WIDTH;
    private final int HEIGHT;
    private final char CHAR;

    public FromChar(int WIDTH, int HEIGHT, char CHAR) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.CHAR = CHAR;
    }

    @Override
    public int width() {
        return WIDTH;
    }

    @Override
    public int height() {
        return HEIGHT;
    }

    @Override
    public List<String> drawing() {
        String string = String.valueOf(CHAR).repeat(WIDTH);
        return new ArrayList<>(Collections.nCopies(HEIGHT,string));
    }

    @Override
    public void printOn(PrintStream stream) {
        TextImage.super.printOn(stream);
    }
}
