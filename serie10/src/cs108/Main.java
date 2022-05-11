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

        BorderPane mainPane = new BorderPane(imageView);

        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Mandelbrot");
        primaryStage.show();
    }
}
