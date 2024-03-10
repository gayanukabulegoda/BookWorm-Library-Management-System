package lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl;

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
        String hqlQuery = "From user";
        Query<User> query = session.createQuery(hqlQuery);
        return query.list();
    }

}
