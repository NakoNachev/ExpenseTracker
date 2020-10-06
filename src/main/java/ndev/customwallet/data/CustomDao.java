package ndev.customwallet.data;

import java.util.List;

public interface CustomDao<T> {

    List<T> getAll();
    void save(T t);
    void delete(T t);
    T getById(int id);
    void update(T t);

}
