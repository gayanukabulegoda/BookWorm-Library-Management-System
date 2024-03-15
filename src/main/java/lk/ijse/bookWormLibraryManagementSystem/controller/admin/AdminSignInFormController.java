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
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.AdminService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.RegExPatterns;

import java.io.IOException;

public class AdminSignInFormController {

    @FXML
    private Label lblSignIn;

    @FXML
    private Label lblSignUp;

    @FXML
    private Label lblUsernameAlert;

    @FXML
    private Label lblPasswordAlert;

    @FXML
    private Pane signInPane;

    @FXML
    private Pane signUpPane;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    public static AdminDto admin;

    AdminService adminService =
            (AdminService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.ADMIN);

    @FXML
    void btnSignInOnAction(ActionEvent event) throws IOException {
        if (validateCredentials()) {
            if (adminService.checkUsernameAndPassword(
                    txtUsername.getText(),
                    txtPassword.getText())) {
                admin = adminService.getAdmin(txtUsername.getText());
                Navigation.switchNavigation("adminGlobalForm.fxml", event);
            } else {
                lblPasswordAlert.setText("Incorrect Credentials!");
            }
        }
        txtUsername.clear();
        txtPassword.clear();
    }

    private boolean validateCredentials() {
        if (RegExPatterns.namePattern(txtUsername.getText())) {
            lblUsernameAlert.setText("Invalid Username!");
            return false;
        }
        if (RegExPatterns.passwordPattern(txtPassword.getText())) {
            lblPasswordAlert.setText("Invalid Password!");
            return false;
        }
        return true;
    }

    @FXML
    void txtUsernameOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.namePattern(txtUsername.getText())) {
            lblUsernameAlert.setText("Invalid Username!");
        } else lblUsernameAlert.setText(" ");
    }

    @FXML
    void txtPasswordOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.passwordPattern(txtPassword.getText())) {
            lblPasswordAlert.setText("Invalid Password!");
        } else lblPasswordAlert.setText(" ");
    }

    @FXML
    void btnSignInOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnSignInOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                AdminSignInGlobalFormController.getInstance().signInSignUpPane, "adminSignUpForm.fxml");
    }

    @FXML
    void btnSignUpOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnSignUpOnMouseExited(MouseEvent event) {

    }

    @FXML
    void hyperForgotPasswordOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                AdminSignInGlobalFormController.getInstance().signInSignUpPane, "adminForgotPasswordForm.fxml");
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) throws IOException {
        btnSignInOnAction(event);
    }

    @FXML
    void txtUsernameOnAction(ActionEvent event) {
        txtPassword.requestFocus();
    }

    @FXML
    void btnPowerOffOnAction(ActionEvent event) {
        Navigation.exit();
    }

}
