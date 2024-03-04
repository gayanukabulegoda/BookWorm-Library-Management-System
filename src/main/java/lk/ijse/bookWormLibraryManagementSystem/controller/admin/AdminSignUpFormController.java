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
    void txtContactNoOnAction(ActionEvent event) {
        txtEmailOnAction(event);
    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {
        txtUsernameOnAction(event);
    }

    @FXML
    void txtFirstNameOnAction(ActionEvent event) {
        txtLastNameOnAction(event);
    }

    @FXML
    void txtLastNameOnAction(ActionEvent event) {
        txtContactNoOnAction(event);
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {
        try {
            btnSignUpOnAction(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void txtUsernameOnAction(ActionEvent event) {
        txtPasswordOnAction(event);
    }

}
