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
import lk.ijse.bookWormLibraryManagementSystem.util.RegExPatterns;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserBorrowBooksFormController implements Initializable {

    @FXML
    private Pane AcquireBookPane;

    @FXML
    private Pane btnRefreshPane;

    @FXML
    private ImageView imgAcquire;

    @FXML
    private Label lblAcquire;

    @FXML
    private Label lblSearchAlert;

    @FXML
    private Pane searchPane;

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxBooks;

    private List<BookDto> list;

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
    void btnRefreshTableOnAction(ActionEvent event) {
        lblSearchAlert.setText(" ");
        allBookId();
    }

    @FXML
    void btnRefreshTableOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnRefreshTableOnMouseExited(MouseEvent event) {

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {
        List<BookDto> selectedDtoList = new ArrayList<>();
        if (validateSearch()) {
            for (BookDto dto : list) {
                if (!dto.getStatus().equals("Removed")) {
                    if (txtSearch.getText().equals(String.valueOf(dto.getId()))
                            || txtSearch.getText().equalsIgnoreCase(dto.getName())
                            || txtSearch.getText().equalsIgnoreCase(dto.getType())
                    ) selectedDtoList.add(dto);
                }
            }
        }
        if (!selectedDtoList.isEmpty()) {
            allSelectedBookId(selectedDtoList);
            lblSearchAlert.setText(" ");
        }
        txtSearch.clear();
    }

    private boolean validateSearch() {
        if (validateName() & validateId()) {
            lblSearchAlert.setText("Invalid Id, Name or Type!!");
            return false;
        }
        return true;
    }

    public boolean validateName() {
        return RegExPatterns.namePattern(txtSearch.getText());
    }

    public boolean validateId() {
        return RegExPatterns.idPattern(txtSearch.getText());
    }

    @FXML
    void txtSearchOnMouseMoved(MouseEvent event) {
        lblSearchAlert.setText(" ");
    }

    public void allSelectedBookId(List<BookDto> selectedDtoList) {
        vBoxBooks.getChildren().clear();

        for (BookDto selectedDto : selectedDtoList) {
            loadDataTable(selectedDto.getId());
        }
    }

    public void allBookId() {
        vBoxBooks.getChildren().clear();
        list = bookService.getAllBookId();
        if (list == null) return;

        for (BookDto dto : list) {
            if (!dto.getStatus().equals("Removed")) loadDataTable(dto.getId());
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
