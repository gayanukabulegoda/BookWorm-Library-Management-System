package lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.entity.TransactionDetail;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.TransactionDetailRepository;
import lombok.Setter;
import org.hibernate.Session;

public class TransactionDetailRepositoryImpl implements TransactionDetailRepository {

    @Setter
    private static Session session;

    @Override
    public void save(TransactionDetail entity) {
        session.save(entity);
    }

}
