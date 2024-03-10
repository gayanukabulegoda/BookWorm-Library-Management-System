package lk.ijse.bookWormLibraryManagementSystem.service.custom;

import lk.ijse.bookWormLibraryManagementSystem.dto.AdminDto;
import lk.ijse.bookWormLibraryManagementSystem.service.SuperService;

import java.util.List;

public interface AdminService extends SuperService {

    boolean saveAdmin(AdminDto dto);
    boolean updateAdmin(AdminDto dto);
    AdminDto getAdminData(int id);
    List<AdminDto> getAllAdminId();
    boolean checkUsernameAndPassword(String username, String password);
    AdminDto getAdmin(String username);

}
