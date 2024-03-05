package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserSignInGlobalFormController implements Initializable {

    @FXML
    public AnchorPane signInSignUpPane;

    private static UserSignInGlobalFormController controller;

    public UserSignInGlobalFormController() {
        controller = this;
    }

    public static UserSignInGlobalFormController getInstance() {
        return controller;
    }

    private void loadSignInPage() {
        try {
            Navigation.switchPaging(signInSignUpPane, "userSignInForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadSignInPage();
    }
}
