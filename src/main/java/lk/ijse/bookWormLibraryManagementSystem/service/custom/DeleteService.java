package lk.ijse.bookWormLibraryManagementSystem.service.custom;

import lk.ijse.bookWormLibraryManagementSystem.service.SuperService;

public interface DeleteService extends SuperService {

    boolean deleteAdmin(int id);
    boolean deleteBook(int id);
    boolean deleteBranch(int id);
    boolean deleteUser(int id);

}
