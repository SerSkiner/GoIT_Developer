package net.home.app.servlets;

import net.home.app.dao.hibernate.ProductDAOImpl;
import net.home.app.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        if (request.getParameter("addProduct") != null) {
            Product product = new Product();
            product.setProduct_name(request.getParameter("name"));
            product.setPrice(request.getParameter("price"));
            productDAOImpl.saveProduct(product);
            request.setAttribute("list", productDAOImpl.getProducts());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
            requestDispatcher.forward(request, response);
        }


        if (request.getParameter("showProducts") != null) {
            request.setAttribute("list", productDAOImpl.getProducts());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
            requestDispatcher.forward(request, response);
        }
        /////////for list.jsp///////////////////
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("update")) {
            request.setAttribute("products", productDAOImpl.getById(request.getParameter("id")));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
            requestDispatcher.forward(request, response);
        }

        if (action.equalsIgnoreCase("delete")) {//если action отреагировал на update
            productDAOImpl.deleteProduct(request.getParameter("id"));
            request.setAttribute("list", productDAOImpl.getProducts());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
            requestDispatcher.forward(request, response);
        }


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        if (request.getParameter("update") != null) {
            Product product = new Product();
            product.setProduct_name(request.getParameter("name"));
            product.setPrice(request.getParameter("price"));
            productDAOImpl.updateProduct(product);
            request.setAttribute("list", productDAOImpl.getProducts());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
            requestDispatcher.forward(request, response);


        }
    }
}