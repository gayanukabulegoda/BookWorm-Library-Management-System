package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.UserService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class UserSignInFormController {

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

    public static UserDto user;

    UserService userService =
            (UserService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.USER);

    @FXML
    void btnSignInOnAction(ActionEvent event) throws IOException {
        if (userService.checkUsernameAndPassword(
                txtUsername.getText(),
                txtPassword.getText()))
        {
            user = userService.getUser(txtUsername.getText());
            Navigation.switchNavigation("userGlobalForm.fxml", event);
        }
        else {
            System.out.println("Unable to Sign In");
        }
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
                UserSignInGlobalFormController.getInstance().signInSignUpPane, "userSignUpForm.fxml");
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
                UserSignInGlobalFormController.getInstance().signInSignUpPane, "userForgotPasswordForm.fxml");
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) throws IOException {
        btnSignInOnAction(event);
    }

    @FXML
    void txtUsernameOnAction(ActionEvent event) throws IOException {
        txtPassword.requestFocus();
    }

}
