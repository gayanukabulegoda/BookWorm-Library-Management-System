package lk.ijse.bookWormLibraryManagementSystem.repository.custom;

import lk.ijse.bookWormLibraryManagementSystem.entity.TransactionDetail;
import lk.ijse.bookWormLibraryManagementSystem.repository.SuperRepository;

public interface TransactionDetailRepository extends SuperRepository {

    void save(TransactionDetail entity);

}
