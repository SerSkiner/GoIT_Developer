package net.home2.app.model;

import net.home2.app.dao.*;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO {
    Project getAll() throws SQLException;

    Project save(Project project) throws SQLException;

   Project  updateProject(Project project);

    Project deleteProject(long id_project);

    List<Project> listProject() throws SQLException;
    void addProject(List<Project> projects);

    Skill save(Skill skill) throws SQLException;

    Skill  updateSkill(Skill skill);

    Skill deleteSkill(long id_skill);

    List<Skill> listSkill() throws SQLException;

    void addSkill(List<Skill> skills);

    Developer save(Developer developer) throws SQLException;

    void updateDeveloper(Developer developer);

    Developer deleteDeveloper(long id);


    List<Developer> listDeveloper() throws SQLException;
    void addDeveloper(List<Developer> developers);


 Developer addSkill(Developer developer) throws SQLException;

 Project addDev(Project project) throws SQLException;


}
