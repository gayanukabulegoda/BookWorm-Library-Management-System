package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.ijse.bookWormLibraryManagementSystem.dto.TransactionDto;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class AdminDashboardOverdueBorrowersBarFormController {

    @FXML
    private Label lblTransactionId;

    @FXML
    private Label lblUserName;

    @FXML
    void btnViewTransactionOnAction(ActionEvent event) throws IOException {
        AdminOverdueBorrowersBarFormController.transactionId = Integer.parseInt(lblTransactionId.getText());
        Navigation.imgPopUpBackground("adminOverdueBooksViewPopUpForm.fxml");
    }

    public void setData(TransactionDto dto) {
        lblTransactionId.setText(String.valueOf(dto.getId()));
        lblUserName.setText(dto.getUser().getName());
    }

}
