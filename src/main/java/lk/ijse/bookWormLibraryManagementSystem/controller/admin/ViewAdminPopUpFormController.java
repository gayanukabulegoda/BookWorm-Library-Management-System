package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.dto.AdminDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.AdminService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewAdminPopUpFormController implements Initializable {

    @FXML
    private Pane closePane;

    @FXML
    private Pane exitPane;

    @FXML
    private ImageView imgExit;

    @FXML
    private Label lblClose;

    @FXML
    private Label lblContactNo;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblUsername;

    public static int adminId;

    AdminService adminService =
            (AdminService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.ADMIN);

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnCloseOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCloseOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnExitOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnExitOnMouseExited(MouseEvent event) {

    }

    public void setData() {
        AdminDto dto = adminService.getAdminData(adminId);

        lblId.setText(String.valueOf(dto.getId()));
        lblContactNo.setText(dto.getContactNo());
        lblEmail.setText(dto.getEmail());
        lblUsername.setText(dto.getUsername());
        lblName.setText(
                dto.getName().getFirstName() + " " +
                dto.getName().getLastName()
        );
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }

}
