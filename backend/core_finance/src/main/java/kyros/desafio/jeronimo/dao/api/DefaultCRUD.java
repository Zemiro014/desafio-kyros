package kyros.desafio.jeronimo.dao.api;

import java.util.List;

public interface DefaultCRUD<T, D>{
    void create(T entity);

    void delete(String id);

    T findById(String id);

    List<T> findAll();

    void update(String id, D vo);
}
