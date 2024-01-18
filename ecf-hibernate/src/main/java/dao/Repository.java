package dao;

import java.util.List;

public interface Repository <T>{
    boolean create(T o);

    boolean delete(int id);

    T findById(int id);

    List<T> findAll();
}
