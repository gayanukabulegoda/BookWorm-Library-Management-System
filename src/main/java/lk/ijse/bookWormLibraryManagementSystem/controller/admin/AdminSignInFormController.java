package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class AdminSignInFormController {

    @FXML
    private Label lblSignIn;

    @FXML
    private Label lblSignUp;

    @FXML
    private Pane signInPane;

    @FXML
    private Pane signUpPane;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnSignInOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("adminGlobalForm.fxml", event);
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
                AdminSignInGlobalFormController.signInSignUpPane, "adminSignUpForm.fxml");
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
                AdminSignInGlobalFormController.signInSignUpPane, "adminForgotPasswordForm.fxml");
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) throws IOException {
        btnSignInOnAction(event);
    }

    @FXML
    void txtUsernameOnAction(ActionEvent event) throws IOException {
        txtPasswordOnAction(event);
    }

}