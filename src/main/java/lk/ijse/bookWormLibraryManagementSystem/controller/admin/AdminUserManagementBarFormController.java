package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.UserService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.StyleUtil;

import java.io.IOException;

public class AdminUserManagementBarFormController {

    @FXML
    private ImageView imgDelete;

    @FXML
    private ImageView imgEdit;

    @FXML
    private ImageView imgView;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblUsername;

    public static int userId;

    UserService userService =
            (UserService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.USER);

    @FXML
    void imgDeleteOnMouseClicked(MouseEvent event) throws IOException {
        DeleteConfirmationFormController.objectName = "user";
        DeleteConfirmationFormController.id = Integer.parseInt(lblId.getText());
        Navigation.imgPopUpBackground("deleteConfirmationForm.fxml");
    }

    @FXML
    void imgDeleteOnMouseEntered(MouseEvent event) {
        StyleUtil.deleteImgSelected(imgDelete);
    }

    @FXML
    void imgDeleteOnMouseExited(MouseEvent event) {
        StyleUtil.deleteImgUnselected(imgDelete);
    }

    @FXML
    void imgEditOnMouseClicked(MouseEvent event) throws IOException {
        userId = Integer.parseInt(lblId.getText());
        Navigation.imgPopUpBackground("updateUserPopUpForm.fxml");
    }

    @FXML
    void imgEditOnMouseEntered(MouseEvent event) {
        StyleUtil.updateImgSelected(imgEdit);
    }

    @FXML
    void imgEditOnMouseExited(MouseEvent event) {
        StyleUtil.updateImgUnselected(imgEdit);
    }

    @FXML
    void imgViewOnMouseClicked(MouseEvent event) throws IOException {
        userId = Integer.parseInt(lblId.getText());
        Navigation.imgPopUpBackground("viewUserPopUpForm.fxml");
    }

    @FXML
    void imgViewOnMouseEntered(MouseEvent event) {
        StyleUtil.viewImgSelected(imgView);
    }

    @FXML
    void imgViewOnMouseExited(MouseEvent event) {
        StyleUtil.viewImgUnselected(imgView);
    }

    public void setData(int id) {
        UserDto userDto = userService.getUserData(id);

        lblId.setText(String.valueOf(userDto.getId()));
        lblName.setText(userDto.getName());
        lblEmail.setText(userDto.getEmail());
        lblUsername.setText(userDto.getUsername());
    }

}
