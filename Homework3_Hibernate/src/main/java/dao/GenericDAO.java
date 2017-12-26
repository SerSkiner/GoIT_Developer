package dao;

import model.Skill;

import java.util.List;

public interface GenericDAO<T, ID> {

    void save(T t);

    T getById(ID id);

    void remove(ID id);

    List<T> getAll();
}
