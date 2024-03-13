package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.bookWormLibraryManagementSystem.dto.TransactionDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.TransactionService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class UserReturnedBooksBarFormController {

    @FXML
    private ImageView imgView;

    @FXML
    private Label lblAmount;

    @FXML
    private Label lblBorrowedDate;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblId;

    public static int transactionId;

    TransactionService transactionService =
            (TransactionService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.TRANSACTION);

    @FXML
    void imgViewOnMouseClicked(MouseEvent event) throws IOException {
        transactionId = Integer.parseInt(lblId.getText());
        Navigation.imgPopUpBackground("userReturnedBooksViewPopUpForm.fxml");
    }

    @FXML
    void imgViewOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgViewOnMouseExited(MouseEvent event) {

    }

    public void setData(int id) {
        TransactionDto transactionDto = transactionService.getTransactionData(id);

        lblId.setText(String.valueOf(transactionDto.getId()));
        lblAmount.setText("0" + transactionDto.getBookQty());
        lblDueDate.setText(transactionDto.getDueDate());

        String[] split = String.valueOf(transactionDto.getDateAndTime()).split(" ");
        lblBorrowedDate.setText(split[0]);
    }

}
