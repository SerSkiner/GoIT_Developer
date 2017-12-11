package net.home2.app.dao;

public class Skill {
    private Long id;
    private String name;

    public Skill(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Skill() {
        this.id = id;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ", " + name;
    }
}
