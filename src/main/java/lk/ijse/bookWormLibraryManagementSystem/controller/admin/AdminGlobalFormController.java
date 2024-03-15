package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lk.ijse.bookWormLibraryManagementSystem.util.DateTimeUtil;
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
    private Label lblAdmin;

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
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    public Pane pagingPane;

    @FXML
    public Pane popUpLargePane;

    @FXML
    public Pane popUpPane;

    @FXML
    public Pane settingsPane;

    @FXML
    private Pane usersPane;

    private static AdminGlobalFormController controller;

    public AdminGlobalFormController() {
        controller = this;
    }

    public static AdminGlobalFormController getInstance() {
        return controller;
    }

    private boolean dashboardButtonSelected = false;
    private boolean catalogButtonSelected = false;
    private boolean booksButtonSelected = false;
    private boolean usersButtonSelected = false;
    private boolean branchesButtonSelected = false;
    private boolean logOutButtonSelected = false;

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        buttonUnSelected();
        dashboardButtonSelected = true;
        unSelectedButtons();
        selectedButton(dashboardPane, lblDashboard, imgDashboard, "dashboardIconBlack.png");
        Navigation.switchPaging(pagingPane, "adminDashboardForm.fxml");
    }

    @FXML
    void btnCatalogOnAction(ActionEvent event) throws IOException {
        buttonUnSelected();
        catalogButtonSelected = true;
        unSelectedButtons();
        selectedButton(catalogPane, lblCatalog, imgCatalog, "catalogIconBlack.png");
        Navigation.switchPaging(pagingPane, "adminBorrowedBookForm.fxml");
    }

    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        buttonUnSelected();
        booksButtonSelected = true;
        unSelectedButtons();
        selectedButton(booksPane, lblBooks, imgBooks, "booksIconBlack.png");
        Navigation.switchPaging(pagingPane, "adminBookManagementForm.fxml");
    }

    @FXML
    void btnUsersOnAction(ActionEvent event) throws IOException {
        buttonUnSelected();
        usersButtonSelected = true;
        unSelectedButtons();
        selectedButton(usersPane ,lblUsers, imgUsers, "usersIconBlack.png");
        Navigation.switchPaging(pagingPane, "adminUserManagementForm.fxml");
    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) throws IOException {
        buttonUnSelected();
        branchesButtonSelected = true;
        unSelectedButtons();
        selectedButton(branchesPane, lblBranches, imgBranches, "branchesIconBlack.png");
        Navigation.switchPaging(pagingPane, "adminBranchManagementForm.fxml");
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        selectedButton(logOutPane, lblLogOut, imgLogOut, "logOutIconBlack.png");
        Navigation.close(event);
        Navigation.switchNavigation("adminSignInGlobalForm.fxml", event);
    }

    @FXML
    void btnDashboardOnMouseEntered(MouseEvent event) {
        if(!dashboardButtonSelected) allBtnHoverCss(dashboardPane,
                lblDashboard, imgDashboard, "dashboardIconBlack.png");
    }

    @FXML
    void btnDashboardOnMouseExited(MouseEvent event) {
        if(!dashboardButtonSelected) btnUnselected(dashboardPane,
                lblDashboard, imgDashboard, "dashboardIconWhite.png");
    }

    @FXML
    void btnCatalogOnMouseEntered(MouseEvent event) {
        if(!catalogButtonSelected) allBtnHoverCss(catalogPane,
                lblCatalog, imgCatalog, "catalogIconBlack.png");
    }

    @FXML
    void btnCatalogOnMouseExited(MouseEvent event) {
        if(!catalogButtonSelected) btnUnselected(catalogPane,
                lblCatalog, imgCatalog, "catalogIconWhite.png");
    }

    @FXML
    void btnBooksOnMouseEntered(MouseEvent event) {
        if(!booksButtonSelected) allBtnHoverCss(booksPane,
                lblBooks, imgBooks, "booksIconBlack.png");
    }

    @FXML
    void btnBooksOnMouseExited(MouseEvent event) {
        if(!booksButtonSelected) btnUnselected(booksPane,
                lblBooks, imgBooks, "booksIconWhite.png");
    }

    @FXML
    void btnUsersOnMouseEntered(MouseEvent event) {
        if(!usersButtonSelected) allBtnHoverCss(usersPane,
                lblUsers, imgUsers, "usersIconBlack.png");
    }

    @FXML
    void btnUsersOnMouseExited(MouseEvent event) {
        if(!usersButtonSelected) btnUnselected(usersPane,
                lblUsers, imgUsers, "usersIconWhite.png");
    }

    @FXML
    void btnBranchesOnMouseEntered(MouseEvent event) {
        if(!branchesButtonSelected) allBtnHoverCss(branchesPane,
                lblBranches, imgBranches, "branchesIconBlack.png");
    }

    @FXML
    void btnBranchesOnMouseExited(MouseEvent event) {
        if(!branchesButtonSelected) btnUnselected(branchesPane,
                lblBranches, imgBranches, "branchesIconWhite.png");
    }

    @FXML
    void btnLogOutOnMouseEntered(MouseEvent event) {
        if(!logOutButtonSelected) allBtnHoverCss(logOutPane,
                lblLogOut, imgLogOut, "logOutIconBlack.png");
    }

    @FXML
    void btnLogOutOnMouseExited(MouseEvent event) {
        if(!logOutButtonSelected) btnUnselected(logOutPane,
                lblLogOut, imgLogOut, "logOutIconWhite.png");
    }

    @FXML
    void btnSettingsOnAction(ActionEvent event) throws IOException {
        if (AdminGlobalFormController.getInstance().settingsPane.isVisible()) {
            Navigation.closeAdminSettingsPane();
        } else {
            Navigation.imgPopUpBackground("adminSettingsPopUpForm.fxml");
        }
    }

    private void buttonUnSelected() {
        dashboardButtonSelected = false;
        catalogButtonSelected = false;
        booksButtonSelected = false;
        usersButtonSelected = false;
        branchesButtonSelected = false;
        logOutButtonSelected = false;
    }

    private void unSelectedButtons() {
        btnUnselected(dashboardPane, lblDashboard, imgDashboard, "dashboardIconWhite.png");
        btnUnselected(catalogPane, lblCatalog, imgCatalog, "catalogIconWhite.png");
        btnUnselected(booksPane, lblBooks, imgBooks, "booksIconWhite.png");
        btnUnselected(usersPane, lblUsers, imgUsers, "usersIconWhite.png");
        btnUnselected(branchesPane, lblBranches, imgBranches, "branchesIconWhite.png");
    }

    private void selectedButton(Pane pane, Label label, ImageView imageView, String path) {
        btnSelected(pane, label, imageView, path);
    }

    void btnSelected(Pane pane, Label label, ImageView imageView, String path) {
        pane.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 1px;");
        label.setStyle("-fx-text-fill: black;" +
                "-fx-font-size: 16px");
        imageView.setImage(new Image("assests/icon/" + path));
    }

    void btnUnselected(Pane pane, Label label, ImageView imageView, String path) {
        pane.setStyle(
                "-fx-background-radius: 1px;");
        label.setStyle("-fx-font-weight: 500;" +
                "-fx-font-size: 16px;" +
                "-fx-text-fill: white;");
        imageView.setImage(new Image("assests/icon/" + path));
    }

    void allBtnHoverCss(Pane pane, Label label, ImageView imageView, String path){
        pane.setStyle("-fx-background-color: #D7D7D7;" +
                        "-fx-background-radius: 1px;");
        label.setStyle("-fx-text-fill: black;" +
                "-fx-font-size: 16px");
        imageView.setImage(new Image("assests/icon/" + path));
    }

    private void loadDashboardForm() {
        try {
            Navigation.switchPaging(pagingPane, "adminDashboardForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setAdminName() {
        lblAdmin.setText(
                AdminSignInFormController.admin.getName().getFirstName() + " " +
                        AdminSignInFormController.admin.getName().getLastName()
        );
    }

    private void updateClock() {
        lblTime.setText(DateTimeUtil.timeNow());
    }

    private void setTimeLine() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateClock()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void initializeData() {
        dashboardButtonSelected = true;
        btnSelected(dashboardPane, lblDashboard, imgDashboard, "dashboardIconBlack.png");
        pagingPane.setVisible(true);
        setAdminName();
        setTimeLine();
        lblDate.setText(DateTimeUtil.dateNowFormatted());
        loadDashboardForm();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeData();
    }

}
