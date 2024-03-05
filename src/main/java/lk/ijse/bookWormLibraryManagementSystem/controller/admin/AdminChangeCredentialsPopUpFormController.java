package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

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
        Navigation.closePopUpPane();
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
        txtNewPasswordOnAction(event);
    }

    @FXML
    void txtNewPasswordOnAction(ActionEvent event) {
        txtConfirmNewPasswordOnAction(event);
    }

}
