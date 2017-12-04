package net.home.jdbc.dao;

import net.home.jdbc.dao.entiti.Developer;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T, ID> {

    T getById(ID id) throws SQLException;

     Developer getAll() throws SQLException;

    Developer save(Developer developer) throws SQLException;

    void update(T t);

    Developer deleteDeveloper(long id);

    List<Developer> listDevelopers() throws SQLException;
    void addDevelopers(List<Developer> developers);
}