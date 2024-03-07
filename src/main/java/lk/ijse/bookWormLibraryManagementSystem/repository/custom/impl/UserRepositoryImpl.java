package lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.entity.User;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public boolean save(User entity) {
        return false;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User getData(int id) {
        return null;
    }

    @Override
    public List<User> getAllId() {
        return null;
    }
}
