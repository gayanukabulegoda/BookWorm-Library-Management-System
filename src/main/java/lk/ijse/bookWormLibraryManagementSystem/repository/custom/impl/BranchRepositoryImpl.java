package lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.entity.Branch;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.BranchRepository;

import java.util.List;

public class BranchRepositoryImpl implements BranchRepository {
    @Override
    public boolean save(Branch entity) {
        return false;
    }

    @Override
    public boolean update(Branch entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Branch getData(int id) {
        return null;
    }

    @Override
    public List<Branch> getAllId() {
        return null;
    }
}
