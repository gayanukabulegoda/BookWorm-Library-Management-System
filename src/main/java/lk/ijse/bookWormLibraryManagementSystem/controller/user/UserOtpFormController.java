package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class UserOtpFormController {

    @FXML
    private Pane backPane;

    @FXML
    private Label lblBack;

    @FXML
    private Label lblVerify;

    @FXML
    private TextField txtOtp;

    @FXML
    private Pane verifyPane;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                UserSignInGlobalFormController.getInstance().signInSignUpPane, "userForgotPasswordForm.fxml");
    }

    @FXML
    void btnBackOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBackOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnVerifyOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                UserSignInGlobalFormController.getInstance().signInSignUpPane, "userResetPasswordForm.fxml");
    }

    @FXML
    void btnVerifyOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnVerifyOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtOtpOnAction(ActionEvent event) throws IOException {
        btnVerifyOnAction(event);
    }

}
