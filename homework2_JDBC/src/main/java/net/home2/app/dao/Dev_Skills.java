package net.home2.app.dao;

public class Dev_Skills {
    private Long Developers_id;

    public Long getDevelopers_id() {
        return Developers_id;
    }

    public void setDevelopers_id(Long developers_id) {
        Developers_id = developers_id;
    }

    public Long getSkills_id() {
        return Skills_id;
    }

    public void setSkills_id(Long skills_id) {
        Skills_id = skills_id;
    }

    private Long Skills_id;



    @Override
        public String toString() {
            return Developers_id + ", " + Skills_id;
        }

    }

