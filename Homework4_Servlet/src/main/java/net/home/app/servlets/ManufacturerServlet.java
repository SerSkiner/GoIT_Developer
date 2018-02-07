package net.home.app.servlets;

import net.home.app.model.Manufacter;
import net.home.app.dao.hibernate.ProductDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManufacturerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        if(request.getParameter("addManufacturer")!=null){
            Manufacter manufacter = new Manufacter();
            manufacter.setManufacter_name(request.getParameter("name"));
            productDAOImpl.saveManufacter(manufacter);
            request.setAttribute("list",productDAOImpl.getManufacters());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/2/list.jsp");
            requestDispatcher.forward(request,response);
        }
        if(request.getParameter("showManufacter")!=null){
            request.setAttribute("list",productDAOImpl.getManufacters());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/2/list.jsp");
            requestDispatcher.forward(request,response);
            }

        String action=request.getParameter("action");
        if(action.equalsIgnoreCase("updateManufacter")){
            request.setAttribute("manufacters", productDAOImpl.getId("id"));
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/2/update.jsp");
            requestDispatcher.forward(request,response);
        }
        if(action.equalsIgnoreCase("deleteManufacter")){
            productDAOImpl.deleteManufacter(request.getParameter("id"));
            request.setAttribute("list",productDAOImpl.getManufacters());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/2/list.jsp");
            requestDispatcher.forward(request,response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        if (request.getParameter("updateManufacter") != null) {
            Manufacter manufacter = new Manufacter();
            manufacter.setId(request.getParameter("id"));
            manufacter.setManufacter_name("name");
            productDAOImpl.updateManufacter(manufacter);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/2/list.jsp");
            requestDispatcher.forward(request, response);

        }
    }
}
