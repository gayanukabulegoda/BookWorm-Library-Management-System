package lk.ijse.bookWormLibraryManagementSystem.repository;

import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.*;

public class RepositoryFactory {

    private static RepositoryFactory repositoryFactory;

    private RepositoryFactory() {}

    public static RepositoryFactory getInstance() {
        return repositoryFactory == null
                ? repositoryFactory = new RepositoryFactory()
                : repositoryFactory;
    }

    public enum RepositoryTypes {
        ADMIN, BOOK, BRANCH, USER, TRANSACTION, TRANSACTION_DETAIL
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
            case TRANSACTION:
                return new TransactionRepositoryImpl();
            case TRANSACTION_DETAIL:
                return new TransactionDetailRepositoryImpl();
            default:
                return null;
        }
    }

}
