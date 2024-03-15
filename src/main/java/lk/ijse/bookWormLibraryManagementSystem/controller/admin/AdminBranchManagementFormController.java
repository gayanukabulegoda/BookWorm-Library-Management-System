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
import lk.ijse.bookWormLibraryManagementSystem.dto.BranchDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.BranchService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.RegExPatterns;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminBranchManagementFormController implements Initializable {

    @FXML
    private Pane AddBranchPane;

    @FXML
    private ImageView imgAdd;

    @FXML
    private Label lblAddBranch;

    @FXML
    private Label lblSearchAlert;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxBranchManage;

    private List<BranchDto> list;

    BranchService branchService =
            (BranchService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.BRANCH);

    private static AdminBranchManagementFormController controller;

    public AdminBranchManagementFormController() {
        controller = this;
    }

    public static AdminBranchManagementFormController getInstance() {
        return controller;
    }

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
    void txtSearchOnAction(ActionEvent event) throws IOException {
        if (validateSearch()) {
            for (BranchDto dto : list) {
                if (txtSearch.getText().equals(String.valueOf(dto.getId()))
                        || txtSearch.getText().equalsIgnoreCase(dto.getLocation())) {
                    AdminBranchManagementBarFormController.branchId = dto.getId();
                    Navigation.imgPopUpBackground("viewBranchPopUpForm.fxml");
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
            lblSearchAlert.setText("Invalid Id Or Location!!");
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

    public void allBranchId() {
        vBoxBranchManage.getChildren().clear();
        list = branchService.getAllBranchId();
        if (list == null) return;

        for (BranchDto dto : list) {
            loadDataTable(dto.getId());
        }
    }

    private void loadDataTable(int id) {
        try {
            FXMLLoader loader = new FXMLLoader(AdminBranchManagementFormController.class.getResource("/view/adminBranchManagementBarForm.fxml"));
            Parent root = loader.load();
            AdminBranchManagementBarFormController controller = loader.getController();
            controller.setData(id);
            vBoxBranchManage.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allBranchId();
    }

}
