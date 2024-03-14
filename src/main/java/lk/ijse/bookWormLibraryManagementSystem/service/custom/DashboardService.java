package lk.ijse.bookWormLibraryManagementSystem.service.custom;

import lk.ijse.bookWormLibraryManagementSystem.dto.TransactionDto;
import lk.ijse.bookWormLibraryManagementSystem.projection.AdminProjection;
import lk.ijse.bookWormLibraryManagementSystem.service.SuperService;

import java.util.List;

public interface DashboardService extends SuperService {

    List<TransactionDto> getAllTransactions();
    List<AdminProjection> getAdminIdAndName();
    List<TransactionDto> getAllOverDueBorrowers();
    int getAllUserCount();
    int getAllBookCount();
    int getAllBranchCount();

}
