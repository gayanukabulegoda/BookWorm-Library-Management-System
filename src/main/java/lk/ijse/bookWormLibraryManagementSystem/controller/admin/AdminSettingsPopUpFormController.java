package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;

public class AdminSettingsPopUpFormController {

    @FXML
    void btnChangeCredentialsOnAction(ActionEvent event) throws IOException {
        Navigation.closeAdminSettingsPane();
        Navigation.imgPopUpBackground("adminChangeCredentialsPopUpForm.fxml");
    }

    @FXML
    void btnDeleteAccountOnAction(ActionEvent event) throws IOException {
        Navigation.closeAdminSettingsPane();
        DeleteConfirmationFormController.objectName = "admin";
        DeleteConfirmationFormController.id = AdminSignInFormController.admin.getId();
        Navigation.imgPopUpBackground("deleteConfirmationForm.fxml");
    }

}
