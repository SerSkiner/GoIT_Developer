package dao;

import model.Skill;

import java.util.List;


public interface SkillDAO extends GenericDAO<Skill, Long> {

    List<Skill> getAllSkill();

    void save(Skill skill);





}
