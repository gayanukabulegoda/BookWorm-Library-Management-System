package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class UserResetPasswordFormController {

    @FXML
    private Pane backPane;

    @FXML
    private Label lblBack;

    @FXML
    private Label lblResetPassword;

    @FXML
    private Pane resetPasswordPane;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private PasswordField txtNewPassword;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                UserSignInGlobalFormController.getInstance().signInSignUpPane, "userSignInForm.fxml");
    }

    @FXML
    void btnBackOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBackOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnResetPasswordOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                UserSignInGlobalFormController.getInstance().signInSignUpPane, "userSignInForm.fxml");
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
    void txtNewPasswordOnAction(ActionEvent event) throws IOException {
        txtConfirmPasswordOnAction(event);
    }

}
