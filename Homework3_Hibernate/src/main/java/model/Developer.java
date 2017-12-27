package model;

import javax.persistence.*;

@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "developer_name")
    private String developer_name;


    @Column(name = "skill_id")
    private  Long skill_id;

    @Column(name = "salary")
    private String salary;

    public Developer() {

    }

    public Developer(Long id, String developer_name,  Long skill_id, String salary) {
        this.id = id;
        this.developer_name = developer_name;
        this.skill_id = skill_id;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeveloper_name() {
        return developer_name;
    }

    public void setDeveloper_name(String developer_name) {
        this.developer_name = developer_name;
    }





    public Long getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(Long skill_id) {
        this.skill_id = skill_id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", developer_name='" + developer_name + '\'' +
                ", skill_id=" + skill_id +
                ", salary='" + salary + '\'' +
                '}';
    }
}