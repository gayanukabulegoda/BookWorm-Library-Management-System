package lk.ijse.bookWormLibraryManagementSystem.controller.admin;

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
import java.util.List;
import java.util.ResourceBundle;

public class AdminBookManagementFormController implements Initializable {

    @FXML
    private Pane AddBookPane;

    @FXML
    private ImageView imgAdd;

    @FXML
    private Label lblAddBook;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxBookManage;

    BookService bookService =
            (BookService) ServiceFactory.getInstance()
                    .getService(ServiceFactory.ServiceTypes.BOOK);

    private static AdminBookManagementFormController controller;

    public AdminBookManagementFormController() {
        controller = this;
    }

    public static AdminBookManagementFormController getInstance() {
        return controller;
    }

    @FXML
    void btnAddBookOnAction(ActionEvent event) throws IOException {
        Navigation.imgPopUpBackground("addBookPopUpForm.fxml");
    }

    @FXML
    void btnAddBookOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddBookOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }

    public void allBookId() {
        vBoxBookManage.getChildren().clear();
        List<BookDto> list = bookService.getAllBookId();
        if (list == null) return;

        for (BookDto dto : list) {
            loadDataTable(dto.getId());
        }
    }

    private void loadDataTable(int id) {
        try {
            FXMLLoader loader = new FXMLLoader(AdminBookManagementFormController.class.getResource("/view/adminBookManagementBarForm.fxml"));
            Parent root = loader.load();
            AdminBookManagementBarFormController controller = loader.getController();
            controller.setData(id);
            vBoxBookManage.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allBookId();
    }

}
