package ua.lviv.iot.db4.dblab4.controller;

import java.util.List;
import java.util.Optional;

public interface GeneralController<T, ID> {

    List<T> findAll();

    Optional<T> findById(ID id);

    int create(T entity);

    int update(ID id, T entity);

    int delete(ID id);
}
