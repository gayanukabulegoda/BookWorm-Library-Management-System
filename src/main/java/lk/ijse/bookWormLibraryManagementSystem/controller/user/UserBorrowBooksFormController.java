package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class UserBorrowBooksFormController {

    @FXML
    private Pane AcquireBookPane;

    @FXML
    private ImageView imgAcquire;

    @FXML
    private Label lblAcquire;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxBooks;

    @FXML
    void btnAcquireBookOnAction(ActionEvent event) throws IOException {
        Navigation.imgPopUpBackground("userBorrowBookConfirmPopUpForm.fxml");
    }

    @FXML
    void btnAcquireBookOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAcquireBookOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
