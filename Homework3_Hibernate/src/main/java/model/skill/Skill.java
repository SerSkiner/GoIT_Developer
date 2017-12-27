package model.skill;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skill_name")
    private String skill_name;


    public Skill() {

    }

    public Skill(Long id, String skill_name) {
        this.id = id;
        this.skill_name = skill_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", skill_name='" + skill_name + '\'' +
                '}';
    }
}

