package lk.ijse.bookWormLibraryManagementSystem.repository.custom;

import lk.ijse.bookWormLibraryManagementSystem.entity.Transaction;
import lk.ijse.bookWormLibraryManagementSystem.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction> {

    List<Transaction> getAllOverDueBorrowers();
    int getLastId();

}
