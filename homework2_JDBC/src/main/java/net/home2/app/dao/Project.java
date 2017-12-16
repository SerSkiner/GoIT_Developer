package net.home2.app.dao;

public class Project {
    private Long id_project;
    private String project_name;
    private Long id_developer;
    private String developer_name;


    public Project() {

    }


    public Project(Long id_project, String project_name, Long id_developer, String developer_name) {
        this.id_project = id_project;
        this.project_name = project_name;
        this.id_developer = id_developer;
        this.developer_name = developer_name;
    }

    public Long getId_project() {
        return id_project;
    }

    public void setId_project(Long id_project) {
        this.id_project = id_project;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
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

    @Override
    public String toString() {
        return "Project{" +
                "id_project=" + id_project +
                ", project_name='" + project_name + '\'' +
                ", id_developer=" + id_developer +
                ", developer_name='" + developer_name + '\'' +
                '}';
    }
}
