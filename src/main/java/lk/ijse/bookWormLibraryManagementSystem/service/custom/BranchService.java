package lk.ijse.bookWormLibraryManagementSystem.service.custom;

import lk.ijse.bookWormLibraryManagementSystem.dto.BranchDto;
import lk.ijse.bookWormLibraryManagementSystem.service.SuperService;

import java.util.List;

public interface BranchService extends SuperService {

    boolean saveBranch(BranchDto dto);
    boolean updateBranch(BranchDto dto);
    BranchDto getBranchData(int id);
    List<BranchDto> getAllBranchId();

}
