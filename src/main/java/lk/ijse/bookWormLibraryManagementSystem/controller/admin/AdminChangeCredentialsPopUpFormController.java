package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.dto.AdminDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.AdminService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.RegExPatterns;

public class AdminChangeCredentialsPopUpFormController {

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

    AdminService adminService =
            (AdminService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.ADMIN);

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
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
            if (adminService.updateAdmin(
                    new AdminDto(
                            AdminSignInFormController.admin.getId(),
                            AdminSignInFormController.admin.getName(),
                            AdminSignInFormController.admin.getContactNo(),
                            AdminSignInFormController.admin.getEmail(),
                            AdminSignInFormController.admin.getUsername(),
                            txtNewPassword.getText()
                    )
                )
            ) Navigation.closePopUpPane();
            else {
                System.out.println("Unable to Update Admin!");
//                lblConfirmPwAlert.setText("Error!! Try Again!");
            }
        }
    }

    private boolean validatePasswords() {
        boolean result = true;

        if (!AdminSignInFormController.admin.getPassword().equals(txtCurrentPassword.getText())) {
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
