package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminGlobalFormController implements Initializable {

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
    public ImageView imgTransparent;

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
    public Pane pagingPane;

    @FXML
    public Pane popUpLargePane;

    @FXML
    public Pane popUpPane;

    @FXML
    private Pane usersPane;

    private static AdminGlobalFormController controller;

    public AdminGlobalFormController() {
        controller = this;
    }

    public static AdminGlobalFormController getInstance() {
        return controller;
    }

    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "adminBookManagementForm.fxml");
    }

    @FXML
    void btnBooksOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBooksOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "adminBranchManagementForm.fxml");
    }

    @FXML
    void btnBranchesOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBranchesOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnCatalogOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "adminBorrowedBookForm.fxml");
    }

    @FXML
    void btnCatalogOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCatalogOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnChangeCredentialsOnAction(ActionEvent event) throws IOException {
        Navigation.imgPopUpBackground("adminChangeCredentialsPopUpForm.fxml");
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "adminDashboardForm.fxml");
    }

    @FXML
    void btnDashboardOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnDashboardOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Navigation.close(event);
        Navigation.switchNavigation("adminSignInGlobalForm.fxml", event);
    }

    @FXML
    void btnLogOutOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnLogOutOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnUsersOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "adminUserManagementForm.fxml");
    }

    @FXML
    void btnUsersOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnUsersOnMouseExited(MouseEvent event) {

    }

    private void loadDashboardForm() {
        try {
            Navigation.switchPaging(pagingPane, "adminDashboardForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pagingPane.setVisible(true);
        loadDashboardForm();
    }

}
