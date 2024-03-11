package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lk.ijse.bookWormLibraryManagementSystem.util.DateTimeUtil;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserGlobalFormController implements Initializable {

    @FXML
    private Pane booksPane;

    @FXML
    private Pane catalogPane;

    @FXML
    private Pane dashboardPane;

    @FXML
    private ImageView imgBooks;

    @FXML
    private ImageView imgCatalog;

    @FXML
    private ImageView imgDashboard;

    @FXML
    private ImageView imgLogOut;

    @FXML
    public ImageView imgTransparent;

    @FXML
    private Label lblUser;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Pane logOutPane;

    @FXML
    public Pane pagingPane;

    @FXML
    public Pane popUpLargePane;

    @FXML
    public Pane popUpPane;

    @FXML
    public Pane settingsPane;

    private static UserGlobalFormController controller;

    public UserGlobalFormController() {
        controller = this;
    }

    public static UserGlobalFormController getInstance() {
        return controller;
    }

    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "userBorrowBooksForm.fxml");
    }

    @FXML
    void btnBooksOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBooksOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnCatalogOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "userBorrowedBooksForm.fxml");
    }

    @FXML
    void btnCatalogOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCatalogOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnSettingsOnAction(ActionEvent event) throws IOException {
        if (UserGlobalFormController.getInstance().settingsPane.isVisible()) {
            Navigation.closeUserSettingsPane();
        } else {
            Navigation.imgPopUpBackground("userSettingsPopUpForm.fxml");
        }
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(pagingPane, "userDashboardForm.fxml");
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
        Navigation.switchNavigation("userSignInGlobalForm.fxml", event);
    }

    @FXML
    void btnLogOutOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnLogOutOnMouseExited(MouseEvent event) {

    }

    private void loadDashboardForm() {
        try {
            Navigation.switchPaging(pagingPane, "userDashboardForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setUserName() {
        lblUser.setText(UserSignInFormController.user.getName());
    }

    private void updateClock() {
        lblTime.setText(DateTimeUtil.timeNow());
    }

    private void setTimeLine() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateClock()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pagingPane.setVisible(true);
        setUserName();
        setTimeLine();
        lblDate.setText(DateTimeUtil.dateNowFormatted());
        loadDashboardForm();
    }

}
