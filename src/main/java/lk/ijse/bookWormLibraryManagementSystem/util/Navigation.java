package lk.ijse.bookWormLibraryManagementSystem.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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

    public static void exit() {
        System.exit(0);
    }

    public static void close(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public static void close(javafx.scene.input.MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

//    public static void closePane(){
//        GlobalFormController.getInstance().popUpPane.getChildren().clear();
//        GlobalFormController.getInstance().popUpPane.setVisible(false);
//        GlobalFormController.getInstance().imgPopUpBackground.setVisible(false);
//    }
//
//    public static void closeOrderPopUpPane() {
//        GlobalFormController.getInstance().orderPopUpPane.getChildren().clear();
//        GlobalFormController.getInstance().orderPopUpPane.setVisible(false);
//        GlobalFormController.getInstance().imgPopUpBackground.setVisible(false);
//    }
//
//    public static void imgPopUpBackground(String path) throws IOException {
//        GlobalFormController.getInstance().imgPopUpBackground.setVisible(true);
//
//        if (path.equals("customerOrderAddPopUpForm.fxml") | path.equals("customerOrderViewPopUpForm.fxml")) {
//            GlobalFormController.getInstance().orderPopUpPane.setVisible(true);
//            switchPaging(GlobalFormController.getInstance().orderPopUpPane, path);
//        }
//        else if (path.equals("supplierOrderAddPopUpForm.fxml") | path.equals("supplierOrderViewPopUpForm.fxml")) {
//            GlobalFormController.getInstance().orderPopUpPane.setVisible(true);
//            switchPaging(GlobalFormController.getInstance().orderPopUpPane, path);
//        }
//        else {
//            GlobalFormController.getInstance().popUpPane.setVisible(true);
//            switchPaging(GlobalFormController.getInstance().popUpPane, path);
//        }
//    }
}
