package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

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

public class AdminBookManagementFormController {

    @FXML
    private Pane AddBookPane;

    @FXML
    private ImageView imgAdd;

    @FXML
    private Label lblAddBook;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxBookManage;

    @FXML
    void btnAddBookOnAction(ActionEvent event) throws IOException {
        Navigation.imgPopUpBackground("addBookPopUpForm.fxml");
    }

    @FXML
    void btnAddBookOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddBookOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
