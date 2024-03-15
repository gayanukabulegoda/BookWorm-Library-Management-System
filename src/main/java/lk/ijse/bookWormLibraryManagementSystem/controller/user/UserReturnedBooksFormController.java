package lk.ijse.bookWormLibraryManagementSystem.controller.user;

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
import lk.ijse.bookWormLibraryManagementSystem.util.RegExPatterns;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserReturnedBooksFormController implements Initializable {

    @FXML
    private Pane borrowedBooksPane;

    @FXML
    private Label lblBorrowedBooks;

    @FXML
    private Label lblSearchAlert;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxReturnedBooks;

    private List<TransactionDto> list;

    TransactionService transactionService =
            (TransactionService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.TRANSACTION);

    private static UserReturnedBooksFormController controller;

    public UserReturnedBooksFormController() {
        controller = this;
    }

    public static UserReturnedBooksFormController getInstance() {
        return controller;
    }

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
    void txtSearchOnAction(ActionEvent event) throws IOException {
        if (validateSearch()) {
            for (TransactionDto dto : list) {
                if (txtSearch.getText().equals(String.valueOf(dto.getId()))) {
                    if (dto.getTransactionType().equals("return") &&
                            dto.getUser().equals(UserSignInFormController.user)) {
                        UserReturnedBooksBarFormController.transactionId = dto.getId();
                        Navigation.imgPopUpBackground("userReturnedBooksViewPopUpForm.fxml");
                        lblSearchAlert.setText(" ");
                        txtSearch.clear();
                        return;
                    }
                }
            }
        }
        txtSearch.clear();
    }

    private boolean validateSearch() {
        if (validateId()) {
            lblSearchAlert.setText("Invalid Id!!");
            return false;
        }
        return true;
    }

    public boolean validateId() {
        return RegExPatterns.idPattern(txtSearch.getText());
    }

    @FXML
    void txtSearchOnMouseMoved(MouseEvent event) {
        lblSearchAlert.setText(" ");
    }

    public void allReturnedTransactionId() {
        vBoxReturnedBooks.getChildren().clear();
        list = transactionService.getTransactionAllId();
        if (list == null) return;

        for (TransactionDto dto : list) {
            if (dto.getTransactionType().equals("return") &&
                    dto.getUser().equals(UserSignInFormController.user)
            ) loadDataTable(dto.getId());
        }
    }

    private void loadDataTable(int id) {
        try {
            FXMLLoader loader = new FXMLLoader(UserReturnedBooksFormController.class.getResource("/view/userReturnedBooksBarForm.fxml"));
            Parent root = loader.load();
            UserReturnedBooksBarFormController controller = loader.getController();
            controller.setData(id);
            vBoxReturnedBooks.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allReturnedTransactionId();
    }

}
