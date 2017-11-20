package net.home.jdbc.dao;

import net.home.jdbc.dao.Connector;
import net.home.jdbc.dao.DeveloperDAO;
import net.home.jdbc.dao.entiti.Developer;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class DeveloperDAOImpl implements DeveloperDAO {
    @Override
    public Developer getById(Long id) throws SQLException {
            String sql = "SELECT * FROM developers WHERE id = " + id;
            Statement statement = Connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            Developer developer = new Developer();

            while (resultSet.next()) {
                Long developerId = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                BigDecimal salary = resultSet.getBigDecimal("salary");

                developer.withId(developerId)
                        .withFirstName(firstName)
                        .withLastName(lastName)
                        .withSalary(salary);
            }

        return developer;
    }

    public List<Developer> getAll() {
        return null;
    }

    public void save(Developer developer) {

    }

    public void update(Developer developer) {

    }

    public void delete(Developer developer) {

    }
}
