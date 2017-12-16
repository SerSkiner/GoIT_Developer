package net.home2.app.dao;

public class ProDev {
    private Long Projects_id;
    private Long Developers_id;

    public Long getProjects_id() {
        return Projects_id;
    }

    public void setProjects_id(Long projects_id) {
        Projects_id = projects_id;
    }

    public Long getDevelopers_id() {
        return Developers_id;
    }

    public void setDevelopers_id(Long developers_id) {
        Developers_id = developers_id;
    }

    @Override
    public String toString() {
        return "Pro_Dev{" +
                "Projects_id=" + Projects_id +
                ", Developers_id=" + Developers_id +
                '}';
    }
}
