package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.DeleteService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

public class DeleteConfirmationFormController {

    @FXML
    private Pane closePane;

    @FXML
    private Pane confirmPane;

    @FXML
    private ImageView imgClose;

    @FXML
    private Label lblConfirm;

    public static String objectName;
    public static int id;

    DeleteService deleteService =
            (DeleteService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.DELETE);

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
    void btnConfirmOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnConfirmOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnConfirmOnAction(ActionEvent event) {
        switch (objectName) {
            case "admin":
                if (deleteService.deleteAdmin(id)) {
//                AdminBookManagementFormController.getInstance().allBookId();
                    Navigation.closePopUpPane();
                } else System.out.println("Unable to Delete Admin!");
                break;
            case "book":
                if (deleteService.deleteBook(id)) {
                    AdminBookManagementFormController.getInstance().allBookId();
                    Navigation.closePopUpPane();
                } else System.out.println("Unable to Delete Book!");
                break;
            case "branch":
                if (deleteService.deleteBranch(id)) {
//                AdminBookManagementFormController.getInstance().allBookId();
                    Navigation.closePopUpPane();
                } else System.out.println("Unable to Delete Branch!");
                break;
            case "user":
                if (deleteService.deleteUser(id)) {
//                AdminBookManagementFormController.getInstance().allBookId();
                    Navigation.closePopUpPane();
                } else System.out.println("Unable to Delete User!");
                break;
        }
    }

}
