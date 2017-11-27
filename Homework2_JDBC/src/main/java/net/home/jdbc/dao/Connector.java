package net.home.jdbc.dao;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.*;

public class Connector {
    private PreparedStatement selectSt;
    private PreparedStatement updateSt;
    private PreparedStatement insertSt;
    private Connection connection;
    private Statement statement;
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/homework_2";
    public static final String USER = "root";
    public static final String PASS = "root";

    public Connector() {
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
                    (PreparedStatement) connection.prepareStatement("UPDATE DEVELOPER SET FIRST_NAME=?, LAST_NAME=? WHERE ID=?");

            insertSt = (PreparedStatement) connection.
                    prepareStatement("INSERT INTO DEVELOPER (FIRST_NAME, LAST_NAME) VALUES(?, ?)");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

}









