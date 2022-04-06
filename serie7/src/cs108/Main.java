package cs108;

public class Main {
    public static void main(String[] args) {

        TextImage.fromString("Un rectangle : ")
                .leftOf(TextImage.filled(3, 2, '#')).printOn(System.out);


        TextImage.filled(3, 1, 'X')
                .above(TextImage.filled(4, 2, 'O')).printOn(System.out);

    }
}
