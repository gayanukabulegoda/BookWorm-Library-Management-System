package lk.ijse.bookWormLibraryManagementSystem.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.ijse.bookWormLibraryManagementSystem.controller.admin.AdminGlobalFormController;

import java.io.IOException;

public class Navigation {

    private static Stage stage;

    public static void switchNavigation(String path, ActionEvent event) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(Navigation.class.getResource("/view/" + path)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void switchPaging(Pane pane, String path) throws IOException {
        pane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/" + path));
        Parent root = loader.load();
        pane.getChildren().add(root);
    }

    public static void close(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public static void exit() {
        System.exit(0);
    }

    public static void close(javafx.scene.input.MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public static void closePopUpPane(){
        AdminGlobalFormController.getInstance().popUpPane.getChildren().clear();
        AdminGlobalFormController.getInstance().popUpPane.setVisible(false);
        AdminGlobalFormController.getInstance().imgTransparent.setVisible(false);
    }

    public static void closePopUpLargePane() {
        AdminGlobalFormController.getInstance().popUpLargePane.getChildren().clear();
        AdminGlobalFormController.getInstance().popUpLargePane.setVisible(false);
        AdminGlobalFormController.getInstance().imgTransparent.setVisible(false);
    }

    public static void imgPopUpBackground(String path) throws IOException {
//        if (path.startsWith("user"))
        AdminGlobalFormController.getInstance().imgTransparent.setVisible(true);

        if (path.equals("adminBorrowedBooksViewPopUpForm.fxml") | path.equals("adminOverdueBooksViewPopUpForm.fxml")) {
            AdminGlobalFormController.getInstance().popUpLargePane.setVisible(true);
            switchPaging(AdminGlobalFormController.getInstance().popUpLargePane, path);
        }
        else {
            AdminGlobalFormController.getInstance().popUpPane.setVisible(true);
            switchPaging(AdminGlobalFormController.getInstance().popUpPane, path);
        }
    }
}
