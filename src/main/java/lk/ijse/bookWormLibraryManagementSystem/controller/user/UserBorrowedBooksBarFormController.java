package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class UserBorrowedBooksBarFormController {

    @FXML
    private Label lblAmount;

    @FXML
    private Label lblDateAndTime;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblId;

    @FXML
    private Label lblReturn;

    @FXML
    private ImageView returnBtnImg;

    @FXML
    private Pane returnBtnPane;

    @FXML
    void btnReturnOnAction(ActionEvent event) throws IOException {
        Navigation.imgPopUpBackground("userReturnBookConfirmPopUpForm.fxml");
    }

    @FXML
    void btnReturnOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnReturnOnMouseExited(MouseEvent event) {

    }

}
