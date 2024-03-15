package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.DeleteService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.SendMail;
import lk.ijse.bookWormLibraryManagementSystem.util.StyleUtil;

import javax.mail.MessagingException;
import java.io.IOException;

public class UserDeleteConfirmationFormController {

    @FXML
    private Pane closePane;

    @FXML
    private Pane confirmPane;

    @FXML
    private ImageView imgClose;

    @FXML
    private Label lblConfirm;

    DeleteService deleteService =
            (DeleteService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.DELETE);

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Navigation.closeUserPopUpPane();
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
    void btnConfirmOnAction(ActionEvent event) throws IOException {
        if (deleteService.deleteUser(UserSignInFormController.user.getId())) {
            Navigation.close(event);
            Navigation.switchNavigation("userSignInGlobalForm.fxml", event);
            sendMail();
        } else System.out.println("Unable to Delete User!");
    }

    @FXML
    void btnConfirmOnMouseEntered(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnSelected(confirmPane, lblConfirm);
    }

    @FXML
    void btnConfirmOnMouseExited(MouseEvent event) {
        StyleUtil.addUpdateConfirmReturnBtnUnselected(confirmPane, lblConfirm);
    }

    private void sendMail() {
        try {
            String email = UserSignInFormController.user.getEmail();
            String subject = "Your BookWorm Account has been Deleted!";
            String body = "Dear "+ UserSignInFormController.user.getName() +",\n" +
                    "We acknowledge that you have initiated the deletion of your account.\n" +
                    "If you have any further inquiries or require assistance, please feel free to reach out to us.\n" +
                    "\n" +
                    "Thank you.\n" +
                    "\n" +
                    "Kind regards,\n" +
                    "BookWorm Library Management";

            String[] detail = {email, subject, body};
            SendMail.sendMail(detail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
