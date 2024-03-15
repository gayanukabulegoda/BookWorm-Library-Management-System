package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

public class AdminForgotPasswordFormController {

    @FXML
    private Pane backPane;

    @FXML
    private Label lblBack;

    @FXML
    private Label lblResetPassword;

    @FXML
    private Label lblUsernameAlert;

    @FXML
    private Pane resetPasswordPane;

    @FXML
    private TextField txtUsername;

    public static AdminDto admin;

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
    void btnResetPasswordOnAction(ActionEvent event) {
        if (validateUsername()) {
            try {
                admin = adminService.getAdmin(txtUsername.getText());
                if (txtUsername.getText().equalsIgnoreCase(admin.getUsername())) {
                    Navigation.switchPaging(AdminSignInGlobalFormController
                            .getInstance().signInSignUpPane, "adminOtpForm.fxml");
                }
            } catch (Exception e) {
                lblUsernameAlert.setText("Invalid Username!!");
            }
        }
        txtUsername.clear();
    }

    private boolean validateUsername() {
        if (RegExPatterns.namePattern(txtUsername.getText())) {
            lblUsernameAlert.setText("Invalid Username!!");
            return false;
        }
        return true;
    }

    @FXML
    void txtUsernameOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.namePattern(txtUsername.getText())) {
            lblUsernameAlert.setText("Invalid Username!!");
        } else lblUsernameAlert.setText(" ");
    }

    @FXML
    void btnResetPasswordOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnResetPasswordOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtUsernameOnAction(ActionEvent event) throws IOException {
        btnResetPasswordOnAction(event);
    }

}
