package cs108;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public final class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Mandelbrot mandelbrot = new Mandelbrot();
        ImageView imageView = new ImageView();
        imageView.imageProperty().bind(mandelbrot.imageProperty());




        imageView.setOnMouseClicked(e -> {
            Rectangle rectangle = mandelbrot.getFrame();

            double height = mandelbrot.height();
            double ny = height - e.getY();

            double yConverter = rectangle.height() / mandelbrot.height();
            double xConverter = rectangle.width() / mandelbrot.width();

            double nxMandelbrot =  e.getX() * xConverter;
            double nyMandelbrot = ny * yConverter;

            if(e.getButton() == MouseButton.SECONDARY){
                mandelbrot.setFrameCenter(new Point(nxMandelbrot,nyMandelbrot));
            }
            else if(e.getClickCount() == 2){

                double amplifier = 0.5;
                if(e.isControlDown()){
                    amplifier = 1/amplifier;
                }




                rectangle = rectangle.translatedBy(nxMandelbrot, nyMandelbrot);
                rectangle = rectangle.scaledBy(amplifier, amplifier);
                rectangle =  rectangle.translatedBy(-nxMandelbrot * amplifier, -nyMandelbrot*amplifier);

                mandelbrot.setFrameCenter(rectangle.center());
                mandelbrot.setFrameWidth(rectangle.width());
            }
        });



        BorderPane mainPane = new BorderPane(imageView);
        mandelbrot.widthProperty().bind(mainPane.widthProperty());
        mandelbrot.heightProperty().bind(mainPane.heightProperty());

        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Mandelbrot");
        primaryStage.show();
    }
}
