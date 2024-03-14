package lk.ijse.bookWormLibraryManagementSystem.repository.custom;

import lk.ijse.bookWormLibraryManagementSystem.entity.User;
import lk.ijse.bookWormLibraryManagementSystem.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User> {

    boolean checkUsernameAndPassword(String username, String password);
    User getUser(String username);
    int getAllUserCount();

}
