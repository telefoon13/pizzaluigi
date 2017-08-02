package be.vdab.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class IndexServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"nl\"><head>");
        out.println("<title>Frituur Frida</title></head>");
        out.println("<body><h1>Frituur Frida</h1><br>");
        int dag = LocalDate.now().getDayOfWeek().getValue();

        if (dag == 1 || dag == 4) {
            out.println("Vandaag Gesloten");
        } else {
            out.println("Vandaag OPEN");
        }
        out.println("</h1></body></html>");

    }
}
