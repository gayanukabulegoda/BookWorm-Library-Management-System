package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;
import lk.ijse.bookWormLibraryManagementSystem.dto.BranchDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.BranchService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.RegExPatterns;
import lk.ijse.bookWormLibraryManagementSystem.util.StyleUtil;

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
    private Label lblContactNoAlert;

    @FXML
    private Label lblLocationAlert;

    @FXML
    private Label lblNameAlert;

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
        if (validateBranch()) {
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
    }

    private boolean validateBranch() {
        boolean isValid = true;

        if (RegExPatterns.namePattern(txtName.getText())) {
            lblNameAlert.setText("Invalid Name!!");
            isValid = false;
        }

        if (RegExPatterns.contactNoPattern(txtContactNo.getText())) {
            lblContactNoAlert.setText("Invalid Contact Number!!");
            isValid = false;
        }

        if (RegExPatterns.namePattern(txtLocation.getText())) {
            lblLocationAlert.setText("Invalid Location!!");
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

    @FXML
    void txtNameOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.namePattern(txtName.getText())) {
            lblNameAlert.setText("Invalid Name!!");
        } else lblNameAlert.setText(" ");
    }

    @FXML
    void txtContactNoOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.contactNoPattern(txtContactNo.getText())) {
            lblContactNoAlert.setText("Invalid Contact Number!!");
        } else lblContactNoAlert.setText(" ");
    }

    @FXML
    void txtLocationOnKeyPressed(KeyEvent event) {
        if (RegExPatterns.namePattern(txtLocation.getText())) {
            lblLocationAlert.setText("Invalid Location!!");
        } else lblLocationAlert.setText(" ");
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
