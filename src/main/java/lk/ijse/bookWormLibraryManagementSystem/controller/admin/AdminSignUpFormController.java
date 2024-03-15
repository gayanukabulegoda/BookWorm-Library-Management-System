package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.dto.AdminDto;
import lk.ijse.bookWormLibraryManagementSystem.embedded.Name;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.AdminService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.RegExPatterns;

import java.io.IOException;

public class AdminSignUpFormController {

    @FXML
    private Label lblSignIn;

    @FXML
    private Label lblSignUp;

    @FXML
    private Label lblContactNoAlert;

    @FXML
    private Label lblEmailAlert;

    @FXML
    private Label lblFirstNameAlert;

    @FXML
    private Label lblLastNameAlert;

    @FXML
    private Label lblPasswordAlert;

    @FXML
    private Label lblUsernameAlert;

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
        if (validateAdmin()) {
            AdminDto adminDto = new AdminDto();
            adminDto.setName(new Name(txtFirstName.getText(), txtLastName.getText()));
            adminDto.setContactNo(txtContactNo.getText());
            adminDto.setEmail(txtEmail.getText());
            adminDto.setUsername(txtUsername.getText());
            adminDto.setPassword(txtPassword.getText());

            if (adminService.saveAdmin(adminDto)) {
                AdminSignInFormController.admin = adminService.getAdmin(txtUsername.getText());
                Navigation.switchNavigation("adminGlobalForm.fxml", event);
            } else {
                lblUsernameAlert.setText("Oops! Unable to save!");
            }
        }
    }

    private boolean validateAdmin() {
        boolean isValid = true;

        if (RegExPatterns.namePattern(txtFirstName.getText())) {
            lblFirstNameAlert.setText("Invalid Name!!");
            isValid = false;
        }

        if (RegExPatterns.namePattern(txtLastName.getText())) {
            lblLastNameAlert.setText("Invalid Name!!");
            isValid = false;
        }

        if (RegExPatterns.contactNoPattern(txtContactNo.getText())) {
            lblContactNoAlert.setText("Invalid Contact No!!");
            isValid = false;
        }

        if (RegExPatterns.emailPattern(txtEmail.getText())) {
            lblEmailAlert.setText("Invalid Email!!");
            isValid = false;
        }

        if (RegExPatterns.namePattern(txtUsername.getText())) {
            lblUsernameAlert.setText("Invalid Username!!");
            isValid = false;
        }

        if (RegExPatterns.passwordPattern(txtPassword.getText())) {
            lblPasswordAlert.setText("Invalid Password!!");
            isValid = false;
        }
        return isValid;
    }

    @FXML
    void txtFirstNameOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.namePattern(txtFirstName.getText())) {
            lblFirstNameAlert.setText("Invalid Name!!");
        } else lblFirstNameAlert.setText(" ");
    }

    @FXML
    void txtLastNameOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.namePattern(txtLastName.getText())) {
            lblLastNameAlert.setText("Invalid Name!!");
        } else lblLastNameAlert.setText(" ");
    }

    @FXML
    void txtContactNoOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.contactNoPattern(txtContactNo.getText())) {
            lblContactNoAlert.setText("Invalid Contact No!!");
        } else lblContactNoAlert.setText(" ");
    }

    @FXML
    void txtEmailOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.emailPattern(txtEmail.getText())) {
            lblEmailAlert.setText("Invalid Email!!");
        } else lblEmailAlert.setText(" ");
    }

    @FXML
    void txtUsernameOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.namePattern(txtUsername.getText())) {
            lblUsernameAlert.setText("Invalid Username!!");
        } else lblUsernameAlert.setText(" ");
    }

    @FXML
    void txtPasswordOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.passwordPattern(txtPassword.getText())) {
            lblPasswordAlert.setText("Invalid Password!!");
        } else lblPasswordAlert.setText(" ");
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
