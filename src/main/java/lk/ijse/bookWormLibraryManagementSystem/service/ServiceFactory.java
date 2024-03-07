package lk.ijse.bookWormLibraryManagementSystem.service;

import lk.ijse.bookWormLibraryManagementSystem.service.custom.impl.AdminServiceImpl;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.impl.BookServiceImpl;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.impl.BranchServiceImpl;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.impl.UserServiceImpl;

public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return serviceFactory == null
                ? serviceFactory = new ServiceFactory()
                : serviceFactory;
    }

    public enum ServiceTypes {
        ADMIN, BOOK, BRANCH, USER
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
            default:
                return null;
        }
    }

}
