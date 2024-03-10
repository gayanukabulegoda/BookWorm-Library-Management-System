package lk.ijse.bookWormLibraryManagementSystem.service.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.dto.AdminDto;
import lk.ijse.bookWormLibraryManagementSystem.dto.BookDto;
import lk.ijse.bookWormLibraryManagementSystem.entity.Admin;
import lk.ijse.bookWormLibraryManagementSystem.entity.Book;
import lk.ijse.bookWormLibraryManagementSystem.repository.RepositoryFactory;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.BookRepository;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.BookRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.BookService;
import lk.ijse.bookWormLibraryManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    BookRepository bookRepository =
            (BookRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.BOOK);

    private Session session;

    public void initializeSession() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public boolean saveBook(BookDto dto) {
        Book book = convertToEntity(dto);
        initializeSession();
        Transaction transaction = session.beginTransaction();
        try {
            BookRepositoryImpl.setSession(session);
            bookRepository.save(book);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateBook(BookDto dto) {
        Book book = convertToEntity(dto);
        initializeSession();
        Transaction transaction = session.beginTransaction();
        try {
            BookRepositoryImpl.setSession(session);
            bookRepository.update(book);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public BookDto getBookData(int id) {
        try {
            initializeSession();
            BookRepositoryImpl.setSession(session);
            return convertToDto(bookRepository.getData(id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<BookDto> getAllBookId() {
        List<BookDto> idList = new ArrayList<>();
        try {
            initializeSession();
            BookRepositoryImpl.setSession(session);
            List<Book> allBookId = bookRepository.getAllId();
            for (Book book : allBookId) {;
                idList.add(convertToDto(book));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return idList;
    }

    private Book convertToEntity(BookDto dto) {
        Book entity = new Book();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setLanguage(dto.getLanguage());
        entity.setStatus(dto.getStatus());
        entity.setAdmin(convertToAdminEntity(dto.getAdmin()));
        return entity;
    }

    private BookDto convertToDto(Book entity) {
        return new BookDto(
                entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getLanguage(),
                entity.getStatus(),
                convertToAdminDto(entity.getAdmin())
        );
    }

    private AdminDto convertToAdminDto(Admin entity) {
        return new AdminDto(
                entity.getId(),
                entity.getName(),
                entity.getContactNo(),
                entity.getEmail(),
                entity.getUsername(),
                entity.getPassword()
        );
    }

    private Admin convertToAdminEntity(AdminDto dto) {
        Admin admin = new Admin();
        admin.setId(dto.getId());
        admin.setName(dto.getName());
        admin.setContactNo(dto.getContactNo());
        admin.setEmail(dto.getEmail());
        admin.setUsername(dto.getUsername());
        admin.setPassword(dto.getPassword());
        return admin;
    }

}
