package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class AdminGlobalFormController {

    @FXML
    private Pane booksPane;

    @FXML
    private Pane branchesPane;

    @FXML
    private Pane catalogPane;

    @FXML
    private Pane dashboardPane;

    @FXML
    private ImageView imgBooks;

    @FXML
    private ImageView imgBranches;

    @FXML
    private ImageView imgCatalog;

    @FXML
    private ImageView imgDashboard;

    @FXML
    private ImageView imgLogOut;

    @FXML
    private ImageView imgTransparent;

    @FXML
    private ImageView imgUsers;

    @FXML
    private Label lblBooks;

    @FXML
    private Label lblBranches;

    @FXML
    private Label lblCatalog;

    @FXML
    private Label lblDashboard;

    @FXML
    private Label lblLogOut;

    @FXML
    private Label lblUsers;

    @FXML
    private Pane logOutPane;

    @FXML
    private Pane pagingPane;

    @FXML
    private Pane popUpLargePane;

    @FXML
    private Pane popUpPane;

    @FXML
    private Pane usersPane;

    @FXML
    void btnBooksOnAction(ActionEvent event) {

    }

    @FXML
    void btnBooksOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBooksOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) {

    }

    @FXML
    void btnBranchesOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBranchesOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnCatalogOnAction(ActionEvent event) {

    }

    @FXML
    void btnCatalogOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCatalogOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnChangeCredentialsOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashboardOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnDashboardOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("adminSignInForm.fxml", event);
    }

    @FXML
    void btnLogOutOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnLogOutOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnUsersOnAction(ActionEvent event) {

    }

    @FXML
    void btnUsersOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnUsersOnMouseExited(MouseEvent event) {

    }

}
