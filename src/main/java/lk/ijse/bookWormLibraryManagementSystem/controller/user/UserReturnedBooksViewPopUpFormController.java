package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.bookWormLibraryManagementSystem.dto.TransactionDto;
import lk.ijse.bookWormLibraryManagementSystem.entity.TransactionDetail;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.TransactionService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.StyleUtil;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserReturnedBooksViewPopUpFormController implements Initializable {

    @FXML
    private Pane closePane;

    @FXML
    private Label lblClose;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblId;

    @FXML
    private Label lblTotalBooks;

    @FXML
    private VBox vBox;

    TransactionService transactionService =
            (TransactionService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.TRANSACTION);

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Navigation.closeUserPopUpLargePane();
    }

    @FXML
    void btnCloseOnMouseEntered(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnSelected(closePane, lblClose);
    }

    @FXML
    void btnCloseOnMouseExited(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnUnselected(closePane, lblClose);
    }

    public void allReturnedBookId() {
        setData();
        TransactionDto dto = transactionService
                .getTransactionData(UserReturnedBooksBarFormController.transactionId);

        List<TransactionDetail> transactionDetails = dto.getTransactionDetails();

        vBox.getChildren().clear();
        if (transactionDetails == null) return;

        for (TransactionDetail transactionDetail : transactionDetails) {
            loadDataTable(transactionDetail.getBook().getId());
        }
    }

    private void loadDataTable(int id) {
        try {
            FXMLLoader loader = new FXMLLoader(UserReturnedBooksViewPopUpFormController.class.getResource("/view/userReturnedBooksViewPopUpBarForm.fxml"));
            Parent root = loader.load();
            UserReturnedBooksViewPopUpBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setData() {
        TransactionDto transactionDto = transactionService
                .getTransactionData(UserReturnedBooksBarFormController.transactionId);

        lblDueDate.setText(transactionDto.getDueDate());
        lblId.setText(String.valueOf(transactionDto.getId()));
        lblTotalBooks.setText(String.valueOf(transactionDto.getBookQty()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allReturnedBookId();
    }

}
