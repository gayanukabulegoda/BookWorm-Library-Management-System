package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.UserService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.RegExPatterns;

public class UserChangeCredentialsPopUpFormController {

    @FXML
    private Pane cancelPane;

    @FXML
    private Pane closePane;

    @FXML
    private Pane confirmPane;

    @FXML
    private ImageView imgClose;

    @FXML
    private Label lblCancel;

    @FXML
    private Label lblConfirm;

    @FXML
    private PasswordField txtConfirmNewPassword;

    @FXML
    private PasswordField txtCurrentPassword;

    @FXML
    private PasswordField txtNewPassword;

    UserService userService =
            (UserService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.USER);

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.closeUserPopUpPane();
    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Navigation.closeUserPopUpPane();
    }

    @FXML
    void btnCloseOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCloseOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnConfirmOnAction(ActionEvent event) {
        if (validatePasswords()) {
            if (userService.updateUser(
                    new UserDto(
                            UserSignInFormController.user.getId(),
                            UserSignInFormController.user.getName(),
                            UserSignInFormController.user.getEmail(),
                            UserSignInFormController.user.getUsername(),
                            txtNewPassword.getText(),
                            UserSignInFormController.user.getAdmin()
                    )
                )
            ) Navigation.closeUserPopUpPane();
            else {
                System.out.println("Unable to Update User!");
//                lblConfirmPwAlert.setText("Error!! Try Again!");
            }
        }
    }

    private boolean validatePasswords() {
        boolean result = true;

        if (!UserSignInFormController.user.getPassword().equals(txtCurrentPassword.getText())) {
//            lblCurrentPwAlert.setText("Wrong Password!!");
            result = false;
        }

        if (RegExPatterns.passwordPattern(txtNewPassword.getText())) {
//            lblNewPwAlert.setText("Invalid Password!!\nPassword should contain at least 6 characters");
            result = false;
        }

        if (!txtNewPassword.getText().equals(txtConfirmNewPassword.getText())){
//            lblConfirmPwAlert.setText("New Password & Confirmation Doesn't Match!!");
            result = false;
        }
        return result;
    }

    @FXML
    void btnConfirmOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnConfirmOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtConfirmNewPasswordOnAction(ActionEvent event) {
        btnConfirmOnAction(event);
    }

    @FXML
    void txtCurrentPasswordOnAction(ActionEvent event) {
        txtNewPassword.requestFocus();
    }

    @FXML
    void txtNewPasswordOnAction(ActionEvent event) {
        txtConfirmNewPassword.requestFocus();
    }

}
