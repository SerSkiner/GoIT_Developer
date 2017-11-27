package net.home.jdbc.dao;

import net.home.jdbc.dao.entiti.Developer;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    public void save(Developer developer) throws SQLException {
        String stringQuery = "INSERT INTO developers (FIRST_NAME,LAST_NAME,salary) " +
                "VALUES ('"+developer.getFirstName()+"','"+developer.getLastName()+"','"+developer.getSalary()+"')";
        System.out.println("\n================\n");
        System.out.println(stringQuery);


        try {
            Statement statement = Connector.getConnection().createStatement();

            statement.executeUpdate(stringQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void update(Developer developer) {

    }

    public void delete(Developer developer) {

    }


    public static void main(String[] args) throws SQLException {
        DeveloperDAOImpl developerDAO = new DeveloperDAOImpl();
        developerDAO.getAll();
        developerDAO.save(new Developer("Maxim", "Drozd","2600"));
    }
}