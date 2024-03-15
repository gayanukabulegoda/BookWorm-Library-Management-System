package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.AdminService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.RegExPatterns;

import java.io.IOException;

public class AdminResetPasswordFormController {

    @FXML
    private Pane backPane;

    @FXML
    private Label lblBack;

    @FXML
    private Label lblResetPassword;

    @FXML
    private Label lblPasswordAlert;

    @FXML
    private Pane resetPasswordPane;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private PasswordField txtNewPassword;

    AdminService adminService =
            (AdminService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.ADMIN);

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                AdminSignInGlobalFormController.getInstance().signInSignUpPane, "adminSignInForm.fxml");
    }

    @FXML
    void btnBackOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBackOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnResetPasswordOnAction(ActionEvent event) throws IOException {
        if (validatePasswords()) {
            if (txtNewPassword.getText().equals(txtConfirmPassword.getText())) {
                AdminForgotPasswordFormController.admin.setPassword(txtNewPassword.getText());
                adminService.updateAdmin(AdminForgotPasswordFormController.admin);
                Navigation.switchPaging(AdminSignInGlobalFormController
                        .getInstance().signInSignUpPane, "adminSignInForm.fxml");
            }
        }
        txtNewPassword.clear();
        txtConfirmPassword.clear();
        lblPasswordAlert.setText("Invalid! Try Again!");
    }

    private boolean validatePasswords() {
        if (RegExPatterns.passwordPattern(txtNewPassword.getText())) {
            lblPasswordAlert.setText("Invalid Password!");
            return false;
        }
        if (RegExPatterns.passwordPattern(txtConfirmPassword.getText())) {
            lblPasswordAlert.setText("New Password & Confirmation Doesn't match!");
            return false;
        }
        return true;
    }

    @FXML
    void txtNewPasswordOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.passwordPattern(txtNewPassword.getText())) {
            lblPasswordAlert.setText("Invalid Password!");
        } else lblPasswordAlert.setText(" ");
    }

    @FXML
    void txtConfirmPasswordOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.passwordPattern(txtConfirmPassword.getText())) {
            lblPasswordAlert.setText("New Password & Confirmation Doesn't match!");
        } else lblPasswordAlert.setText(" ");
    }

    @FXML
    void btnResetPasswordOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnResetPasswordOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtConfirmPasswordOnAction(ActionEvent event) throws IOException {
        btnResetPasswordOnAction(event);
    }

    @FXML
    void txtNewPasswordOnAction(ActionEvent event) {
        txtConfirmPassword.requestFocus();
    }

}
