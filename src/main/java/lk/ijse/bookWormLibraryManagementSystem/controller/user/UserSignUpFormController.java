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

public class UserSignUpFormController {

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

    UserService userService =
            (UserService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.USER);

    @FXML
    void btnSignInOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                UserSignInGlobalFormController.getInstance().signInSignUpPane, "userSignInForm.fxml");
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) throws IOException {
        UserDto userDto = new UserDto();
        userDto.setName(txtFirstName.getText() +" "+ txtLastName.getText());
        userDto.setEmail(txtEmail.getText());
        userDto.setUsername(txtUsername.getText());
        userDto.setPassword(txtPassword.getText());
        userDto.setAdmin(userService.getAdminData(1));

        if (userService.saveUser(userDto)) {
            UserSignInFormController.user = userService.getUser(txtUsername.getText());
            Navigation.switchNavigation("userGlobalForm.fxml", event);
        }
        else {
            System.out.println("Unable to save user!");
        }
    }

    @FXML
    void btnSignUpOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnSignUpOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtContactNoOnAction(ActionEvent event) {
        txtEmail.requestFocus();
    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {
        txtUsername.requestFocus();
    }

    @FXML
    void txtFirstNameOnAction(ActionEvent event) {
        txtLastName.requestFocus();
    }

    @FXML
    void txtLastNameOnAction(ActionEvent event) {
        txtContactNo.requestFocus();
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) throws IOException {
        btnSignUpOnAction(event);
    }

    @FXML
    void txtUsernameOnAction(ActionEvent event) {
        txtPassword.requestFocus();
    }

}
