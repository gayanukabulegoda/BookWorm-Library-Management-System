package lk.ijse.bookWormLibraryManagementSystem.repository;

import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.AdminRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.BookRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.BranchRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.UserRepositoryImpl;

public class RepositoryFactory {

    private static RepositoryFactory repositoryFactory;

    private RepositoryFactory() {}

    public static RepositoryFactory getInstance() {
        return repositoryFactory == null
                ? repositoryFactory = new RepositoryFactory()
                : repositoryFactory;
    }

    public enum RepositoryTypes {
        ADMIN, BOOK, BRANCH, USER
    }

    public SuperRepository getRepository(RepositoryTypes types) {
        switch (types) {
            case ADMIN:
                return new AdminRepositoryImpl();
            case BOOK:
                return new BookRepositoryImpl();
            case BRANCH:
                return new BranchRepositoryImpl();
            case USER:
                return new UserRepositoryImpl();
            default:
                return null;
        }
    }

}
