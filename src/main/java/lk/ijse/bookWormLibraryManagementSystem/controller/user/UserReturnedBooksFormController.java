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

public class UserReturnedBooksFormController {

    @FXML
    private Pane borrowedBooksPane;

    @FXML
    private Label lblBorrowedBooks;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxReturnedBooks;

    @FXML
    void btnBorrowedBooksOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                UserGlobalFormController.getInstance().pagingPane, "userBorrowedBooksForm.fxml");
    }

    @FXML
    void btnBorrowedBooksOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBorrowedBooksOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
