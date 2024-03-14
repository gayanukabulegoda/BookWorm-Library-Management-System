package lk.ijse.bookWormLibraryManagementSystem.repository.custom;

import lk.ijse.bookWormLibraryManagementSystem.entity.Branch;
import lk.ijse.bookWormLibraryManagementSystem.repository.CrudRepository;

public interface BranchRepository extends CrudRepository<Branch> {

    int getAllBranchCount();

}
