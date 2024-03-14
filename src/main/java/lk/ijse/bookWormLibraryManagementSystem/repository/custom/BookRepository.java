package lk.ijse.bookWormLibraryManagementSystem.repository.custom;

import lk.ijse.bookWormLibraryManagementSystem.entity.Book;
import lk.ijse.bookWormLibraryManagementSystem.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book> {

    int getAllBookCount();

}
