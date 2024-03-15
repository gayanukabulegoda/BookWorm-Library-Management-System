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

public class AdminOverdueBorrowersFormController implements Initializable {

    @FXML
    private Pane borrowedBooksPane;

    @FXML
    private Pane btnRefreshPane;

    @FXML
    private Label lblBorrowedBooks;

    @FXML
    private Label lblSearchAlert;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxOverdueBorrowers;

    private List<TransactionDto> list;

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
    void btnRefreshTableOnAction(ActionEvent event) {
        lblSearchAlert.setText(" ");
        allOverDueBorrowers();
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
                    selectedDtoList.add(dto);
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
        vBoxOverdueBorrowers.getChildren().clear();

        for (TransactionDto selectedDto : selectedDtoList) {
            loadDataTable(selectedDto.getId());
        }
    }

    public void allOverDueBorrowers() {
        vBoxOverdueBorrowers.getChildren().clear();
        list = transactionService.getAllOverDueBorrowers();
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
