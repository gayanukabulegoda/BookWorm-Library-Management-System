package lk.ijse.bookWormLibraryManagementSystem.service.custom;

import lk.ijse.bookWormLibraryManagementSystem.dto.TransactionDto;
import lk.ijse.bookWormLibraryManagementSystem.service.SuperService;

import java.util.List;

public interface TransactionService extends SuperService {

    boolean saveTransaction(TransactionDto dto);
    boolean updateTransaction(TransactionDto dto);
    TransactionDto getTransactionData(int id);
    List<TransactionDto> getTransactionAllId();
    List<TransactionDto> getAllOverDueBorrowers();
    int getLastTransactionId();

}
