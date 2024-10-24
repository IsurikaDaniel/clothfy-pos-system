package clothify.controller;

import clothify.bo.custom.AccountBO;
import clothify.bo.custom.BoFactory;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import clothify.dao.util.BoType;
import clothify.dto.AccountDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterFormController implements Initializable {

    public AnchorPane paneRegister;
    @FXML
    private JFXComboBox<String> cmbJobRole;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtPassword;

    private AccountBO accountBO = BoFactory.getInstance().getBo(BoType.ACCOUNT);


    @FXML
    void btnSingUponAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        AccountDto accountDto = new AccountDto(
                txtEmail.getText(),
                txtPassword.getText(),
                cmbJobRole.getValue()
        );
        boolean isSaved = accountBO.saveAccount(accountDto);
        if (isSaved){
            new Alert(Alert.AlertType.INFORMATION, "Account Registered!").show();

            if (accountDto.getJobRole().equals("Admin")){
                if (paneRegister != null && paneRegister.getScene() != null) {
                    Stage stage = (Stage) paneRegister.getScene().getWindow();
                    try {
                        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/adminView/admin_dashbord_form.fxml"))));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stage.setTitle("Admin DashBoard Form");
                    stage.show();
                }
            } else if (accountDto.getJobRole().equals("Employee")){
                if (paneRegister != null && paneRegister.getScene() != null) {
                    Stage stage = (Stage) paneRegister.getScene().getWindow();
                    try {
                        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employeeView/emp_dashbord_form.fxml"))));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stage.setTitle("Employee DashBoard Form");
                    stage.show();
                }
            }
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("Admin");
        titles.add("Employee");
        cmbJobRole.setItems(titles);

    }

}
