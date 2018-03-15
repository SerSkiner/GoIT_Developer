package servlet;

import dao.ManufacturerDAO;
import dao.hibernate.ManufacturerDAOImpl;
import dao.hibernate.ProductDAOImpl;
import model.Manufacturer;
import model.Product;

import javax.persistence.Id;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAOImpl productDAO = new ProductDAOImpl();

        if (request.getParameter("addProduct") != null) {
            Product product = new Product();
            product.setNAME(request.getParameter("name"));
            product.setPRICE(request.getParameter("price"));
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setID(Long.parseLong(request.getParameter("MANUFACTURER_ID")));
            product.setManufacturer(manufacturer);
            productDAO.save(product);
            request.setAttribute("list", productDAO.getAll());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("products.jsp");
            requestDispatcher.forward(request, response);
        }
        if (request.getParameter("showProduct") != null) {
            request.setAttribute("list", productDAO.getAll());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("products.jsp");
            requestDispatcher.forward(request, response);
        }

        String action = request.getParameter("action");
        {

            if (action.equalsIgnoreCase("deleteProduct")) {
                productDAO.remove(Long.parseLong(request.getParameter("id")));
                request.setAttribute("list", productDAO.getAll());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("products.jsp");
                requestDispatcher.forward(request, response);

            }
        }
    }
}