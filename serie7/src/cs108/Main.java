package cs108;

public class Main {
    public static void main(String[] args) {

        //First 2 lines
        TextImage image1 = TextImage.filled(3, 2, '#');
        TextImage image2 = TextImage.filled(3, 2, ' ');
        TextImage image3 = image1.leftOf(image2);
        TextImage image4 = image3.leftOf(image3);
        TextImage image5 = image4.leftOf(image4);


        TextImage image6 = image5.flippedHorizontally();
        TextImage image7 = image5.above(image6);

        TextImage image8 = image7.above(image7);
        TextImage image9 = image8.above(image8);
        TextImage imageFinal = image9.framed();


        imageFinal.printOn(System.out);





    }
}
