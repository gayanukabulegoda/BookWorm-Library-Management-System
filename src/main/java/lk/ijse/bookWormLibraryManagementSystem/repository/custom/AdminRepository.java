package lk.ijse.bookWormLibraryManagementSystem.repository.custom;

import lk.ijse.bookWormLibraryManagementSystem.entity.Admin;
import lk.ijse.bookWormLibraryManagementSystem.projection.AdminProjection;
import lk.ijse.bookWormLibraryManagementSystem.repository.CrudRepository;

import java.util.List;

public interface AdminRepository extends CrudRepository<Admin> {

    boolean checkUsernameAndPassword(String username, String password);
    Admin getAdmin(String username);
    List<AdminProjection> getAdminIdAndName();

}
