package net.home2.app;

import net.home2.app.dao.*;
import net.home2.app.model.GenericDAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Storage implements GenericDAO {
    private PreparedStatement selectSt;
    private PreparedStatement updateSt;
    private PreparedStatement insertSt;
    private Connection connection;
    private Statement statement;
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost/test1";
    public static final String USER = "root";
    public static final String PASS = "root";

    public Storage() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = (Statement) connection.createStatement();

            selectSt =
                    (PreparedStatement) connection.prepareStatement("SELECT FIRST_NAME, LAST_NAME, ID FROM DEVELOPER WHERE ID=?");

            updateSt =
                    (PreparedStatement) connection.prepareStatement("UPDATE developer SET NAME=?, SALARY=? WHERE ID=?");

            insertSt = (PreparedStatement) connection.
                    prepareStatement("INSERT INTO DEVELOPER (FIRST_NAME, LAST_NAME) VALUES(?, ?)");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public Project getAll() throws SQLException {
        String sql = "SELECT * FROM projects";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {
            Long projectId = resultSet.getLong("id");
            String name = resultSet.getString("name");


            System.out.println("\n================\n");
            System.out.println("Id: " + projectId);
            System.out.println("Name: " + name);

        }

        return null;
    }

    public Project save(Project project) throws SQLException {
        String stringQuery = "INSERT INTO projects (project_name) " +
                "VALUES ('" + project.getProject_name() + "')";
        System.out.println("\n================\n");
        System.out.println(stringQuery);


        try {
            Statement statement = getConnection().createStatement();

            statement.executeUpdate(stringQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    public Project updateProject(Project project) {
        String stringQuery = "UPDATE projects SET project_name=? WHERE id_project=?";
        System.out.println("\n================\n");
        System.out.println(stringQuery);

        try {
            updateSt = connection.prepareStatement(stringQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            updateSt.setString(1, project.getProject_name());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            updateSt.setLong(2, project.getId_project());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            updateSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    public Project deleteProject(long id_project) {
        String sql = "DELETE FROM projects WHERE id_project =" + id_project;
        System.out.println("\n================\n");
        System.out.println(sql);
        try {
            Statement statement = getConnection().createStatement();

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Project> listProject() throws SQLException {
        String selectAllQuery = "SELECT * FROM projects\n" +
                "JOIN developers USING(id_developer)";
        Statement statement = getConnection().createStatement();

        statement.executeQuery(selectAllQuery);

        List<Project> projects = new ArrayList<Project>();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(selectAllQuery);

            while (rs.next()) {
                Long id_project = rs.getLong("id_project");
                String project_name = rs.getString("project_name");
                String developer_name = rs.getString("developer_name");

                Project project = new Project();
                project.setId_project(id_project);
                project.setProject_name(project_name);
                project.setDeveloper_name(developer_name);

                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }

        return projects;
    }

    public void addProject(List<Project> projects) {

    }

    public Skill save(Skill skill) throws SQLException {
        String stringQuery = "INSERT INTO skills (skill_name) " +
                "VALUES ('" + skill.getSkill_name() + "')";
        System.out.println("\n================\n");
        System.out.println(stringQuery);


        try {
            Statement statement = getConnection().createStatement();

            statement.executeUpdate(stringQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

    public Skill updateSkill(Skill skill) {
        String stringQuery = "UPDATE skills SET skill_name=? WHERE id_skill=?";
        System.out.println("\n================\n");
        System.out.println(stringQuery);

        try {
            updateSt = connection.prepareStatement(stringQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            updateSt.setString(1, skill.getSkill_name());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            updateSt.setLong(2, skill.getId_skill());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            updateSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

    public Skill deleteSkill(long id_skill) {
        String sql = "DELETE FROM skills WHERE id_skill =" + id_skill;
        System.out.println("\n================\n");
        System.out.println(sql);
        try {
            Statement statement = getConnection().createStatement();

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Skill> listSkill() throws SQLException {
        String selectAllQuery = "SELECT id_skill, skill_name FROM skills";
        Statement statement = getConnection().createStatement();

        statement.executeQuery(selectAllQuery);

        List<Skill> skills = new ArrayList<Skill>();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(selectAllQuery);

            while (rs.next()) {
                Long id_skill = rs.getLong("id_skill");
                String skill_name = rs.getString("skill_name");

                Skill skill = new Skill();
                skill.setId_skill(id_skill);
                skill.setSkill_name(skill_name);

                skills.add(skill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }

        return skills;
    }

    public void addSkill(List<Skill> skills) {

    }

    public Developer save(Developer developer) throws SQLException {
        String stringQuery = "INSERT INTO developers (developer_name,  salary) " +
                "VALUES ('" + developer.getDeveloper_name() + "','" + developer.getSalary() + "')";
        System.out.println("\n================\n");
        System.out.println(stringQuery);


        try {
            Statement statement = getConnection().createStatement();

            statement.executeUpdate(stringQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }

    public void updateDeveloper(Developer developer) {
        String sql = "UPDATE DEVELOPERS SET " +
                "developer_name='" + developer.getDeveloper_name() + "', " +
                "SALARY='" + developer.getSalary() + "'" +
                "WHERE  id_developer=" + developer.getId_developer();
        System.out.println("\n================\n");
        System.out.println(sql);
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Developer deleteDeveloper(long id_developer) {
        String sql = "DELETE FROM developers WHERE id_developer =" + id_developer;
        System.out.println("\n================\n");
        System.out.println(sql);
        try {
            Statement statement = getConnection().createStatement();

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Developer> listDeveloper() throws SQLException {
        String selectAllQuery = "SELECT * FROM developers\n" +
                "JOIN skills USING(id_skill)";
        Statement statement = getConnection().createStatement();

        statement.executeQuery(selectAllQuery);

        List<Developer> developers = new ArrayList<Developer>();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(selectAllQuery);

            while (rs.next()) {
                Long id_developer = rs.getLong("id_developer");
                String developer_name = rs.getString("developer_name");
                String salary = rs.getString("salary");
                String skill_name = rs.getString("skill_name");


                Developer developer = new Developer();
                developer.setId_developer(id_developer);
                developer.setDeveloper_name(developer_name);
                developer.setSalary(salary);
                developer.setSkill_name(skill_name);

                developers.add(developer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }

        return developers;
    }

    public void addDeveloper(List<Developer> developers) {

    }


    public Developer addSkill(Developer developer) throws SQLException {
        String stringQuery = "UPDATE developers SET id_skill=? WHERE id_developer=?";
        System.out.println("\n================\n");
        System.out.println(stringQuery);

        updateSt = connection.prepareStatement(stringQuery);

        updateSt.setLong(1, developer.getId_skill());

        updateSt.setLong(2, developer.getId_developer());

        updateSt.executeUpdate();


        return developer;
    }


    public Project addDev(Project project) throws SQLException {
        String stringQuery = "UPDATE projects SET id_developer=? WHERE id_project=?";
        System.out.println("\n================\n");
        System.out.println(stringQuery);


        updateSt = connection.prepareStatement(stringQuery);

        updateSt.setLong(1, project.getId_developer());

        updateSt.setLong(2, project.getId_project());

        updateSt.executeUpdate();


        return project;
    }

}