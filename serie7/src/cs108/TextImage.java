package cs108;

import java.io.PrintStream;
import java.util.List;

public interface TextImage {
    int width();
    int height();
    List<String> drawing();

    default void printOn(PrintStream stream) {
        for (String s : drawing()) stream.println(s);
    }

    static FromString fromString(String string){
        return new FromString(string);
    }

    static FromChar filled(int WIDTH, int HEIGHT, char CHAR){
        return new FromChar(WIDTH,HEIGHT, CHAR);
    }
}
