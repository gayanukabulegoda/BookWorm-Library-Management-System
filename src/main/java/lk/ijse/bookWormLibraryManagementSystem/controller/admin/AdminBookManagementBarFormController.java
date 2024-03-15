package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.bookWormLibraryManagementSystem.dto.BookDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.BookService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;
import lk.ijse.bookWormLibraryManagementSystem.util.StyleUtil;

import java.io.IOException;

public class AdminBookManagementBarFormController {

    @FXML
    private ImageView imgDelete;

    @FXML
    private ImageView imgEdit;

    @FXML
    private ImageView imgView;

    @FXML
    private Label lblAvailability;

    @FXML
    private Label lblId;

    @FXML
    private Label lblLanguage;

    @FXML
    private Label lblName;

    @FXML
    private Label lblType;

    private BookDto bookDto;

    public static int bookId;

    BookService bookService =
            (BookService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.BOOK);

    @FXML
    void imgDeleteOnMouseClicked(MouseEvent event) throws IOException {
        if (bookDto.getStatus().equals("Unavailable")) {
            Navigation.imgPopUpBackground("borrowedBookCanNotDeleteAlertForm.fxml");
            return;
        }
        DeleteConfirmationFormController.objectName = "book";
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
        bookId = Integer.parseInt(lblId.getText());
        Navigation.imgPopUpBackground("updateBookPopUpForm.fxml");
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
        bookId = Integer.parseInt(lblId.getText());
        Navigation.imgPopUpBackground("viewBookPopUpForm.fxml");
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
        bookDto = bookService.getBookData(id);

        lblId.setText(String.valueOf(bookDto.getId()));
        lblName.setText(bookDto.getName());
        lblType.setText(bookDto.getType());
        lblLanguage.setText(bookDto.getLanguage());
        lblAvailability.setText(bookDto.getStatus());
    }

}
