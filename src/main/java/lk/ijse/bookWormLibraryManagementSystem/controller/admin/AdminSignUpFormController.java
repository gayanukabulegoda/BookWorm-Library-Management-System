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

    @FXML
    void btnSignInOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                AdminSignInGlobalFormController.getInstance().signInSignUpPane, "adminSignInForm.fxml");
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("adminGlobalForm.fxml", event);
    }

    @FXML
    void btnSignUpOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnSignUpOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtContactNoOnAction(ActionEvent event) throws IOException {
        txtEmailOnAction(event);
    }

    @FXML
    void txtEmailOnAction(ActionEvent event) throws IOException {
        txtUsernameOnAction(event);
    }

    @FXML
    void txtFirstNameOnAction(ActionEvent event) throws IOException {
        txtLastNameOnAction(event);
    }

    @FXML
    void txtLastNameOnAction(ActionEvent event) throws IOException {
        txtContactNoOnAction(event);
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) throws IOException {
        btnSignUpOnAction(event);
    }

    @FXML
    void txtUsernameOnAction(ActionEvent event) throws IOException {
        txtPasswordOnAction(event);
    }

}
