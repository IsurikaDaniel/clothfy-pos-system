package clothify.controller.admin;

import clothify.bo.custom.BoFactory;
import clothify.bo.custom.EmployeeBo;
import clothify.dao.util.BoType;
import clothify.dto.EmployeeDto;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class EmployeeViewFormController {

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtCompany;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtcontact;

    @FXML
    private JFXTextField txtempID;

    @FXML
    private JFXTextField txtempName;

    private EmployeeBo employeeBo = BoFactory.getInstance().getBo(BoType.EMPLOYEE);

    @FXML
    void btnAddonAction(ActionEvent event) throws SQLException, ClassNotFoundException {

            // Validate that the ID and contact fields are not empty
            if (txtempID.getText().isEmpty() || txtcontact.getText().isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Employee ID and Contact cannot be empty!").show();
                return;
            }

            // Create the EmployeeDto object
            EmployeeDto employeeDto = new EmployeeDto(
                    Integer.parseInt(txtempID.getText()),
                    txtempName.getText(),
                    Integer.parseInt(txtcontact.getText()),
                    txtEmail.getText(),
                    txtAddress.getText(),
                    txtCompany.getText()
            );

        try {

            // Save the employee using employeeBo
            boolean isSaved = employeeBo.saveEmployee(employeeDto);

            // Show appropriate alerts based on success or failure
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Employee Registered!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Register Employee").show();
            }

        } catch (NumberFormatException e) {
            // Handle format errors (e.g., non-integer input for employee ID or contact)
            new Alert(Alert.AlertType.ERROR, "Invalid format for Employee ID or Contact!").show();
        } catch (NullPointerException e) {
            // Handle case where employeeBo might be null
            new Alert(Alert.AlertType.ERROR, "Unexpected error occurred: EmployeeBo is not initialized properly!").show();
        } catch (Exception e) {
            // Handle any other exceptions
            new Alert(Alert.AlertType.ERROR, "An error occurred: " + e.getMessage()).show();
        }

    }

    @FXML
    void btnRemoveonAction(ActionEvent event) {
        try {
            boolean isDeleted = employeeBo.deleteEmployee(String.valueOf(txtempID));
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Employee Deleted!").show();

            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnUpdateonAction(ActionEvent event) {
        EmployeeDto dto = new EmployeeDto(
                Integer.parseInt(txtempID.getText()),
                txtempName.getText(),
                Integer.parseInt(txtcontact.getText()),
                txtEmail.getText(),
                txtAddress.getText(),
                txtCompany.getText()
        );

        try {
            boolean isUpdated = employeeBo.updateEmployee(dto);
            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Employee "+dto.getName()+" Updated!").show();

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
