package lk.ijse.bookWormLibraryManagementSystem.service.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.dto.AdminDto;
import lk.ijse.bookWormLibraryManagementSystem.dto.UserDto;
import lk.ijse.bookWormLibraryManagementSystem.entity.Admin;
import lk.ijse.bookWormLibraryManagementSystem.entity.User;
import lk.ijse.bookWormLibraryManagementSystem.repository.RepositoryFactory;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.AdminRepository;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.UserRepository;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.AdminRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.UserRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.UserService;
import lk.ijse.bookWormLibraryManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepository userRepository =
            (UserRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.USER);

    AdminRepository adminRepository =
            (AdminRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.ADMIN);

    private Session session;

    public void initializeSession() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public boolean saveUser(UserDto dto) {
        User user = convertToEntity(dto);
        initializeSession();
        Transaction transaction = session.beginTransaction();
        try {
            UserRepositoryImpl.setSession(session);
            userRepository.save(user);
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
    public boolean updateUser(UserDto dto) {
        User user = convertToEntity(dto);
        initializeSession();
        Transaction transaction = session.beginTransaction();
        try {
            UserRepositoryImpl.setSession(session);
            userRepository.update(user);
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
    public UserDto getUserData(int id) {
        try {
            initializeSession();
            UserRepositoryImpl.setSession(session);
            return convertToDto(userRepository.getData(id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<UserDto> getAllUserId() {
        List<UserDto> idList = new ArrayList<>();
        try {
            initializeSession();
            UserRepositoryImpl.setSession(session);
            List<User> allUserId = userRepository.getAllId();
            for (User user : allUserId) {;
                idList.add(convertToDto(user));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return idList;
    }

    @Override
    public AdminDto getAdminData(int id) {
        try {
            initializeSession();
            AdminRepositoryImpl.setSession(session);
            return convertToAdminDto(adminRepository.getData(id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean checkUsernameAndPassword(String username, String password) {
        try {
            initializeSession();
            UserRepositoryImpl.setSession(session);
            return userRepository.checkUsernameAndPassword(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public UserDto getUser(String username) {
        try {
            initializeSession();
            UserRepositoryImpl.setSession(session);
            User user = userRepository.getUser(username);
            return convertToDto(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    private User convertToEntity(UserDto dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setAdmin(convertToAdminEntity(dto.getAdmin()));
        return entity;
    }

    private UserDto convertToDto(User entity) {
        if (entity == null) return null;
        return new UserDto(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getUsername(),
                entity.getPassword(),
                convertToAdminDto(entity.getAdmin())
        );
    }

    private AdminDto convertToAdminDto(Admin entity) {
        return new AdminDto(
                entity.getId(),
                entity.getName(),
                entity.getContactNo(),
                entity.getEmail(),
                entity.getUsername(),
                entity.getPassword()
        );
    }

    private Admin convertToAdminEntity(AdminDto dto) {
        Admin admin = new Admin();
        admin.setId(dto.getId());
        admin.setName(dto.getName());
        admin.setContactNo(dto.getContactNo());
        admin.setEmail(dto.getEmail());
        admin.setUsername(dto.getUsername());
        admin.setPassword(dto.getPassword());
        return admin;
    }

}
