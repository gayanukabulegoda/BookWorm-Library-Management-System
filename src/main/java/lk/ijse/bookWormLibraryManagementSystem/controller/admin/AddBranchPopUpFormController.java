package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class AddBranchPopUpFormController {

    @FXML
    private Pane addPane;

    @FXML
    private Pane cancelPane;

    @FXML
    private Pane closePane;

    @FXML
    private ImageView imgClose;

    @FXML
    private Label lblAdd;

    @FXML
    private Label lblCancel;

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

    BranchService branchService =
            (BranchService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.BRANCH);

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (validateBranch()) {
            BranchDto branchDto = new BranchDto();
            branchDto.setName(txtName.getText());
            branchDto.setLocation(txtLocation.getText());
            branchDto.setContactNo(txtContactNo.getText());
            branchDto.setAdmin(AdminSignInFormController.admin);

            if (branchService.saveBranch(branchDto)) {
                Navigation.closePopUpPane();
                AdminBranchManagementFormController.getInstance().allBranchId();
            } else {
                System.out.println("Unable to save branch!");
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
    void btnAddOnMouseEntered(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnSelected(addPane, lblAdd);
    }

    @FXML
    void btnAddOnMouseExited(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnUnselected(addPane, lblAdd);
    }

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
    void txtContactNoOnAction(ActionEvent event) {
        txtLocation.requestFocus();
    }

    @FXML
    void txtLocationOnAction(ActionEvent event) {
        btnAddOnAction(event);
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

}
