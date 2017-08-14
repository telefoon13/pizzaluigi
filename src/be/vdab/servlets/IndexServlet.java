package be.vdab.servlets;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.time.LocalDateTime;

public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/index.jsp";

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        int uur = LocalDateTime.now().getHour();
        request.setAttribute("begroeting", uur >= 6 && uur < 12 ? "Goede morgen deze morgen" : uur >= 12 && uur < 18 ? "Goede middag" : "Goede avond");
        request.getRequestDispatcher(VIEW).forward(request, response);
    }
}
