package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.dto.AdminDto;
import lk.ijse.bookWormLibraryManagementSystem.embedded.Name;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.AdminService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class AdminSignUpFormController {

    @FXML
    private Label lblSignIn;

    @FXML
    private Label lblSignUp;

    @FXML
    private Pane signInPane;

    @FXML
    private Pane signUpPane;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    AdminService adminService =
            (AdminService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.ADMIN);

    @FXML
    void btnSignInOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                AdminSignInGlobalFormController.getInstance().signInSignUpPane, "adminSignInForm.fxml");
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) throws IOException {
        AdminDto adminDto = new AdminDto();
        adminDto.setName(new Name(txtFirstName.getText(), txtLastName.getText()));
        adminDto.setContactNo(txtContactNo.getText());
        adminDto.setEmail(txtEmail.getText());
        adminDto.setUsername(txtUsername.getText());
        adminDto.setPassword(txtPassword.getText());

        if (adminService.saveAdmin(adminDto)) {
            AdminSignInFormController.admin = adminService.getAdmin(txtUsername.getText());
            Navigation.switchNavigation("adminGlobalForm.fxml", event);
        }
        else {
            System.out.println("Unable to save admin!");
        }
    }

    @FXML
    void btnSignUpOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnSignUpOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtContactNoOnAction(ActionEvent event) throws IOException {
        txtEmail.requestFocus();
    }

    @FXML
    void txtEmailOnAction(ActionEvent event) throws IOException {
        txtUsername.requestFocus();
    }

    @FXML
    void txtFirstNameOnAction(ActionEvent event) throws IOException {
        txtLastName.requestFocus();
    }

    @FXML
    void txtLastNameOnAction(ActionEvent event) throws IOException {
        txtContactNo.requestFocus();
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) throws IOException {
        btnSignUpOnAction(event);
    }

    @FXML
    void txtUsernameOnAction(ActionEvent event) throws IOException {
        txtPassword.requestFocus();
    }

}
