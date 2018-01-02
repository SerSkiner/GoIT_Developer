package model.project;

import model.Developer;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name")
    private String project_name;

    @Column(name = "developer_id")
    private Long developer_id;

    @OneToOne
    @JoinColumn(name = "developer_id", updatable = false, insertable = false, referencedColumnName = "id")
    private Developer developer;

   // @Column(name = "developer_name")
    //private String developer_name;


    public Project() {

    }


    public Project(Long id, String project_name, Long developer_id) {
        this.id = id;
        this.project_name = project_name;
        this.developer_id = developer_id;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Long getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(Long developer_id) {
        this.developer_id = developer_id;
    }

    @Override
    public String toString() {
        return id + ", " + project_name + ", " + developer;
    }
}