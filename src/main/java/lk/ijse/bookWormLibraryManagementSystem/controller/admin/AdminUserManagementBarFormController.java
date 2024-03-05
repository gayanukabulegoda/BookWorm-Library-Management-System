package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class AdminUserManagementBarFormController {

    @FXML
    private ImageView imgDelete;

    @FXML
    private ImageView imgEdit;

    @FXML
    private ImageView imgView;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblUsername;

    @FXML
    void imgDeleteOnMouseClicked(MouseEvent event) throws IOException {
        Navigation.imgPopUpBackground("deleteConfirmationForm.fxml");
    }

    @FXML
    void imgDeleteOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgDeleteOnMouseExited(MouseEvent event) {

    }

    @FXML
    void imgEditOnMouseClicked(MouseEvent event) throws IOException {
        Navigation.imgPopUpBackground("updateUserPopUpForm.fxml");
    }

    @FXML
    void imgEditOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgEditOnMouseExited(MouseEvent event) {

    }

    @FXML
    void imgViewOnMouseClicked(MouseEvent event) throws IOException {
        Navigation.imgPopUpBackground("viewUserPopUpForm.fxml");
    }

    @FXML
    void imgViewOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgViewOnMouseExited(MouseEvent event) {

    }

}
