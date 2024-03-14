package lk.ijse.bookWormLibraryManagementSystem.service.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.dto.AdminDto;
import lk.ijse.bookWormLibraryManagementSystem.entity.Admin;
import lk.ijse.bookWormLibraryManagementSystem.repository.RepositoryFactory;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.AdminRepository;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.AdminRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.AdminService;
import lk.ijse.bookWormLibraryManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    AdminRepository adminRepository =
            (AdminRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.ADMIN);

    public Session session;

    public void initializeSession() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public boolean saveAdmin(AdminDto dto) {
        Admin admin = convertToEntity(dto);
        initializeSession();
        Transaction transaction = session.beginTransaction();
        try {
            AdminRepositoryImpl.setSession(session);
            adminRepository.save(admin);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateAdmin(AdminDto dto) {
        System.out.println(dto+" admin DTTTT000");
        Admin admin = convertToEntity(dto);
        System.out.println(admin+" admin Entityyyyyyyy");
        initializeSession();
        Transaction transaction = session.beginTransaction();
        try {
            AdminRepositoryImpl.setSession(session);
            adminRepository.update(admin);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public AdminDto getAdminData(int id) {
        try {
            initializeSession();
            AdminRepositoryImpl.setSession(session);
            return convertToDto(adminRepository.getData(id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<AdminDto> getAllAdminId() {
        List<AdminDto> idList = new ArrayList<>();
        try {
            initializeSession();
            AdminRepositoryImpl.setSession(session);
            List<Admin> allAdminId = adminRepository.getAllId();
            for (Admin admin : allAdminId) {;
                idList.add(convertToDto(admin));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return idList;
    }

    @Override
    public boolean checkUsernameAndPassword(String username, String password) {
        try {
            initializeSession();
            AdminRepositoryImpl.setSession(session);
            return adminRepository.checkUsernameAndPassword(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public AdminDto getAdmin(String username) {
        try {
            initializeSession();
            AdminRepositoryImpl.setSession(session);
            Admin admin = adminRepository.getAdmin(username);
            return convertToDto(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    private Admin convertToEntity(AdminDto dto) {
        Admin entity = new Admin();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setContactNo(dto.getContactNo());
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    private AdminDto convertToDto(Admin entity) {
        if (entity == null) return null;
        return new AdminDto(
                entity.getId(),
                entity.getName(),
                entity.getContactNo(),
                entity.getEmail(),
                entity.getUsername(),
                entity.getPassword()
        );
    }

}
