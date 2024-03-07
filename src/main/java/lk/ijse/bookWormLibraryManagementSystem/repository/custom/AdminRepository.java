package lk.ijse.bookWormLibraryManagementSystem.repository.custom;

import lk.ijse.bookWormLibraryManagementSystem.entity.Admin;
import lk.ijse.bookWormLibraryManagementSystem.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin> {

    boolean checkUsernameAndPassword(String username, String password);

}
