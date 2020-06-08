package by.devincubator.banklist.dao.api;

import by.devincubator.banklist.entity.Identifiable;
import by.devincubator.banklist.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao <T extends Identifiable>{
    Optional<T> getById(int id) throws DaoException;

    List<T> getAll() throws DaoException;

    void save(T entity) throws DaoException;

    void deleteById (int id) throws DaoException;
}
