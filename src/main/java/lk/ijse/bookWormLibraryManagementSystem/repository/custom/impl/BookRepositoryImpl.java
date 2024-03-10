package lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.entity.Book;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.BookRepository;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    @Setter
    private static Session session;

    @Override
    public void save(Book entity) {
        session.save(entity);
    }

    @Override
    public void update(Book entity) {
        session.update(entity);
    }

    @Override
    public void delete(Book entity) {
        session.delete(entity);
    }

    @Override
    public Book getData(int id) {
        return session.get(Book.class, id);
    }

    @Override
    public List<Book> getAllId() {
        String hqlQuery = "From book";
        Query<Book> query = session.createQuery(hqlQuery);
        return query.list();
    }

}
