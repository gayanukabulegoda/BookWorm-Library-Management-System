package lk.ijse.bookWormLibraryManagementSystem.service.custom;

import lk.ijse.bookWormLibraryManagementSystem.dto.BookDto;
import lk.ijse.bookWormLibraryManagementSystem.service.SuperService;

import java.util.List;

public interface BookService extends SuperService {

    boolean saveBook(BookDto dto);
    boolean updateBook(BookDto dto);
    BookDto getBookData(int id);
    List<BookDto> getAllBookId();

}
