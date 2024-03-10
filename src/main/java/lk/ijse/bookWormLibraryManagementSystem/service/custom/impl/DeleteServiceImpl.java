package lk.ijse.bookWormLibraryManagementSystem.service.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.entity.Admin;
import lk.ijse.bookWormLibraryManagementSystem.entity.Book;
import lk.ijse.bookWormLibraryManagementSystem.entity.Branch;
import lk.ijse.bookWormLibraryManagementSystem.entity.User;
import lk.ijse.bookWormLibraryManagementSystem.repository.RepositoryFactory;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.AdminRepository;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.BookRepository;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.BranchRepository;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.UserRepository;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.AdminRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.BookRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.BranchRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.UserRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.DeleteService;
import lk.ijse.bookWormLibraryManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteServiceImpl implements DeleteService {

    AdminRepository adminRepository =
            (AdminRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.ADMIN);
    BookRepository bookRepository =
            (BookRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.BOOK);
    BranchRepository branchRepository =
            (BranchRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.BRANCH);
    UserRepository userRepository =
            (UserRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.USER);

    public Session session;

    public void initializeSession() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public boolean deleteAdmin(int id) {
        initializeSession();
        Transaction transaction = session.beginTransaction();
        try {
            AdminRepositoryImpl.setSession(session);
            Admin admin = adminRepository.getData(id);
            adminRepository.delete(admin);
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
    public boolean deleteBook(int id) {
        initializeSession();
        Transaction transaction = session.beginTransaction();
        try {
            BookRepositoryImpl.setSession(session);
            Book book = bookRepository.getData(id);
            bookRepository.delete(book);
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
    public boolean deleteBranch(int id) {
        initializeSession();
        Transaction transaction = session.beginTransaction();
        try {
            BranchRepositoryImpl.setSession(session);
            Branch branch = branchRepository.getData(id);
            branchRepository.delete(branch);
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
    public boolean deleteUser(int id) {
        initializeSession();
        Transaction transaction = session.beginTransaction();
        try {
            UserRepositoryImpl.setSession(session);
            User user = userRepository.getData(id);
            userRepository.delete(user);
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

}
