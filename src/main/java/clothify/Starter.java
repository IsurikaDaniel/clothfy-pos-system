package clothify;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Starter extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/register_Form.fxml"));

        Scene scene = new Scene(loader.load());

        // Set up the stage
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.show();
    }
}
