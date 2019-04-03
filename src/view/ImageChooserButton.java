package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageChooserButton extends Application {
    File imageFile;
    Image image;
    ImageView imageView;
    FileChooser fileChooser = new FileChooser();
    Stage primaryStage;


    public static void main(String... args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {


        fileChooser.setTitle("Select an Image");
        imageView = new ImageView();
        imageView.setImage(new Image(new FileInputStream("resources/images/tf.png")));

        Button button = new Button("add\nPhoto");
        button.setOnAction(event -> {
            try {
                openFile();
            } catch (IOException e) {
                System.out.println("Error reading Files.");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(imageView, button);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Images Choser On Image View");
        primaryStage.show();
    }


    private void openFile() throws IOException {

        imageFile = fileChooser.showOpenDialog(primaryStage);
        image = new Image(new FileInputStream(imageFile));
        imageView.setImage(image);

    }


}
