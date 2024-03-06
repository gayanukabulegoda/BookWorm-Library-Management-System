package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        closePopUpPane();
    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        closePopUpPane();
    }

    @FXML
    void btnCloseOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCloseOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnConfirmOnAction(ActionEvent event) {
        closePopUpPane();
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

    private void closePopUpPane() {
        UserGlobalFormController.getInstance().popUpPane.getChildren().clear();
        UserGlobalFormController.getInstance().popUpPane.setVisible(false);
        UserGlobalFormController.getInstance().imgTransparent.setVisible(false);
    }

}
