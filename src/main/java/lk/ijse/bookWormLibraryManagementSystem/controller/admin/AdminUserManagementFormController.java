package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.UserService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.RegExPatterns;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminUserManagementFormController implements Initializable {

    @FXML
    private Pane AddUserPane;

    @FXML
    private ImageView imgAdd;

    @FXML
    private Label lblAddUser;

    @FXML
    private Label lblSearchAlert;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxUserManage;

    private List<UserDto> list;

    UserService userService =
            (UserService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.USER);

    private static AdminUserManagementFormController controller;

    public AdminUserManagementFormController() {
        controller = this;
    }

    public static AdminUserManagementFormController getInstance() {
        return controller;
    }

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
    void txtSearchOnAction(ActionEvent event) throws IOException {
        if (validateSearch()) {
            for (UserDto dto : list) {
                if (txtSearch.getText().equals(String.valueOf(dto.getId()))
                        || txtSearch.getText().equalsIgnoreCase(dto.getUsername())) {
                    AdminUserManagementBarFormController.userId = dto.getId();
                    Navigation.imgPopUpBackground("viewUserPopUpForm.fxml");
                    lblSearchAlert.setText(" ");
                    txtSearch.clear();
                    return;
                }
            }
        }
        txtSearch.clear();
    }

    private boolean validateSearch() {
        if (validateName() & validateId()) {
            lblSearchAlert.setText("Invalid Id Or Username!!");
            return false;
        }
        return true;
    }

    public boolean validateName() {
        return RegExPatterns.namePattern(txtSearch.getText());
    }

    public boolean validateId() {
        return RegExPatterns.idPattern(txtSearch.getText());
    }

    @FXML
    void txtSearchOnMouseMoved(MouseEvent event) {
        lblSearchAlert.setText(" ");
    }

    public void allUserId() {
        vBoxUserManage.getChildren().clear();
        list = userService.getAllUserId();
        if (list == null) return;

        for (UserDto dto : list) {
            loadDataTable(dto.getId());
        }
    }

    private void loadDataTable(int id) {
        try {
            FXMLLoader loader = new FXMLLoader(AdminUserManagementFormController.class.getResource("/view/adminUserManagementBarForm.fxml"));
            Parent root = loader.load();
            AdminUserManagementBarFormController controller = loader.getController();
            controller.setData(id);
            vBoxUserManage.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allUserId();
    }

}
