package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

public class ViewBookPopUpFormController {

    @FXML
    private Pane closePane;

    @FXML
    private Pane exitPane;

    @FXML
    private ImageView imgExit;

    @FXML
    private Label lblClose;

    @FXML
    private Label lblId;

    @FXML
    private Label lblLanguage;

    @FXML
    private Label lblName;

    @FXML
    private Label lblSavedBy;

    @FXML
    private Label lblType;

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnExitOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnExitOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnCloseOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCloseOnMouseExited(MouseEvent event) {

    }

}