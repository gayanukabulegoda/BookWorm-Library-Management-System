package lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.entity.Admin;
import lk.ijse.bookWormLibraryManagementSystem.projection.AdminProjection;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.AdminRepository;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {

    @Setter
    private static Session session;

    @Override
    public void save(Admin entity) {
        session.save(entity);
    }

    @Override
    public void update(Admin entity) {
        session.update(entity);
    }

    @Override
    public void delete(Admin admin) {
        session.delete(admin);
    }

    @Override
    public Admin getData(int id) {
        return session.get(Admin.class, id);
    }

    @Override
    public List<Admin> getAllId() {
        String hqlQuery = "From Admin";
        Query<Admin> query = session.createQuery(hqlQuery);
        return query.list();
    }

    @Override
    public boolean checkUsernameAndPassword(String username, String password) {
        String jpqlQuery = "SELECT COUNT(a) " +
                           "FROM Admin a " +
                           "WHERE a.username = :inputUsername " +
                           "AND a.password = :inputPassword";

        Query query = session.createQuery(jpqlQuery)
                .setParameter("inputUsername", username)
                .setParameter("inputPassword", password);
        Long result = (Long) query.uniqueResult();

        return result > 0;
    }

    @Override
    public Admin getAdmin(String username) {
        String jpqlQuery = "SELECT a FROM Admin a WHERE a.username = :inputUsername";

        Query query = session.createQuery(jpqlQuery)
                .setParameter("inputUsername", username);

        return (Admin) query.uniqueResult();
    }

    @Override
    public List<AdminProjection> getAdminIdAndName() {
        String jpqlQuery = "SELECT " +
                "new lk.ijse.bookWormLibraryManagementSystem.projection.AdminProjection(A.id, A.name) " +
                "FROM Admin AS A";
        Query query = session.createQuery(jpqlQuery);
        List<AdminProjection> list = query.list();
        session.close();
        return list;
    }

}
