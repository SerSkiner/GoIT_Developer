package net.home.jdbc.dao;


import net.home.jdbc.dao.entiti.Developer;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperDAOImpl implements DeveloperDAO {

    public Developer getById(Long aLong) throws SQLException {
        return null;
    }

    public Developer getAll() throws SQLException {
        String sql = "SELECT * FROM developers";
        Statement statement = Connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {
            Long developerId = resultSet.getLong("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            BigDecimal salary = resultSet.getBigDecimal("salary");


            System.out.println("\n================\n");
            System.out.println("Id: " + developerId);
            System.out.println("Name: " + firstName);
            System.out.println("LastName: " + lastName);
            System.out.println("Salary: $" + salary);
        }

        return null;

    }

    @Override
    public Developer save(Developer developer) throws SQLException {
        String stringQuery = "INSERT INTO developers (FIRST_NAME,LAST_NAME,salary) " +
                "VALUES ('" + developer.getFirstName() + "','" + developer.getLastName() + "','" + developer.getSalary() + "')";
        System.out.println("\n================\n");
        System.out.println(stringQuery);


        try {
            Statement statement = Connector.getConnection().createStatement();

            statement.executeUpdate(stringQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }


    public void update(Developer developer) {

    }

    @Override
    public Developer deleteDeveloper(long id) {
        String sql = "DELETE FROM developers WHERE ID =" + id;
        System.out.println("\n================\n");
        System.out.println(sql);
        try {
            Statement statement = Connector.getConnection().createStatement();

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Developer> listDevelopers() throws SQLException {
        String selectAllQuery = "SELECT FIRST_NAME, LAST_NAME, salary FROM developers";
        Statement statement = Connector.getConnection().createStatement();

        statement.executeQuery(selectAllQuery);

        List<Developer> developers = new ArrayList<Developer>();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(selectAllQuery);

            while (rs.next()) {
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                String salary = rs.getString("SALARY");

                Developer developer = new Developer();
                developer.setFirstName(firstName);
                developer.setLastName(lastName);
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


    public void addDevelopers(List<Developer> developers) {

    }


    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        DeveloperDAOImpl developerDAO = new DeveloperDAOImpl();

        while (sc.hasNextLine()) {
            String cmd = sc.nextLine();
            String[] parts = cmd.split(" ");
            String command = parts[0];


            if (command.equals("add")) {
                if (parts.length < 4) {
                    System.out.println("Wrong format. Usage: create <first_name> <last_name>");
                    continue;
                }

                String firstName = parts[1];
                String lastName = parts[2];
                String salary = parts[3];

                Developer developer = new Developer();
                developer.setFirstName(firstName);
                developer.setLastName(lastName);
                developer.setSalary(salary);
                developerDAO.save(developer);
                System.out.println("Developer greated");
            } else if (command.equals("devlist")) {
                List<Developer> developers = developerDAO.listDevelopers();
                System.out.println();
                System.out.println();
                System.out.println("ALL DEVELOPERS");
                System.out.println("FIRST_NAME   |   LAST_NAME   |  SALARY");
                for (Developer developer : developers) {
                    System.out.println(developer.getFirstName() + "   |    " + developer.getLastName() + "  |   " + developer.getSalary());
                }
                System.out.println();
            } else if (command.equals("exit") || command.equals("quit")) {
                break;
            } else if (command.equals("delete")) {
                System.out.print("Введите ID: ");
                long id = sc.nextLong();
                Developer developer = developerDAO.deleteDeveloper(id);
                System.out.println("Developer deleted");
            } else if (command.equals("info")) {
                Developer developer = developerDAO.getAll();
            }
        }
    }

}