package net.home.jdbc.dao;

import net.home.jdbc.dao.entiti.Developer;

import java.sql.SQLException;

public interface GenericDAO<T, ID> {

    T getById(ID id) throws SQLException;

     Developer getAll() throws SQLException;

    void save(Developer developer) throws SQLException;

    void update(T t);

    void delete(T t);
}