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
import lk.ijse.bookWormLibraryManagementSystem.dto.TransactionDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.TransactionService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminOverdueBorrowersFormController implements Initializable {

    @FXML
    private Pane borrowedBooksPane;

    @FXML
    private Label lblBorrowedBooks;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxOverdueBorrowers;

    TransactionService transactionService =
            (TransactionService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.TRANSACTION);

    @FXML
    void btnBorrowedBooksOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(
                AdminGlobalFormController.getInstance().pagingPane, "adminBorrowedBookForm.fxml");
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

    public void allOverDueBorrowers() {
        vBoxOverdueBorrowers.getChildren().clear();
        List<TransactionDto> list = transactionService.getAllOverDueBorrowers();
        if (list == null) return;

        for (TransactionDto dto : list) {
            loadDataTable(dto.getId());
        }
    }

    private void loadDataTable(int id) {
        try {
            FXMLLoader loader = new FXMLLoader(AdminOverdueBorrowersFormController.class.getResource("/view/adminOverdueBorrowersBarForm.fxml"));
            Parent root = loader.load();
            AdminOverdueBorrowersBarFormController controller = loader.getController();
            controller.setData(id);
            vBoxOverdueBorrowers.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allOverDueBorrowers();
    }

}
