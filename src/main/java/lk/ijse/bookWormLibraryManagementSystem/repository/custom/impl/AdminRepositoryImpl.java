package lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.entity.Admin;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.AdminRepository;
import lk.ijse.bookWormLibraryManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {

    private final Session session;

    public AdminRepositoryImpl() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public boolean save(Admin entity) {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean update(Admin entity) {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
        finally {
            session.close();
        }
    }

    @Override
    public Admin getData(int id) {
        Admin admin = session.get(Admin.class, id);
        session.close();
        return admin;
    }

    @Override
    public List<Admin> getAllId() {
        List<Admin> admins = new ArrayList<>();
        try {
            String hqlQuery = "From Admin";
            Query<Admin> query = session.createQuery(hqlQuery);
            admins = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return admins;
    }

    @Override
    public boolean checkUsernameAndPassword(String username, String password) {
        String jpqlQuery = "SELECT COUNT(a) " +
                           "FROM admin a " +
                           "WHERE a.username = :inputUsername " +
                           "AND a.password = :inputPassword";

        Query query = session.createQuery(jpqlQuery)
                .setParameter("inputUsername", username)
                .setParameter("inputPassword", password);
        Long result = (Long) query.uniqueResult();

        return result > 0;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

}
