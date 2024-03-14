package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.UserService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class UserForgotPasswordFormController {

    @FXML
    private Pane backPane;

    @FXML
    private Label lblBack;

    @FXML
    private Label lblResetPassword;

    @FXML
    private Pane resetPasswordPane;

    @FXML
    private TextField txtUsername;

    public static UserDto user;

    UserService userService =
            (UserService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.USER);

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
    void btnResetPasswordOnAction(ActionEvent event) {
        try {
            user = userService.getUser(txtUsername.getText());
            if (txtUsername.getText().equalsIgnoreCase(user.getUsername())) {
                Navigation.switchPaging(UserSignInGlobalFormController
                        .getInstance().signInSignUpPane, "userOtpForm.fxml");
            }
        } catch (Exception e) {
            System.out.println("Username Invalid!");
        }
    }

    @FXML
    void btnResetPasswordOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnResetPasswordOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtUsernameOnAction(ActionEvent event) {
        btnResetPasswordOnAction(event);
    }

}
