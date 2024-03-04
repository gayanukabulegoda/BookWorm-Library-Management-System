package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class AdminBorrowedBookFormController {

    @FXML
    private Pane OverdueBorrowersPane;

    @FXML
    private Label lblOverdueBorrowers;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxBorrowedBooks;

    @FXML
    void btnOverdueBorrowersOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                AdminGlobalFormController.getInstance().pagingPane, "adminOverdueBorrowersForm.fxml");
    }

    @FXML
    void btnOverdueBorrowersOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnOverdueBorrowersOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
