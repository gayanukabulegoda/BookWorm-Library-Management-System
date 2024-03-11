package lk.ijse.bookWormLibraryManagementSystem.util;

import lk.ijse.bookWormLibraryManagementSystem.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    public SessionFactoryConfig() {
        sessionFactory = new Configuration()
                .mergeProperties(Utility.getProperties())
                .addAnnotatedClass(Admin.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Branch.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Transaction.class)
                .addAnnotatedClass(TransactionDetail.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return factoryConfig == null
                ? factoryConfig = new SessionFactoryConfig()
                : factoryConfig;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}
