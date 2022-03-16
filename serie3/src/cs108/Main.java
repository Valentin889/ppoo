package cs108;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("pskov.png"));

        image = Steganographer.insert(image, "aaaaaaa");
        String text = Steganographer.extract(image);
        System.out.println(text);


        /*
        String text = Steganographer.extract(image);
        System.out.println("Texte extrait de l'image :");
        System.out.println(text);

        */




    }
}
