package dao;

import model.Developer;
import model.Skill;

import java.util.List;


public interface DeveloperDAO extends GenericDAO<Developer, Long> {
    List<Developer> getAll();

    void save(Developer developer);

}
