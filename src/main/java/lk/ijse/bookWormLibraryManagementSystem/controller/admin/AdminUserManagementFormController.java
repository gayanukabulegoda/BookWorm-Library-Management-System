package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class AdminUserManagementFormController {

    @FXML
    private Pane AddUserPane;

    @FXML
    private ImageView imgAdd;

    @FXML
    private Label lblAddUser;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxUserManage;

    @FXML
    void btnAddUserOnAction(ActionEvent event) throws IOException {
        Navigation.imgPopUpBackground("addUserPopUpForm.fxml");
    }

    @FXML
    void btnAddUserOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddUserOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
