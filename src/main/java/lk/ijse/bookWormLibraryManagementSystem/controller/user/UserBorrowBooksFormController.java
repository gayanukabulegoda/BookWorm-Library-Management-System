package lk.ijse.bookWormLibraryManagementSystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.bookWormLibraryManagementSystem.dto.BookDto;
import lk.ijse.bookWormLibraryManagementSystem.service.ServiceFactory;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.BookService;
import lk.ijse.bookWormLibraryManagementSystem.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserBorrowBooksFormController implements Initializable {

    @FXML
    private Pane AcquireBookPane;

    @FXML
    private ImageView imgAcquire;

    @FXML
    private Label lblAcquire;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxBooks;

    public List<BookDto> borrowedBooks = new ArrayList<>();

    BookService bookService =
            (BookService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.BOOK);

    private static UserBorrowBooksFormController controller;

    public UserBorrowBooksFormController() {
        controller = this;
    }

    public static UserBorrowBooksFormController getInstance() {
        return controller;
    }

    @FXML
    void btnAcquireBookOnAction(ActionEvent event) throws IOException {
        Navigation.imgPopUpBackground("userBorrowBookConfirmPopUpForm.fxml");
    }

    @FXML
    void btnAcquireBookOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAcquireBookOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

    public void allBookId() {
        vBoxBooks.getChildren().clear();
        List<BookDto> list = bookService.getAllBookId();
        if (list == null) return;

        for (BookDto dto : list) {
            loadDataTable(dto.getId());
        }
    }

    private void loadDataTable(int id) {
        try {
            FXMLLoader loader = new FXMLLoader(UserBorrowBooksFormController.class.getResource("/view/userBorrowBooksBarForm.fxml"));
            Parent root = loader.load();
            UserBorrowBooksBarFormController controller = loader.getController();
            controller.setData(id);
            vBoxBooks.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allBookId();
    }

}
