package lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.entity.Book;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.BookRepository;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public boolean save(Book entity) {
        return false;
    }

    @Override
    public boolean update(Book entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Book getData(int id) {
        return null;
    }

    @Override
    public List<Book> getAllId() {
        return null;
    }
}
