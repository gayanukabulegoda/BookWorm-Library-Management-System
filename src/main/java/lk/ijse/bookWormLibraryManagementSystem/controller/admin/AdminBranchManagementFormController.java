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

public class AdminBranchManagementFormController {

    @FXML
    private Pane AddBranchPane;

    @FXML
    private ImageView imgAdd;

    @FXML
    private Label lblAddBranch;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxBranchManage;

    @FXML
    void btnAddBranchOnAction(ActionEvent event) throws IOException {
        Navigation.imgPopUpBackground("addBranchPopUpForm.fxml");
    }

    @FXML
    void btnAddBranchOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddBranchOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

}
