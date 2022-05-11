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
            if(e.getClickCount() == 2){
                Rectangle rectangle = mandelbrot.getFrame();

                double height = mandelbrot.height();
                double ny = height - e.getY();

                double yConverter = rectangle.height() / mandelbrot.height();
                double xConverter = rectangle.width() / mandelbrot.width();

                double nxMandelbrot =  e.getX() * xConverter;
                double nyMandelbrot = ny * yConverter;

                rectangle = rectangle.translatedBy(nxMandelbrot, nyMandelbrot);
                rectangle = rectangle.scaledBy(1/2.0, 1/2.0);
                rectangle =  rectangle.translatedBy(-nxMandelbrot / 2, -nyMandelbrot/2);

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
