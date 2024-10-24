package clothify.controller.employee;

import clothify.bo.custom.AccountBO;
import clothify.bo.custom.BoFactory;
import clothify.bo.custom.CustomerBO;
import clothify.dao.util.BoType;
import clothify.dto.CustomerDto;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class AddCustomerFormController {

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtCusID;

    @FXML
    private JFXTextField txtCusName;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtSerchAddCus;

    @FXML
    private JFXTextField txtcontact;

    private CustomerBO customerBO = BoFactory.getInstance().getBo(BoType.CUSTOMER);

    @FXML
    void btnCusAddonAction(ActionEvent event) throws SQLException, ClassNotFoundException{
        if (txtCusID.getText().isEmpty() || txtcontact.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Customer ID and Contact cannot be empty!").show();
            return;
        }

        CustomerDto customerDto = new CustomerDto(
                Integer.parseInt(txtCusID.getText()),
                txtCusName.getText(),
                Integer.parseInt(txtcontact.getText()),
                txtEmail.getText(),
                txtAddress.getText(),
                txtDescription.getText()
        );

        try {

            boolean isSaved = customerBO.saveCustomer(customerDto);

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Registered!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Register Customer").show();
            }

        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Invalid format for Customer ID or Contact!").show();
        } catch (NullPointerException e) {
            new Alert(Alert.AlertType.ERROR, "Unexpected error occurred: CustomerBo is not initialized properly!").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "An error occurred: " + e.getMessage()).show();
        }
    }

    @FXML
    void btnCusRemoveonAction(ActionEvent event) {

    }

    @FXML
    void btnCusUpdateonAction(ActionEvent event) {

    }

}
