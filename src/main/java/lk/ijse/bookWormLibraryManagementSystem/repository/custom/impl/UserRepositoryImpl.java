package lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.entity.Admin;
import lk.ijse.bookWormLibraryManagementSystem.entity.User;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.UserRepository;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    @Setter
    private static Session session;

    @Override
    public void save(User entity) {
        session.save(entity);
    }

    @Override
    public void update(User entity) {
        session.update(entity);
    }

    @Override
    public void delete(User entity) {
        session.delete(entity);
    }

    @Override
    public User getData(int id) {
        return session.get(User.class, id);
    }

    @Override
    public List<User> getAllId() {
        String hqlQuery = "From User";
        Query<User> query = session.createQuery(hqlQuery);
        return query.list();
    }

    @Override
    public boolean checkUsernameAndPassword(String username, String password) {
        String jpqlQuery = "SELECT COUNT(u) " +
                "FROM User u " +
                "WHERE u.username = :inputUsername " +
                "AND u.password = :inputPassword";

        Query query = session.createQuery(jpqlQuery)
                .setParameter("inputUsername", username)
                .setParameter("inputPassword", password);
        Long result = (Long) query.uniqueResult();

        return result > 0;
    }

    @Override
    public User getUser(String username) {
        String jpqlQuery = "SELECT u FROM User u WHERE u.username = :inputUsername";

        Query query = session.createQuery(jpqlQuery)
                .setParameter("inputUsername", username);

        return (User) query.uniqueResult();
    }

    @Override
    public int getAllUserCount() {
        String jpqlQuery = "SELECT COUNT (U) FROM User U";

        Query query = session.createQuery(jpqlQuery);
        Long count = (Long) query.uniqueResult();
        return Math.toIntExact(count);
    }

}
