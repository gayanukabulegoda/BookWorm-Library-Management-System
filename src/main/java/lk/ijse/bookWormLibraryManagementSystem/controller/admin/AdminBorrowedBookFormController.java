package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.bookWormLibraryManagementSystem.controller.user.UserBorrowedBooksBarFormController;
import lk.ijse.bookWormLibraryManagementSystem.controller.user.UserBorrowedBooksFormController;
import lk.ijse.bookWormLibraryManagementSystem.controller.user.UserSignInFormController;
import lk.ijse.bookWormLibraryManagementSystem.dto.TransactionDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.TransactionService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminBorrowedBookFormController implements Initializable {

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

    TransactionService transactionService =
            (TransactionService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.TRANSACTION);

    private static AdminBorrowedBookFormController controller;

    public AdminBorrowedBookFormController() {
        controller = this;
    }

    public static AdminBorrowedBookFormController getInstance(){
        return controller;
    }

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

    public void allBorrowedTransactionId() {
        vBoxBorrowedBooks.getChildren().clear();
        List<TransactionDto> list = transactionService.getTransactionAllId();
        if (list == null) return;

        for (TransactionDto dto : list) {
            if (dto.getTransactionType().equals("borrow")) loadDataTable(dto.getId());
        }
    }

    private void loadDataTable(int id) {
        try {
            FXMLLoader loader = new FXMLLoader(AdminBorrowedBookFormController.class.getResource("/view/adminBorrowedBookBarForm.fxml"));
            Parent root = loader.load();
            AdminBorrowedBookBarFormController controller = loader.getController();
            controller.setData(id);
            vBoxBorrowedBooks.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allBorrowedTransactionId();
    }

}
