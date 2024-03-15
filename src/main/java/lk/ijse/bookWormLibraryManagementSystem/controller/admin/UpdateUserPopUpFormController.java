package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.UserService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.RegExPatterns;
import lk.ijse.bookWormLibraryManagementSystem.util.StyleUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateUserPopUpFormController implements Initializable {

    @FXML
    private Pane cancelPane;

    @FXML
    private Pane closePane;

    @FXML
    private ImageView imgClose;

    @FXML
    private Label lblCancel;

    @FXML
    private Label lblUpdate;

    @FXML
    private Label lblEmailAlert;

    @FXML
    private Label lblNameAlert;

    @FXML
    private Label lblPasswordAlert;

    @FXML
    private Label lblUsernameAlert;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private Pane updatePane;

    private UserDto userData;

    UserService userService =
            (UserService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.USER);

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {
        StyleUtil.cancelBtnSelected(cancelPane, lblCancel);
    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {
        StyleUtil.cancelBtnUnselected(cancelPane, lblCancel);
    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnCloseOnMouseEntered(MouseEvent event) {
        StyleUtil.closeIconBtnSelected(closePane, imgClose);
    }

    @FXML
    void btnCloseOnMouseExited(MouseEvent event) {
        StyleUtil.closeIconBtnUnselected(closePane, imgClose);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (validateUser()) {
            UserDto userDto = new UserDto();
            userDto.setName(txtName.getText());
            userDto.setEmail(txtEmail.getText());
            userDto.setUsername(txtUsername.getText());
            userDto.setPassword(txtPassword.getText());
            userDto.setAdmin(AdminSignInFormController.admin);

            userDto.setId(userData.getId());

            if (userService.updateUser(userDto)) {
                Navigation.closePopUpPane();
                AdminUserManagementFormController.getInstance().allUserId();
            } else {
                System.out.println("Unable to update user!");
            }
        }
    }

    private boolean validateUser() {
        boolean isValid = true;

        if (RegExPatterns.namePattern(txtName.getText())) {
            lblNameAlert.setText("Invalid Name!!");
            isValid = false;
        }

        if (RegExPatterns.emailPattern(txtEmail.getText())) {
            lblEmailAlert.setText("Invalid Email!!");
            isValid = false;
        }

        if (RegExPatterns.namePattern(txtUsername.getText())) {
            lblUsernameAlert.setText("Invalid Username!!");
            isValid = false;
        }

        if (RegExPatterns.passwordPattern(txtPassword.getText())) {
            lblPasswordAlert.setText("Invalid Password!!");
            isValid = false;
        }
        return isValid;
    }

    @FXML
    void btnUpdateOnMouseEntered(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnSelected(updatePane, lblUpdate);
    }

    @FXML
    void btnUpdateOnMouseExited(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnUnselected(updatePane, lblUpdate);
    }

    @FXML
    void txtEmailOnAction(ActionEvent event) {
        txtUsername.requestFocus();
    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtEmail.requestFocus();
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {
        btnUpdateOnAction(event);
    }

    @FXML
    void txtUsernameOnAction(ActionEvent event) {
        txtPassword.requestFocus();
    }

    @FXML
    void txtNameOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.namePattern(txtName.getText())) {
            lblNameAlert.setText("Invalid Name!!");
        } else lblNameAlert.setText(" ");
    }

    @FXML
    void txtEmailOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.emailPattern(txtEmail.getText())) {
            lblEmailAlert.setText("Invalid Email!!");
        } else lblEmailAlert.setText(" ");
    }

    @FXML
    void txtUsernameOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.namePattern(txtUsername.getText())) {
            lblUsernameAlert.setText("Invalid Username!!");
        } else lblUsernameAlert.setText(" ");
    }

    @FXML
    void txtPasswordOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.passwordPattern(txtPassword.getText())) {
            lblPasswordAlert.setText("Invalid Password!!");
        } else lblPasswordAlert.setText(" ");
    }

    public void setData() {
        userData = userService
                .getUserData(AdminUserManagementBarFormController.userId);

        txtName.setText(userData.getName());
        txtEmail.setText(userData.getEmail());
        txtUsername.setText(userData.getUsername());
        txtPassword.setText(userData.getPassword());

        txtPassword.setEditable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }

}
