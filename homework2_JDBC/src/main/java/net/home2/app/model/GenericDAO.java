package net.home2.app.model;

import net.home2.app.dao.Dev_Skills;
import net.home2.app.dao.Project;
import net.home2.app.dao.Skill;
import net.home2.app.dao.Developer;
import net.home2.app.dao.Pro_Dev;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO {
    Project getAll() throws SQLException;

    Project save(Project project) throws SQLException;

   Project  updateProject(Project project);

    Project deleteProject(long id);

    List<Project> listProject() throws SQLException;
    void addProject(List<Project> projects);

    Skill save(Skill skill) throws SQLException;

    Skill  updateSkill(Skill skill);

    Skill deleteSkill(long id);

    List<Skill> listSkill() throws SQLException;

    void addSkill(List<Skill> skills);

    Developer save(Developer developer) throws SQLException;

    void updateDeveloper(Developer developer);

    Developer deleteDeveloper(long id);


    List<Developer> listDeveloper() throws SQLException;
    void addDeveloper(List<Developer> developers);


 Developer getDev() throws SQLException;
 Dev_Skills addSkil(Dev_Skills dev_skills) throws SQLException;

 Project getPro() throws SQLException;
 Pro_Dev adddev(Pro_Dev pro_dev) throws SQLException;


}
