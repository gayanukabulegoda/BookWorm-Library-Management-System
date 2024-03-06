package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

public class UserReturnBookConfirmPopUpFormController {

    @FXML
    private Pane cancelPane;

    @FXML
    private Label lblCancel;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblId;

    @FXML
    private Label lblReturn;

    @FXML
    private Label lblTotalBooks;

    @FXML
    private Pane returnPane;

    @FXML
    private VBox vBox;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.closeUserPopUpLargePane();
    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnReturnOnAction(ActionEvent event) {
        Navigation.closeUserPopUpLargePane();
    }

    @FXML
    void btnReturnOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnReturnOnMouseExited(MouseEvent event) {

    }

}
