package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.bookWormLibraryManagementSystem.dto.BranchDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.BranchService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.StyleUtil;

import java.io.IOException;

public class AdminBranchManagementBarFormController {

    @FXML
    private ImageView imgDelete;

    @FXML
    private ImageView imgEdit;

    @FXML
    private ImageView imgView;

    @FXML
    private Label lblContactNo;

    @FXML
    private Label lblId;

    @FXML
    private Label lblLocation;

    @FXML
    private Label lblName;

    public static int branchId;

    BranchService branchService =
            (BranchService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.BRANCH);

    @FXML
    void imgDeleteOnMouseClicked(MouseEvent event) throws IOException {
        DeleteConfirmationFormController.objectName = "branch";
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
        branchId = Integer.parseInt(lblId.getText());
        Navigation.imgPopUpBackground("updateBranchPopUpForm.fxml");
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
        branchId = Integer.parseInt(lblId.getText());
        Navigation.imgPopUpBackground("viewBranchPopUpForm.fxml");
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
        BranchDto branchDto = branchService.getBranchData(id);

        lblId.setText(String.valueOf(branchDto.getId()));
        lblName.setText(branchDto.getName());
        lblLocation.setText(branchDto.getLocation());
        lblContactNo.setText(branchDto.getContactNo());
    }

}
