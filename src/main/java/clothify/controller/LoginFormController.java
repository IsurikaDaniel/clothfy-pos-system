package clothify.controller;

import clothify.bo.custom.AccountBO;
import clothify.bo.custom.BoFactory;
import clothify.dao.util.BoType;
import clothify.dto.AccountDto;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class LoginFormController {

    public AnchorPane paneLogin;
    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtPassword;

    private AccountBO accountBO = BoFactory.getInstance().getBo(BoType.ACCOUNT);
    private List<AccountDto> accounts;
    public void initialize(){
        try {
            accounts = accountBO.allAccount();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnLoginonAction(ActionEvent event) throws RuntimeException, SQLException, ClassNotFoundException {

        List<AccountDto> dtoList  = accountBO.allAccount();
        for (AccountDto dto:dtoList) {

            if(dto.getEmail().equals(txtEmail.getText())){
                if (dto.getPassword().equals(txtPassword.getText())) {
                    if (dto.getJobRole().equals("Admin")){
                        Stage stage = (Stage) paneLogin.getScene().getWindow();
                        try {
                            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/adminView/admin_dashbord_form.fxml"))));

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        stage.setTitle("DashBoard Form");
                        stage.show();
                    }else if (dto.getJobRole().equals("Employee")){
                        Stage stage = (Stage) paneLogin.getScene().getWindow();
                        try {
                            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employeeView/emp_dashbord_form.fxml"))));

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        stage.setTitle("DashBoard Form");
                        stage.show();
                    }

                }
            }
        }


    }
}
