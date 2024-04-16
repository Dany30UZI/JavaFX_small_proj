import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {

            //fxml + stage title
            Parent root = FXMLLoader.load(getClass().getResource("pin.fxml"));
            stage.setTitle("Bank");

            //img icon
            Image icon = new Image("logo2.png");
            stage.getIcons().add(icon);

            //stage size
            stage.setWidth(600);
            stage.setHeight(450);
            stage.setResizable(false);


            Scene scene = new Scene(root);
            String css = this.getClass().getResource("app.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}