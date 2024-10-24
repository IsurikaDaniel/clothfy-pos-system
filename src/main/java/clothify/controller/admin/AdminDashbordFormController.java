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

            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/adminView/employee_view_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Employee Form");
        stage.show();
    }

    public void clickOnActionAddCus(MouseEvent mouseEvent) {
        Stage stage = (Stage) paneAdmin.getScene().getWindow();
        try {

            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employeeView/addcustomer_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Customer Form");
        stage.show();
    }

    public void clickOnActionAddSup(MouseEvent mouseEvent) {
        Stage stage = (Stage) paneAdmin.getScene().getWindow();
        try {

            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/suppliyer_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Supplier Form");
        stage.show();
    }

    public void clickOnActionProduct(MouseEvent mouseEvent) {
        Stage stage = (Stage) paneAdmin.getScene().getWindow();
        try {

            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/product_and_order_view_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Supplier Form");
        stage.show();
    }
}
