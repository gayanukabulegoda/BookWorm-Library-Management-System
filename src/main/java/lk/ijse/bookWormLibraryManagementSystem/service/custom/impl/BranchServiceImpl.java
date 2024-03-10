package lk.ijse.bookWormLibraryManagementSystem.service.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.dto.AdminDto;
import lk.ijse.bookWormLibraryManagementSystem.dto.BranchDto;
import lk.ijse.bookWormLibraryManagementSystem.entity.Admin;
import lk.ijse.bookWormLibraryManagementSystem.entity.Branch;
import lk.ijse.bookWormLibraryManagementSystem.repository.RepositoryFactory;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.BranchRepository;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.BranchRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.BranchService;
import lk.ijse.bookWormLibraryManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BranchServiceImpl implements BranchService {

    BranchRepository branchRepository =
            (BranchRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.BRANCH);

    private Session session;

    public void initializeSession() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public boolean saveBranch(BranchDto dto) {
        Branch branch = convertToEntity(dto);
        initializeSession();
        Transaction transaction = session.beginTransaction();
        try {
            BranchRepositoryImpl.setSession(session);
            branchRepository.save(branch);
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
    public boolean updateBranch(BranchDto dto) {
        Branch branch = convertToEntity(dto);
        initializeSession();
        Transaction transaction = session.beginTransaction();
        try {
            BranchRepositoryImpl.setSession(session);
            branchRepository.update(branch);
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
    public BranchDto getBranchData(int id) {
        try {
            initializeSession();
            BranchRepositoryImpl.setSession(session);
            return convertToDto(branchRepository.getData(id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<BranchDto> getAllBranchId() {
        List<BranchDto> idList = new ArrayList<>();
        try {
            initializeSession();
            BranchRepositoryImpl.setSession(session);
            List<Branch> allBranchId = branchRepository.getAllId();
            for (Branch branch : allBranchId) {;
                idList.add(convertToDto(branch));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return idList;
    }

    private Branch convertToEntity(BranchDto dto) {
        Branch entity = new Branch();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());
        entity.setContactNo(dto.getContactNo());
        entity.setAdmin(convertToAdminEntity(dto.getAdmin()));
        return entity;
    }

    private BranchDto convertToDto(Branch entity) {
        return new BranchDto(
                entity.getId(),
                entity.getName(),
                entity.getLocation(),
                entity.getContactNo(),
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
