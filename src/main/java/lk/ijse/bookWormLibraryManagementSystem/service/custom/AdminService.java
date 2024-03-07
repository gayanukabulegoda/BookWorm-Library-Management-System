package lk.ijse.bookWormLibraryManagementSystem.service.custom;

import lk.ijse.bookWormLibraryManagementSystem.dto.AdminDto;
import lk.ijse.bookWormLibraryManagementSystem.service.SuperService;

public interface AdminService extends SuperService {

    boolean saveAdmin(AdminDto dto);
    boolean checkUsernameAndPassword(String username, String password);

}
