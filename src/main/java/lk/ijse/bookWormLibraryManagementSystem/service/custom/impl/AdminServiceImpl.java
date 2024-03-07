package lk.ijse.bookWormLibraryManagementSystem.service.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.dto.AdminDto;
import lk.ijse.bookWormLibraryManagementSystem.entity.Admin;
import lk.ijse.bookWormLibraryManagementSystem.repository.RepositoryFactory;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.AdminRepository;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.AdminService;

public class AdminServiceImpl implements AdminService {

    AdminRepository adminRepository =
            (AdminRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.ADMIN);

    @Override
    public boolean saveAdmin(AdminDto dto) {
        Admin admin = new Admin();
        admin.setName(dto.getName());
        admin.setContactNo(dto.getContactNo());
        admin.setEmail(dto.getEmail());
        admin.setUsername(dto.getUsername());
        admin.setPassword(dto.getPassword());

        return adminRepository.save(admin);
    }

    @Override
    public boolean checkUsernameAndPassword(String username, String password) {
        return adminRepository.checkUsernameAndPassword(username, password);
    }

}
