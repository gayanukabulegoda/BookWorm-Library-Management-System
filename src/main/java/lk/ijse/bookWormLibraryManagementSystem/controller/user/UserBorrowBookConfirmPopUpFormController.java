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
import lk.ijse.bookWormLibraryManagementSystem.dto.BookDto;
import lk.ijse.bookWormLibraryManagementSystem.dto.TransactionDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.TransactionService;
import lk.ijse.bookWormLibraryManagementSystem.util.DateTimeUtil;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.StyleUtil;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserBorrowBookConfirmPopUpFormController implements Initializable {

    @FXML
    private Pane cancelPane;

    @FXML
    private Pane confirmPane;

    @FXML
    private Label lblCancel;

    @FXML
    private Label lblConfirm;

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

    private static UserBorrowBookConfirmPopUpFormController controller;

    public UserBorrowBookConfirmPopUpFormController() {
        controller = this;
    }

    public static UserBorrowBookConfirmPopUpFormController getInstance() {
        return controller;
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        UserBorrowBooksFormController.getInstance().borrowedBooks.clear();
        UserBorrowBooksFormController.getInstance().allBookId();
        Navigation.closeUserPopUpLargePane();
    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {
        StyleUtil.cancelBtnSelected(cancelPane, lblCancel);
    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {
        StyleUtil.cancelBtnUnselected(cancelPane, lblCancel);
    }

    @FXML
    void btnConfirmOnAction(ActionEvent event) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setTransactionType("borrow");
        transactionDto.setBookQty(Integer.parseInt(lblTotalBooks.getText()));
        transactionDto.setDueDate(lblDueDate.getText());
        transactionDto.setUser(UserSignInFormController.user);

        if (transactionService.saveTransaction(transactionDto)) {
            Navigation.closeUserPopUpLargePane();
            UserBorrowBooksFormController.getInstance().borrowedBooks.clear();
            UserBorrowBooksFormController.getInstance().allBookId();
            //AdminBorrowedBookFormController.getInstance().allBorrowedTransactionId();
        } else {
            System.out.println("Unable to save transaction!");
        }
    }

    @FXML
    void btnConfirmOnMouseEntered(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnSelected(confirmPane, lblConfirm);
    }

    @FXML
    void btnConfirmOnMouseExited(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnUnselected(confirmPane, lblConfirm);
    }

    public void allBorrowedBookId() {
        setData();
        List<BookDto> borrowedBooks = UserBorrowBooksFormController.getInstance().borrowedBooks;
        vBox.getChildren().clear();
        if (borrowedBooks == null) return;

        for (BookDto dto : borrowedBooks) {
            loadDataTable(dto.getId());
        }
    }

    private void loadDataTable(int id) {
        try {
            FXMLLoader loader = new FXMLLoader(UserBorrowBookConfirmPopUpFormController.class.getResource("/view/userBorrowBookConfirmPopUpBarForm.fxml"));
            Parent root = loader.load();
            UserBorrowBookConfirmPopUpBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setData() {
        lblDueDate.setText(DateTimeUtil.dateAfter15Days());
        lblId.setText(String.valueOf(transactionService.getLastTransactionId() + 1));
        lblTotalBooks.setText(
                String.valueOf(UserBorrowBooksFormController.getInstance().borrowedBooks.size()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allBorrowedBookId();
    }

}
