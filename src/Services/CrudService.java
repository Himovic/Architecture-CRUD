package Services;

import java.util.List;

public interface CrudService<T,REF> {

    List<T> findAll(T t);
    T findByRef(REF ref, Class<T> tClass);
    T save(T object, Class<T> tClass);
    boolean delete(T object, Class<T> tClass);
    boolean update(T newObject, Class<T> tClass);
}
