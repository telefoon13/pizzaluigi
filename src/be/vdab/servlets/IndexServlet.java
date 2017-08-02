package be.vdab.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class IndexServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"nl\"><head>");
        out.println("<title>Pizza Luigi</title></head>");
        out.println("<body><h1>");
        int uur = LocalDateTime.now().getHour();
        out.println(uur >= 6 && uur < 12 ? "Goede morgen deze morgen" : uur >= 12 && uur < 18 ? "Goede middag" : "Goede avond");
        out.println("</h1></body></html>");
    }
}
