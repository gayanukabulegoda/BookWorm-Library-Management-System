package lk.ijse.bookWormLibraryManagementSystem.service.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.controller.user.UserBorrowBooksFormController;
import lk.ijse.bookWormLibraryManagementSystem.controller.user.UserReturnBookConfirmPopUpFormController;
import lk.ijse.bookWormLibraryManagementSystem.dto.AdminDto;
import lk.ijse.bookWormLibraryManagementSystem.dto.BookDto;
import lk.ijse.bookWormLibraryManagementSystem.dto.TransactionDto;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;
import lk.ijse.bookWormLibraryManagementSystem.embedded.TransactionDetailPK;
import lk.ijse.bookWormLibraryManagementSystem.entity.*;
import lk.ijse.bookWormLibraryManagementSystem.repository.RepositoryFactory;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.BookRepository;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.TransactionDetailRepository;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.TransactionRepository;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.BookRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.TransactionDetailRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.TransactionRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.TransactionService;
import lk.ijse.bookWormLibraryManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository =
            (TransactionRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.TRANSACTION);

    TransactionDetailRepository transactionDetailRepository =
            (TransactionDetailRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.TRANSACTION_DETAIL);

    BookRepository bookRepository =
            (BookRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.BOOK);

    private Session session;

    public void initializeSession() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public boolean saveTransaction(TransactionDto dto) {
        Transaction transactionEntity = convertToEntity(dto);

        initializeSession();
        org.hibernate.Transaction transaction = session.beginTransaction();

        TransactionRepositoryImpl.setSession(session);
        transactionRepository.save(transactionEntity);

        for (BookDto borrowedBook : UserBorrowBooksFormController.getInstance().borrowedBooks) {

            Book bookEntity = convertToBookEntity(borrowedBook);
            BookRepositoryImpl.setSession(session);
            bookRepository.update(bookEntity);

            TransactionDetail transactionDetail = new TransactionDetail();
            transactionDetail.setTransaction(transactionEntity);
            transactionDetail.setBook(bookEntity);
            transactionDetail.setTransactionDetailPK(
                    new TransactionDetailPK(
                            transactionEntity.getId(),
                            bookEntity.getId()
                    )
            );
            TransactionDetailRepositoryImpl.setSession(session);
            transactionDetailRepository.save(transactionDetail);
        }

        try {
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateTransaction(TransactionDto dto) {
        Transaction transactionEntity = convertToEntity(dto);

        initializeSession();
        org.hibernate.Transaction transaction = session.beginTransaction();

        TransactionRepositoryImpl.setSession(session);
        transactionRepository.update(transactionEntity);

        for (Book book : UserReturnBookConfirmPopUpFormController.booksToBeReturned) {
            Book bookEntity = updateBookEntityStatus(book);
            BookRepositoryImpl.setSession(session);
            bookRepository.update(bookEntity);
        }

        try {
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public TransactionDto getTransactionData(int id) {
        try {
            initializeSession();
            TransactionRepositoryImpl.setSession(session);
            return convertToDto(transactionRepository.getData(id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<TransactionDto> getTransactionAllId() {
        List<TransactionDto> list = new ArrayList<>();
        try {
            initializeSession();
            TransactionRepositoryImpl.setSession(session);
            List<Transaction> allTransactions = transactionRepository.getAllId();
            for (Transaction transaction : allTransactions) {;
                list.add(convertToDto(transaction));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<TransactionDto> getAllOverDueBorrowers() {
        List<TransactionDto> list = new ArrayList<>();
        try {
            initializeSession();
            TransactionRepositoryImpl.setSession(session);
            List<Transaction> overDueBorrowers = transactionRepository.getAllOverDueBorrowers();
            for (Transaction transaction : overDueBorrowers) {;
                list.add(convertToDto(transaction));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public int getLastTransactionId() {
        try {
            initializeSession();
            TransactionRepositoryImpl.setSession(session);
            return transactionRepository.getLastId();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

    private Transaction convertToEntity(TransactionDto dto) {
        Transaction entity = new Transaction();
        entity.setId(dto.getId());
        entity.setTransactionType(dto.getTransactionType());
        entity.setBookQty(dto.getBookQty());
        entity.setDueDate(dto.getDueDate());
        entity.setDateAndTime(dto.getDateAndTime());
        entity.setUser(convertToUserEntity(dto.getUser()));
        return entity;
    }

    private TransactionDto convertToDto(Transaction entity) {
        return new TransactionDto(
                entity.getId(),
                entity.getTransactionType(),
                entity.getBookQty(),
                entity.getDueDate(),
                entity.getDateAndTime(),
                entity.getTransactionDetails(),
                convertToUserDto(entity.getUser())
        );
    }

    private Book convertToBookEntity(BookDto dto) {
        Book entity = new Book();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setLanguage(dto.getLanguage());
        entity.setStatus("Unavailable");
        entity.setAdmin(convertToAdminEntity(dto.getAdmin()));
        return entity;
    }

    private Book updateBookEntityStatus(Book entity) {
        entity.setId(entity.getId());
        entity.setName(entity.getName());
        entity.setType(entity.getType());
        entity.setLanguage(entity.getLanguage());
        entity.setStatus("Available");
        entity.setAdmin(entity.getAdmin());
        return entity;
    }

    private BookDto convertToBookDto(Book entity) {
        return new BookDto(
                entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getLanguage(),
                entity.getStatus(),
                convertToAdminDto(entity.getAdmin())
        );
    }

    private User convertToUserEntity(UserDto dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setAdmin(convertToAdminEntity(dto.getAdmin()));
        return entity;
    }

    private UserDto convertToUserDto(User entity) {
        return new UserDto(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getUsername(),
                entity.getPassword(),
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
