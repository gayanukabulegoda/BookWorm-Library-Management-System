package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class UserDashboardFormController {

    @FXML
    private Pane availableBookPane;

    @FXML
    private Pane borrowedBookPane;

    @FXML
    private Pane returnedBookPane;

    @FXML
    private Text textQuote;

    @FXML
    void btnAvailableBookOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                UserGlobalFormController.getInstance().pagingPane, "userBorrowBooksForm.fxml");
    }

    @FXML
    void btnAvailableBookOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAvailableBookOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnBorrowedBookOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                UserGlobalFormController.getInstance().pagingPane, "userBorrowedBooksForm.fxml");
    }

    @FXML
    void btnBorrowedBookOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBorrowedBookOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnReturnedBookOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                UserGlobalFormController.getInstance().pagingPane, "userReturnedBooksForm.fxml");
    }

    @FXML
    void btnReturnedBookOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnReturnedBookOnMouseExited(MouseEvent event) {

    }

}
