package net.home2.app.dao;

public class Developer {
    private Long id_developer;
    private String developer_name;
    private String skill_name;
    private  Long id_skill;
    private String salary;

    public Developer() {

    }

    public Developer(Long id_developer, String developer_name, String skill_name, Long id_skill, String salary) {
        this.id_developer = id_developer;
        this.developer_name = developer_name;
        this.skill_name = skill_name;
        this.id_skill = id_skill;
        this.salary = salary;
    }

    public Long getId_developer() {
        return id_developer;
    }

    public void setId_developer(Long id_developer) {
        this.id_developer = id_developer;
    }

    public String getDeveloper_name() {
        return developer_name;
    }

    public void setDeveloper_name(String developer_name) {
        this.developer_name = developer_name;
    }

    public Long getId_skill() {
        return id_skill;
    }

    public void setId_skill(Long id_skill) {
        this.id_skill = id_skill;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id_developer=" + id_developer +
                ", developer_name='" + developer_name + '\'' +
                ", skill_name='" + skill_name + '\'' +
                ", id_skill=" + id_skill +
                ", salary='" + salary + '\'' +
                '}';
    }
}
