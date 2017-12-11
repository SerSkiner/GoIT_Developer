package net.home2.app.dao;

public class Project {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Project() {
        this.id = id;
        this.name = name;

    }

    @Override
    public String toString() {
        return id + ", " + name;
    }
}
