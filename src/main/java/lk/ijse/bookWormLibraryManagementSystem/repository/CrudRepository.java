package lk.ijse.bookWormLibraryManagementSystem.repository;

import java.util.List;

public interface CrudRepository<T> extends SuperRepository {

    boolean save(T entity);
    boolean update(T entity);
    boolean delete(int id);
    T getData(int id);
    List<T> getAllId();

}
