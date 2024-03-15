package lk.ijse.bookWormLibraryManagementSystem.util;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class StyleUtil {

    public static void closeIconBtnSelected(Pane pane, ImageView imageView) {
        pane.setStyle(
                "-fx-background-color: #FFE1E1;" +
                        "-fx-background-radius: 10px;");
        imageView.setImage(new Image("assests/icon/closeIconRed.png"));
    }

    public static void closeIconBtnUnselected(Pane pane, ImageView imageView) {
        pane.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 10px;");
        imageView.setImage(new Image("assests/icon/closeIconBlack.png"));
    }

    public static void cancelBtnSelected(Pane pane, Label label) {
        pane.setStyle(
                "-fx-background-color: black;" +
                        "-fx-background-radius: 10px;");
        label.setStyle("-fx-text-fill: white;");
    }

    public static void cancelBtnUnselected(Pane pane, Label label) {
        pane.setStyle(
                "-fx-background-color: #D7D7D7;" +
                        "-fx-background-radius: 10px;");
        label.setStyle("-fx-text-fill: black;");
    }

    public static void addUpdateConfirmReturnBtnSelected(Pane pane, Label label) {
        pane.setStyle(
                "-fx-background-color: #D7D7D7;" +
                        "-fx-background-radius: 10px;");
        label.setStyle("-fx-text-fill: black;");
    }

    public static void addUpdateConfirmReturnBtnUnselected(Pane pane, Label label) {
        pane.setStyle(
                "-fx-background-color: black;" +
                        "-fx-background-radius: 10px;");
        label.setStyle("-fx-text-fill: white;");
    }

    public static void updateImgSelected(ImageView imageView) {
        imageView.setImage(new Image("assests/icon/editIconBlue.png"));
        imageView.setScaleX(1.3);
        imageView.setScaleY(1.3);
    }

    public static void updateImgUnselected(ImageView imageView) {
        imageView.setImage(new Image("assests/icon/editIconBlack.png"));
        imageView.setScaleX(1.0);
        imageView.setScaleY(1.0);
    }

    public static void deleteImgSelected(ImageView imageView) {
        imageView.setImage(new Image("assests/icon/deleteIconRed.png"));
        imageView.setScaleX(1.3);
        imageView.setScaleY(1.3);
    }

    public static void deleteImgUnselected(ImageView imageView) {
        imageView.setImage(new Image("assests/icon/deleteIconBlack.png"));
        imageView.setScaleX(1.0);
        imageView.setScaleY(1.0);
    }

    public static void viewImgSelected(ImageView imageView) {
        imageView.setImage(new Image("assests/icon/viewIconBrown.png"));
        imageView.setScaleX(1.3);
        imageView.setScaleY(1.3);
    }

    public static void viewImgUnselected(ImageView imageView) {
        imageView.setImage(new Image("assests/icon/viewIconBlack.png"));
        imageView.setScaleX(1.0);
        imageView.setScaleY(1.0);
    }

    public static void userDashboardButtonsSelected(Pane pane) {
        pane.setStyle("-fx-background-color: white; -fx-background-radius: 12px;" +
                "-fx-border-color: #727374; -fx-border-radius: 12px");
        pane.setScaleX(1.03);
        pane.setScaleY(1.03);
    }

    public static void userDashboardButtonsUnselected(Pane pane) {
        pane.setStyle("-fx-background-color: white; -fx-background-radius: 12px;" +
                "-fx-border-color: transparent; -fx-border-radius: 12px");
        pane.setScaleX(1.0);
        pane.setScaleY(1.0);
    }

}
