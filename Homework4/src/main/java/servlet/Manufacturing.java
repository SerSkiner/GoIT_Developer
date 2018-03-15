package servlet;

import dao.ManufacturerDAO;
import dao.hibernate.ManufacturerDAOImpl;

public class Manufacturing {
    private static final ManufacturerDAO manufacturerDAO = new ManufacturerDAOImpl();
    public static ManufacturerDAO getManufacturerDAO() {
        return manufacturerDAO;
    }
}
