package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class UserBorrowedBooksFormController {

    @FXML
    private Pane ReturnedBooksPane;

    @FXML
    private Label lblReturnedBooks;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxBorrowedBooks;

    @FXML
    void btnReturnedBooksOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                UserGlobalFormController.getInstance().pagingPane, "userReturnedBooksForm.fxml");
    }

    @FXML
    void btnReturnedBooksOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnReturnedBooksOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
