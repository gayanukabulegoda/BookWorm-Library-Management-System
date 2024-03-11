package lk.ijse.bookWormLibraryManagementSystem.repository.custom;

import lk.ijse.bookWormLibraryManagementSystem.entity.Transaction;
import lk.ijse.bookWormLibraryManagementSystem.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction> {

    int getLastId();

}
