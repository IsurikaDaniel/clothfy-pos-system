package clothify.controller.admin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashbordFormController {
    public AnchorPane paneAdmin;

    public void clickOnActionAddEmp(MouseEvent mouseEvent) {
        Stage stage = (Stage) paneAdmin.getScene().getWindow();
        try {
            // Correcting the path by removing the extra .fxml
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/adminView/employee_view_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Employee Form");
        stage.show();
    }

    public void clickOnActionAddEmployee(TouchEvent touchEvent) {
        Stage stage = (Stage) paneAdmin.getScene().getWindow();
        try {
            // Correcting the path by removing the extra .fxml
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/adminView/employee_view_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Employee Form");
        stage.show();
    }
}
