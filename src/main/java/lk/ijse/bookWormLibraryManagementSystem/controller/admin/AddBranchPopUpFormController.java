package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

public class AddBranchPopUpFormController {

    @FXML
    private Pane addPane;

    @FXML
    private Pane cancelPane;

    @FXML
    private Pane closePane;

    @FXML
    private ImageView imgClose;

    @FXML
    private Label lblAdd;

    @FXML
    private Label lblCancel;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtName;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnAddOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddOnMouseExited(MouseEvent event) {

    }

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
    void txtContactNoOnAction(ActionEvent event) {
        txtLocationOnAction(event);
    }

    @FXML
    void txtLocationOnAction(ActionEvent event) {
        btnAddOnAction(event);
    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtContactNoOnAction(event);
    }

}
