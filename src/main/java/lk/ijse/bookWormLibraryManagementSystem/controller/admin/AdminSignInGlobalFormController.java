package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminSignInGlobalFormController implements Initializable {

    @FXML
    private AnchorPane signInSignUpPane;

    private void loadSignInPage() {
        try {
            Navigation.switchPaging(signInSignUpPane, "adminSignInForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadSignInPage();
    }
}
