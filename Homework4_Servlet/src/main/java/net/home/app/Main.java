package net.home.app;

import net.home.app.dao.hibernate.ProductDAOImpl;
import net.home.app.model.Product;
import net.home.app.model.Manufacter;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        Manufacter manufacter = new Manufacter();

        productDAOImpl.updateManufacter(manufacter);


        productDAOImpl.getId("443550f3-01ff-42d6-9813-c7dedccc7a17");
        manufacter.setManufacter_name("FOX");


       // System.out.println(productDAOImpl.getId("443550f3-01ff-42d6-9813-c7dedccc7a17"));

    }
}