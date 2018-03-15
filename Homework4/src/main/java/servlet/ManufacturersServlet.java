package servlet;


import dao.ManufacturerDAO;
import dao.hibernate.ManufacturerDAOImpl;
import model.Manufacturer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/manufacturers")
public class ManufacturersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ManufacturerDAOImpl manufacturerDAO = new ManufacturerDAOImpl();

        if (request.getParameter("addManufacturer") != null) {
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setNAME(request.getParameter("name"));
            manufacturerDAO.save(manufacturer);
            request.setAttribute("manufacturerList", manufacturerDAO.getAll());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("manufacturers.jsp");
            requestDispatcher.forward(request, response);
        }
        if (request.getParameter("showManufacturer") != null) {
            request.setAttribute("manufacturerList", Manufacturing.getManufacturerDAO().getAll());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("manufacturers.jsp");
            requestDispatcher.forward(request, response);
        }
            String action = request.getParameter("action");
            {

                if (action.equalsIgnoreCase("deleteManufacturer")) {
                    manufacturerDAO.remove(Long.parseLong(request.getParameter("id")));
                    request.setAttribute("manufacturerList", Manufacturing.getManufacturerDAO().getAll());
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("manufacturers.jsp");
                    requestDispatcher.forward(request, response);

                }
            }
        }
    }
