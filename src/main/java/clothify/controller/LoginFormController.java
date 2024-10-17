package clothify.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Objects;

public class LoginFormController {

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    void btnLoginonAction(ActionEvent event) throws RuntimeException {

        if (txtEmail.getText().equals("admin@gmail.com") && txtPassword.getText().equals("123")) {
            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/adminView/admin_dashbord_form.fxml")))));
                stage.setTitle("Admin | Dashboard");
                stage.setResizable(false);
                stage.show();

                // Close the current window
                Window currentWindow = ((Node) event.getSource()).getScene().getWindow();
                currentWindow.hide();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (txtEmail.getText().equals("emp@gmail.com") && txtPassword.getText().equals("111")) {
            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/employeeView/emp_dashbord_form.fxml")))));
                stage.setTitle("Employee | Dashboard");
                stage.setResizable(false);
                stage.show();

                // Close the current window
                Window currentWindow = ((Node) event.getSource()).getScene().getWindow();
                currentWindow.hide();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
