package lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.entity.Branch;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.BranchRepository;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BranchRepositoryImpl implements BranchRepository {

    @Setter
    private static Session session;

    @Override
    public void save(Branch entity) {
        session.save(entity);
    }

    @Override
    public void update(Branch entity) {
        session.update(entity);
    }

    @Override
    public void delete(Branch entity) {
        session.delete(entity);
    }

    @Override
    public Branch getData(int id) {
        return session.get(Branch.class, id);
    }

    @Override
    public List<Branch> getAllId() {
        String hqlQuery = "From branch";
        Query<Branch> query = session.createQuery(hqlQuery);
        return query.list();
    }

}
