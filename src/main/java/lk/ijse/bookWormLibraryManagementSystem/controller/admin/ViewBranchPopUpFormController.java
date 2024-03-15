package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.dto.BranchDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.BranchService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.StyleUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewBranchPopUpFormController implements Initializable {

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
    private Label lblId;

    @FXML
    private Label lblLocation;

    @FXML
    private Label lblName;

    @FXML
    private Label lblSavedBy;

    BranchService branchService =
            (BranchService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.BRANCH);

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
        BranchDto branchDto = branchService
                .getBranchData(AdminBranchManagementBarFormController.branchId);

        lblId.setText(String.valueOf(branchDto.getId()));
        lblName.setText(branchDto.getName());
        lblContactNo.setText(branchDto.getContactNo());
        lblLocation.setText(branchDto.getLocation());
        lblSavedBy.setText(
                branchDto.getAdmin().getName().getFirstName() + " " +
                        branchDto.getAdmin().getName().getLastName()
        );
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }

}
