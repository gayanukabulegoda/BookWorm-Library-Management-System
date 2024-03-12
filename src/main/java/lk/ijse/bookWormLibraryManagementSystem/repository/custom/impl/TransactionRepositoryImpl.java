package lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.entity.Transaction;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.TransactionRepository;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {

    @Setter
    private static Session session;

    @Override
    public void save(Transaction entity) {
        session.save(entity);
    }

    @Override
    public void update(Transaction entity) {

    }

    @Override
    public void delete(Transaction entity) {

    }

    @Override
    public Transaction getData(int id) {
        return session.get(Transaction.class, id);
    }

    @Override
    public List<Transaction> getAllId() {
        String hqlQuery = "From Transaction";
        Query<Transaction> query = session.createQuery(hqlQuery);
        return query.list();
    }

    @Override
    public int getLastId() {
        String jpqlQuery = "SELECT MAX(t.id) FROM Transaction t";
        Query query = session.createQuery(jpqlQuery);
        if (query.uniqueResult() == null) return 0;
        else return (int) query.uniqueResult();
    }

}
