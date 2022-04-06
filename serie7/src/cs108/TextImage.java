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

    static TextImage fromString(String string){
        return new FromString(string);
    }

    static TextImage filled(int WIDTH, int HEIGHT, char CHAR){
        return new FromChar(WIDTH,HEIGHT, CHAR);
    }


    default TextImage flippedHorizontally(){
        return new FlippedHorizontally(this);
    }

    default TextImage transposed(){
        return new Transposed(this);
    }

    default TextImage leftOf(TextImage image2){
        return new LeftOf(this, image2);
    }

    default TextImage above(TextImage image2){
        return new Above(this, image2);
    }

    default TextImage framed(){
        TextImage image1 = new FromString("-".repeat(width() + 2));
        TextImage image2 = new FromChar(1,height(), '|');

        return  image1.above(image2.leftOf(this).leftOf(image2)).above(image1);
    }
}
