package clothify.controller.employee;

import clothify.bo.custom.BoFactory;
import clothify.bo.custom.CustomerBO;
import clothify.dao.util.BoType;
import clothify.dto.CustomerDto;
import clothify.entity.Customer;
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
    void btnCusAddonAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (txtCusID.getText().isEmpty() || txtcontact.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Customer ID and Contact cannot be empty!").show();
            return;
        }

        try {

            CustomerDto customerDto = new CustomerDto(
                    txtCusID.getText(),
                    txtCusName.getText(),
                    txtcontact.getText(),
                    txtEmail.getText(),
                    txtAddress.getText(),
                    txtDescription.getText()
            );

            boolean isSaved = customerBO.saveCustomer(customerDto);
            clearFields();

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Customer Registered!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Register Customer").show();
            }

        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Invalid format for Customer ID!").show();
        } catch (NullPointerException e) {
            new Alert(Alert.AlertType.ERROR, "Unexpected error occurred: CustomerBO is not initialized properly!").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "An error occurred: " + e.getMessage()).show();
        }
    }


    @FXML
    void btnCusRemoveonAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String customerId = txtSerchAddCus.getText();  // Get the text entered in the text field

        if (customerId != null && !customerId.trim().isEmpty()) {
            boolean result = customerBO.deleteCustomer(customerId);  // Pass the actual text (ID) to delete method

            if (result) {
                new Alert(Alert.AlertType.INFORMATION,"Customer deleted Successfully").show();
                clearFields();
            } else {
                new Alert(Alert.AlertType.INFORMATION,"Customer with ID " + customerId + " does not exist.");
            }
        } else {
            new Alert(Alert.AlertType.INFORMATION,"Please enter a valid Customer ID.");
        }
    }

    @FXML
    void btnCusUpdateonAction(ActionEvent event) {
        CustomerDto dto = new CustomerDto(
                txtCusID.getText(),
                txtCusName.getText(),
                txtcontact.getText(),
                txtEmail.getText(),
                txtAddress.getText(),
                txtDescription.getText()
        );

        try {
            boolean isUpdated = customerBO.updateCustomer(dto);
            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Customer "+dto.getName()+" Updated!").show();
                clearFields();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnCusSearchOnAction(ActionEvent actionEvent) {
        // Retrieve the ID from the txtId field
        String searchId = txtSerchAddCus.getText();

        // Example search logic, assuming a method like 'findCustomerById'
        Customer customer = customerBO.findCustomerById(searchId);

        if (customer != null) {
            // Set the data to the respective text fields
            txtCusID.setText(customer.getId());
            txtCusID.setEditable(false);
            txtCusName.setText(customer.getName());
            txtcontact.setText(customer.getContact());
            txtEmail.setText(customer.getEmail());
            txtAddress.setText(customer.getAddress());
            txtDescription.setText(customer.getDescription());

        } else {
            // Show a message if the customer is not found
            new Alert(Alert.AlertType.INFORMATION,"Customer is not excited").show();

        }
    }

    private void clearFields() {

        txtCusID.clear();
        txtSerchAddCus.clear();
        txtCusName.clear();
        txtEmail.clear();
        txtcontact.clear();
        txtDescription.clear();
        txtAddress.clear();
    }
}
