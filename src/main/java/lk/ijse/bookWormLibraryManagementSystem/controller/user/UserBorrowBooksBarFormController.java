package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import lk.ijse.bookWormLibraryManagementSystem.dto.BookDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.BookService;

public class UserBorrowBooksBarFormController {

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

    @FXML
    private CheckBox checkBox;

    BookService bookService =
            (BookService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.BOOK);

    @FXML
    void checkBoxOnAction(ActionEvent event) {
        if (checkBox.isSelected()) {
            UserBorrowBooksFormController.getInstance().borrowedBooks
                    .add(bookService.getBookData(Integer.parseInt(lblId.getText())));
        } else {
            UserBorrowBooksFormController.getInstance().borrowedBooks
                    .remove(bookService.getBookData(Integer.parseInt(lblId.getText())));
        }
    }

    public void setData(int id) {
        checkBox.setVisible(true);
        BookDto bookDto = bookService.getBookData(id);

        lblId.setText(String.valueOf(bookDto.getId()));
        lblName.setText(bookDto.getName());
        lblType.setText(bookDto.getType());
        lblLanguage.setText(bookDto.getLanguage());
        lblAvailability.setText(bookDto.getStatus());

        if (bookDto.getStatus().equals("Unavailable")) checkBox.setVisible(false);
    }

}
