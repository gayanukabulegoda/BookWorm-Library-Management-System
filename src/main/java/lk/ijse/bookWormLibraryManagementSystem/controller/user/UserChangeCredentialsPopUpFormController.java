package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.UserService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.RegExPatterns;
import lk.ijse.bookWormLibraryManagementSystem.util.StyleUtil;

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
    private Label lblConfirmPasswordAlert;

    @FXML
    private Label lblCurrentPasswordAlert;

    @FXML
    private Label lblNewPasswordAlert;

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
        StyleUtil.cancelBtnSelected(cancelPane, lblCancel);
    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {
        StyleUtil.cancelBtnUnselected(cancelPane, lblCancel);
    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Navigation.closeUserPopUpPane();
    }

    @FXML
    void btnCloseOnMouseEntered(MouseEvent event) {
        StyleUtil.closeIconBtnSelected(closePane, imgClose);
    }

    @FXML
    void btnCloseOnMouseExited(MouseEvent event) {
        StyleUtil.closeIconBtnUnselected(closePane, imgClose);
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
                lblConfirmPasswordAlert.setText("Error!! Try Again!");
            }
        }
    }

    private boolean validatePasswords() {
        boolean isValid = true;

        if (!UserSignInFormController.user.getPassword().equals(txtCurrentPassword.getText())) {
            lblCurrentPasswordAlert.setText("Wrong Password!!");
            isValid = false;
        }

        if (RegExPatterns.passwordPattern(txtNewPassword.getText())) {
            lblNewPasswordAlert.setText("Invalid Password!!\nPassword should contain at least 6 characters");
            isValid = false;
        }

        if (!txtNewPassword.getText().equals(txtConfirmNewPassword.getText())) {
            lblConfirmPasswordAlert.setText("New Password & Confirmation Doesn't Match!!");
            isValid = false;
        }
        return isValid;
    }

    @FXML
    void btnConfirmOnMouseEntered(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnSelected(confirmPane, lblConfirm);
    }

    @FXML
    void btnConfirmOnMouseExited(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnUnselected(confirmPane, lblConfirm);
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

    @FXML
    void txtCurrentPasswordOnKeyPressed(KeyEvent event) {
        if (!UserSignInFormController.user.getPassword().equals(txtCurrentPassword.getText())) {
            lblCurrentPasswordAlert.setText("Wrong Password!!");
        } else lblCurrentPasswordAlert.setText(" ");
    }

    @FXML
    void txtNewPasswordOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.passwordPattern(txtNewPassword.getText())) {
            lblNewPasswordAlert.setText("Invalid Password!!\nPassword should contain at least 6 characters");
        } else lblNewPasswordAlert.setText(" ");
    }

    @FXML
    void txtConfirmPasswordOnKeyPressed(KeyEvent event) {
        if (!txtNewPassword.getText().equals(txtConfirmNewPassword.getText())) {
            lblConfirmPasswordAlert.setText("New Password & Confirmation Doesn't Match!!");
        } else lblConfirmPasswordAlert.setText(" ");
    }

}
