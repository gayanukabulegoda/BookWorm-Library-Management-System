package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.dto.BranchDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.BranchService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateBranchPopUpFormController implements Initializable {

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
    private TextField txtContactNo;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtName;

    @FXML
    private Pane updatePane;

    private BranchDto branchData;

    BranchService branchService =
            (BranchService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.BRANCH);

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {

    }

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
    void btnUpdateOnAction(ActionEvent event) {
        BranchDto branchDto = new BranchDto();
        branchDto.setName(txtName.getText());
        branchDto.setContactNo(txtContactNo.getText());
        branchDto.setLocation(txtLocation.getText());
        branchDto.setAdmin(AdminSignInFormController.admin);

        branchDto.setId(branchData.getId());

        if (branchService.updateBranch(branchDto)) {
            Navigation.closePopUpPane();
            AdminBranchManagementFormController.getInstance().allBranchId();
        } else {
            System.out.println("Unable to update branch!");
        }
    }

    @FXML
    void btnUpdateOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnUpdateOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtContactNoOnAction(ActionEvent event) {
        txtLocation.requestFocus();
    }

    @FXML
    void txtLocationOnAction(ActionEvent event) {
        btnUpdateOnAction(event);
    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtContactNo.requestFocus();
    }

    public void setData() {
        branchData = branchService
                .getBranchData(AdminBranchManagementBarFormController.branchId);

        txtName.setText(branchData.getName());
        txtContactNo.setText(branchData.getContactNo());
        txtLocation.setText(branchData.getLocation());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }

}
