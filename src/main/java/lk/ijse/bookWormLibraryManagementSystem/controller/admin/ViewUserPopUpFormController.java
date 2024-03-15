package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.UserService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.StyleUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewUserPopUpFormController implements Initializable {

    @FXML
    private Pane closePane;

    @FXML
    private Pane exitPane;

    @FXML
    private ImageView imgExit;

    @FXML
    private Label lblClose;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblSavedBy;

    @FXML
    private Label lblUsername;

    UserService userService =
            (UserService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.USER);

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnCloseOnMouseEntered(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnSelected(closePane, lblClose);
    }

    @FXML
    void btnCloseOnMouseExited(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnUnselected(closePane, lblClose);
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnExitOnMouseEntered(MouseEvent event) {
        StyleUtil.closeIconBtnSelected(exitPane, imgExit);
    }

    @FXML
    void btnExitOnMouseExited(MouseEvent event) {
        StyleUtil.closeIconBtnUnselected(exitPane, imgExit);
    }

    public void setData() {
        UserDto userDto = userService
                .getUserData(AdminUserManagementBarFormController.userId);

        lblId.setText(String.valueOf(userDto.getId()));
        lblName.setText(userDto.getName());
        lblEmail.setText(userDto.getEmail());
        lblUsername.setText(userDto.getUsername());
        lblSavedBy.setText(
                userDto.getAdmin().getName().getFirstName() + " " +
                        userDto.getAdmin().getName().getLastName()
        );
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }

}
