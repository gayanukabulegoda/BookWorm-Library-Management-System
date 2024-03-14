package lk.ijse.bookWormLibraryManagementSystem.service;

import lk.ijse.bookWormLibraryManagementSystem.service.custom.impl.*;

public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return serviceFactory == null
                ? serviceFactory = new ServiceFactory()
                : serviceFactory;
    }

    public enum ServiceTypes {
        ADMIN, BOOK, BRANCH, USER, DELETE, TRANSACTION, DASHBOARD
    }

    public SuperService getService(ServiceTypes types) {
        switch (types) {
            case ADMIN:
                return new AdminServiceImpl();
            case BOOK:
                return new BookServiceImpl();
            case BRANCH:
                return new BranchServiceImpl();
            case USER:
                return new UserServiceImpl();
            case DELETE:
                return new DeleteServiceImpl();
            case TRANSACTION:
                return new TransactionServiceImpl();
            case DASHBOARD:
                return new DashboardServiceImpl();
            default:
                return null;
        }
    }

}
