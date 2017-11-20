package net.home.jdbc.dao;

import net.home.jdbc.dao.DeveloperDAO;
import net.home.jdbc.dao.DeveloperDAOImpl;
import net.home.jdbc.dao.entiti.Developer;

import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException {
        DeveloperDAO developerDAO = new DeveloperDAOImpl();
        Developer developer = developerDAO.getById(2L);

        System.out.println(developer);
    }


}
