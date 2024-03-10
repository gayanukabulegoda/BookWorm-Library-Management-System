package lk.ijse.bookWormLibraryManagementSystem.repository;

import java.util.List;

public interface CrudRepository<T> extends SuperRepository {

    void save(T entity);
    void update(T entity);
    void delete(T entity);
    T getData(int id);
    List<T> getAllId();

}
