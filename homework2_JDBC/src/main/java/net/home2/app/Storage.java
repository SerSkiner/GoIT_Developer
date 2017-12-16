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
    public static final String URL = "jdbc:mysql://localhost/homework_2";
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
        String stringQuery = "INSERT INTO projects (NAME) " +
                "VALUES ('" + project.getName() + "')";
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
        String stringQuery = "UPDATE projects SET NAME=? WHERE ID=?";
        System.out.println("\n================\n");
        System.out.println(stringQuery);

        try {
            updateSt = connection.prepareStatement(stringQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            updateSt.setString(1, project.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            updateSt.setLong(2, project.getId());
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

    public Project deleteProject(long id) {
        String sql = "DELETE FROM projects WHERE ID =" + id;
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
        String selectAllQuery = "SELECT id, name FROM projects";
        Statement statement = getConnection().createStatement();

        statement.executeQuery(selectAllQuery);

        List<Project> projects = new ArrayList<Project>();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(selectAllQuery);

            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");

                Project project = new Project();
                project.setId(id);
                project.setName(name);

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
        String stringQuery = "INSERT INTO skills (NAME) " +
                "VALUES ('" + skill.getName() + "')";
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
        String stringQuery = "UPDATE skills SET NAME=? WHERE ID=?";
        System.out.println("\n================\n");
        System.out.println(stringQuery);

        try {
            updateSt = connection.prepareStatement(stringQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            updateSt.setString(1, skill.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            updateSt.setLong(2, skill.getId());
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

    public Skill deleteSkill(long id) {
        String sql = "DELETE FROM skills WHERE ID =" + id;
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
        String selectAllQuery = "SELECT id, name FROM skills";
        Statement statement = getConnection().createStatement();

        statement.executeQuery(selectAllQuery);

        List<Skill> skills = new ArrayList<Skill>();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(selectAllQuery);

            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");

                Skill skill = new Skill();
                skill.setId(id);
                skill.setName(name);

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
        String stringQuery = "INSERT INTO developers (name, salary) " +
                "VALUES ('" + developer.getName() + "','" + developer.getSalary() + "')";
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
                "NAME='" + developer.getName() + "', " +
                "SALARY='" + developer.getSalary() + "'" +
                "WHERE  ID=" + developer.getId();
        System.out.println("\n================\n");
        System.out.println(sql);
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Developer deleteDeveloper(long id) {
        String sql = "DELETE FROM developers WHERE ID =" + id;
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
        String selectAllQuery = "SELECT id, name, salary FROM developers";
        Statement statement = getConnection().createStatement();

        statement.executeQuery(selectAllQuery);

        List<Developer> developers = new ArrayList<Developer>();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(selectAllQuery);

            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String salary = rs.getString("salary");

                Developer developer = new Developer();
                developer.setId(id);
                developer.setName(name);
                developer.setSalary(salary);

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

    public Developer getDev() throws SQLException {
        String sql = "select developers.name, skills.id\n" +
                "from developers, skills, Dev_Skills\n" +
                "where (developers.ID = Dev_Skills.DEVELOPERS_ID and skills.ID = Dev_Skills.SKILLS_ID)";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {
            String name = resultSet.getString("name");
            long skillID = resultSet.getLong("Id");


            System.out.println("\n================\n");
            System.out.println("NameDeveloper: " + name);
            System.out.println("IdSkill: " + skillID);


        }

        return null;
    }

    public DevSkills addSkil(DevSkills devskills) throws SQLException {
        String stringQuery = "INSERT INTO Dev_skills (developers_id, skills_id) " +
                "VALUES ('" + devskills.getDevelopers_id() + "','" + devskills.getSkills_id() + "')";
        System.out.println("\n================\n");
        System.out.println(stringQuery);


        try {
            Statement statement = getConnection().createStatement();

            statement.executeUpdate(stringQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devskills;

    }

    public Project getPro() throws SQLException {
        String sql = "select projects.name, developers.ID\n" +
                "from projects, developers, Pro_DEV\n" +
                "where (PROJECTS.ID = Pro_DEV.PROJECTS_ID and developers.id = Pro_DEV.DEVELOPERS_ID)";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {
            String name = resultSet.getString("name");
            long DeveloperID = resultSet.getLong("Id");


            System.out.println("\n================\n");
            System.out.println("NameProject: " + name);
            System.out.println("IdDeveloper: " + DeveloperID);


        }

        return null;
    }



    public ProDev adddev(ProDev prodev) throws SQLException {
        String stringQuery = "INSERT INTO Pro_DEV (projects_id, developers_id) " +
                "VALUES ('" + prodev.getProjects_id() + "','" + prodev.getDevelopers_id() + "')";
        System.out.println("\n================\n");
        System.out.println(stringQuery);


        try {
            Statement statement = getConnection().createStatement();

            statement.executeUpdate(stringQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prodev;
    }
}