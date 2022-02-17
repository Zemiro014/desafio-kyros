package kyros.desafio.jeronimo.dao.api.apidefault;

import java.util.List;

public interface DefaultCRUD<T>{
    void create(T entity);

    void delete(String id);

    T findById(String id);

    List<T> findAll();

    void update(T entity);
}