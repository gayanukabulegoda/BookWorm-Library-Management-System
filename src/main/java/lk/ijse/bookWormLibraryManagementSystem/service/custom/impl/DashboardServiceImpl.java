package lk.ijse.bookWormLibraryManagementSystem.service.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.dto.AdminDto;
import lk.ijse.bookWormLibraryManagementSystem.dto.TransactionDto;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;
import lk.ijse.bookWormLibraryManagementSystem.entity.Admin;
import lk.ijse.bookWormLibraryManagementSystem.entity.Transaction;
import lk.ijse.bookWormLibraryManagementSystem.entity.User;
import lk.ijse.bookWormLibraryManagementSystem.projection.AdminProjection;
import lk.ijse.bookWormLibraryManagementSystem.repository.RepositoryFactory;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.*;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.*;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.BookService;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.DashboardService;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.UserService;
import lk.ijse.bookWormLibraryManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class DashboardServiceImpl implements DashboardService {

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

    TransactionRepository transactionRepository =
            (TransactionRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.TRANSACTION);

    private Session session;

    public void initializeSession() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
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
    public List<AdminProjection> getAdminIdAndName() {
        try {
            initializeSession();
            AdminRepositoryImpl.setSession(session);
            return adminRepository.getAdminIdAndName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
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
    public int getAllUserCount() {
        try {
            initializeSession();
            UserRepositoryImpl.setSession(session);
            return userRepository.getAllUserCount();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public int getAllBookCount() {
        try {
            initializeSession();
            BookRepositoryImpl.setSession(session);
            return bookRepository.getAllBookCount();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public int getAllBranchCount() {
        try {
            initializeSession();
            BranchRepositoryImpl.setSession(session);
            return branchRepository.getAllBranchCount();
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
