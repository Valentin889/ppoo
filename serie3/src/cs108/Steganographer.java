package cs108;

import java.awt.image.BufferedImage;

public final class Steganographer {
    private Steganographer() { }

    public static String extract(BufferedImage image) {
        // TODO: à faire (exercice 1)
        String binarytext = "";
        int t = 0;
        int count = 0;


        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {

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





        return binarytext;
    }

    public static BufferedImage insert(BufferedImage image, String string) {

        int t = 0;
        int count1 = 0;
        int count2 = 0;
        char c = string.charAt(0);




        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                //int val = image.getRGB(j,i) & 1;

                c = 0b1111000000000000;

                int val = (int)c << 16 + count1;
                System.out.println(val);
                val = val >>> 15;
                System.out.println(val);
                image.setRGB(j,i,image.getRGB(j,i) | val);


                count1++;

                if(count1 == 16){
                    count2++;
                    c = 0;
                    if(string.length() > count2){
                        c = string.charAt(count2);
                    } else {
                        i = image.getHeight();
                        j = image.getWidth();
                    }
                }
            }
        }



        return image;
    }
}
