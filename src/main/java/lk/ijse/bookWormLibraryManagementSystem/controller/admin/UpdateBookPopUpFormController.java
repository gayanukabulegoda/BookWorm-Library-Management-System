package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lk.ijse.bookWormLibraryManagementSystem.dto.BookDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.BookService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateBookPopUpFormController implements Initializable {

    @FXML
    private Pane cancelPane;

    @FXML
    private Pane closePane;

    @FXML
    private ImageView imgClose;

    @FXML
    private Label lblCancel;

    @FXML
    private Label lblUpdate;

    @FXML
    private TextField txtLanguage;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtType;

    @FXML
    private Pane updatePane;

    private BookDto bookData;

    BookService bookService =
            (BookService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.BOOK);

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Navigation.closePopUpPane();
    }

    @FXML
    void btnCloseOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCloseOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        BookDto bookDto = new BookDto();
        bookDto.setName(txtName.getText());
        bookDto.setLanguage(txtLanguage.getText());
        bookDto.setType(txtType.getText());
        bookDto.setAdmin(AdminSignInFormController.admin);

        bookDto.setId(bookData.getId());
        bookDto.setStatus(bookData.getStatus());

        if (bookService.updateBook(bookDto)) {
            Navigation.closePopUpPane();
            AdminBookManagementFormController.getInstance().allBookId();
        } else {
            System.out.println("Unable to update book!");
        }
    }

    @FXML
    void btnUpdateOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnUpdateOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtLanguageOnAction(ActionEvent event) {
        txtType.requestFocus();
    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtLanguage.requestFocus();
    }

    @FXML
    void txtTypeOnAction(ActionEvent event) {
        btnUpdateOnAction(event);
    }

    public void setData() {
        bookData = bookService
                .getBookData(AdminBookManagementBarFormController.bookId);

        txtName.setText(bookData.getName());
        txtType.setText(bookData.getType());
        txtLanguage.setText(bookData.getLanguage());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }
}
