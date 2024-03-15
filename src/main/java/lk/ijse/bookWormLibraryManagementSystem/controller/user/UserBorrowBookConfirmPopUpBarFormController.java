package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.bookWormLibraryManagementSystem.dto.BookDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.BookService;
import lk.ijse.bookWormLibraryManagementSystem.util.StyleUtil;

public class UserBorrowBookConfirmPopUpBarFormController {

    @FXML
    private ImageView imgDelete;

    @FXML
    private Label lblId;

    @FXML
    private Label lblLanguage;

    @FXML
    private Label lblName;

    @FXML
    private Label lblType;

    BookDto bookDto;

    BookService bookService =
            (BookService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.BOOK);

    @FXML
    void imgDeleteOnMouseClicked(MouseEvent event) {
        UserBorrowBooksFormController.getInstance().borrowedBooks.remove(bookDto);
        UserBorrowBookConfirmPopUpFormController.getInstance().allBorrowedBookId();
    }

    @FXML
    void imgDeleteOnMouseEntered(MouseEvent event) {
        StyleUtil.deleteImgSelected(imgDelete);
    }

    @FXML
    void imgDeleteOnMouseExited(MouseEvent event) {
        StyleUtil.deleteImgUnselected(imgDelete);
    }

    public void setData(int id) {
        bookDto = bookService.getBookData(id);

        lblId.setText(String.valueOf(bookDto.getId()));
        lblName.setText(bookDto.getName());
        lblType.setText(bookDto.getType());
        lblLanguage.setText(bookDto.getLanguage());
    }

}
