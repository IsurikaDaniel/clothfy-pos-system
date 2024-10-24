package clothify.controller.employee;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EmpDashbordFormController {

    @FXML
    private AnchorPane paneEmployee;  // Add @FXML annotation

    @FXML
    private AnchorPane paneEmpDashboard;  // Add @FXML annotation

    @FXML
    void clickOnActionAddCus(MouseEvent event) {
        try {
            Stage stage = (Stage) paneEmployee.getScene().getWindow(); // Ensure paneEmployee is properly linked
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employeeView/addcustomer_form.fxml"))));
            stage.setTitle("Employee Form");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void clickOnActionAddSup(MouseEvent event) {
        Stage stage = (Stage) paneEmployee.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/suppliyer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Employee Form");
        stage.show();
    }

    @FXML
    void clickOnActionProduct(MouseEvent event) {
        Stage stage = (Stage) paneEmployee.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/product_and_order_view_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Employee Form");
        stage.show();
    }
}
