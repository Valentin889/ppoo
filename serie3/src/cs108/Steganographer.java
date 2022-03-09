package cs108;

import java.awt.image.BufferedImage;

public final class Steganographer {
    private Steganographer() { }

    public static String extract(BufferedImage image) {
        // TODO: à faire (exercice 1)
        String binarytext = "";
        int t = 0;
        int t2 = 0;
        int count = 0;


        for (int i = 0; i < image.getTileHeight(); i++) {
            for (int j = 0; j < image.getTileWidth(); j++) {

                int val = image.getRGB(j,i) & 1;
                t += val << (15-count);
                count++;

               if(count == 16){
                    binarytext += (char)t;
                    count = 0;
                    t=0;
                }
            }
        }


        System.out.println(binarytext);





        return null;
    }

    public static BufferedImage insert(BufferedImage image, String string) {
        // TODO: à faire (exercice 2)
        return null;
    }
}
