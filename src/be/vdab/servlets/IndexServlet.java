package be.vdab.servlets;

import be.vdab.entities.begroeting;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/index.jsp";

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.setAttribute("begroeting", new begroeting());
        request.getRequestDispatcher(VIEW).forward(request, response);
    }
}