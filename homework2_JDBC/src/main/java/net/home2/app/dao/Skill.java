package net.home2.app.dao;

public class Skill {
    private Long id_skill;
    private String skill_name;


    public Skill() {

    }

    public Skill(Long id_skill, String skill_name) {
        this.id_skill = id_skill;
        this.skill_name = skill_name;
    }

    public Long getId_skill() {
        return id_skill;
    }

    public void setId_skill(Long id_skill) {
        this.id_skill = id_skill;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id_skill=" + id_skill +
                ", skill_name='" + skill_name + '\'' +
                '}';
    }
}
