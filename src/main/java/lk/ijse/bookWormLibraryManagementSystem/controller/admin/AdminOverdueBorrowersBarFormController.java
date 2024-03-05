package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class AdminOverdueBorrowersBarFormController {

    @FXML
    private ImageView imgView;

    @FXML
    private Label lblAmount;

    @FXML
    private Label lblDateAndTime;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblId;

    @FXML
    private Label lblUserId;

    @FXML
    void imgViewOnMouseClicked(MouseEvent event) throws IOException {
        Navigation.imgPopUpBackground("adminOverdueBooksViewPopUpForm.fxml");
    }

    @FXML
    void imgViewOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgViewOnMouseExited(MouseEvent event) {

    }

}
