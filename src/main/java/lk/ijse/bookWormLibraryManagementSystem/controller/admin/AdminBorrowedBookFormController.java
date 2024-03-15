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
import lk.ijse.bookWormLibraryManagementSystem.util.RegExPatterns;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminBorrowedBookFormController implements Initializable {

    @FXML
    private Pane OverdueBorrowersPane;

    @FXML
    private Pane btnRefreshPane;

    @FXML
    private Label lblOverdueBorrowers;

    @FXML
    private Label lblSearchAlert;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxBorrowedBooks;

    private List<TransactionDto> list;

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
    void btnRefreshTableOnAction(ActionEvent event) {
        lblSearchAlert.setText(" ");
        allBorrowedTransactionId();
    }

    @FXML
    void btnRefreshTableOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnRefreshTableOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {
        List<TransactionDto> selectedDtoList = new ArrayList<>();
        if (validateSearch()) {
            for (TransactionDto dto : list) {
                if (txtSearch.getText().equals(String.valueOf(dto.getUser().getId()))
                        || txtSearch.getText().equalsIgnoreCase(dto.getUser().getUsername())) {
                    if (dto.getTransactionType().equals("borrow")) selectedDtoList.add(dto);
                }
            }
        }
        if (!selectedDtoList.isEmpty()) {
            allSelectedTransactionId(selectedDtoList);
            lblSearchAlert.setText(" ");
        }
        txtSearch.clear();
    }

    private boolean validateSearch() {
        if (validateName() & validateId()) {
            lblSearchAlert.setText("Invalid User Id Or Username!!");
            return false;
        }
        return true;
    }

    public boolean validateName() {
        return RegExPatterns.namePattern(txtSearch.getText());
    }

    public boolean validateId() {
        return RegExPatterns.idPattern(txtSearch.getText());
    }

    @FXML
    void txtSearchOnMouseMoved(MouseEvent event) {
        lblSearchAlert.setText(" ");
    }

    public void allSelectedTransactionId(List<TransactionDto> selectedDtoList) {
        vBoxBorrowedBooks.getChildren().clear();

        for (TransactionDto selectedDto : selectedDtoList) {
            loadDataTable(selectedDto.getId());
        }
    }

    public void allBorrowedTransactionId() {
        vBoxBorrowedBooks.getChildren().clear();
        list = transactionService.getTransactionAllId();
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
