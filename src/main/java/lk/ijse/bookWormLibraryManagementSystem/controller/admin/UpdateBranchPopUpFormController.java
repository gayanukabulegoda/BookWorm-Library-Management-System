package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

public class UpdateBranchPopUpFormController {

    @FXML
    private Pane cancelPane;

    @FXML
    private Pane closePane;

    @FXML
    private ImageView imgClose;

    @FXML
    private Label lblCancel;

    @FXML
    private Label lblUpdate;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtName;

    @FXML
    private Pane updatePane;

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
    void btnUpdateOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnUpdateOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnUpdateOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtContactNoOnAction(ActionEvent event) {
        txtLocationOnAction(event);
    }

    @FXML
    void txtLocationOnAction(ActionEvent event) {
        btnUpdateOnAction(event);
    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtContactNoOnAction(event);
    }

}