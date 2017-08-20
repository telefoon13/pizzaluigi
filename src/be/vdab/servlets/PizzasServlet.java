package be.vdab.servlets;

import be.vdab.entities.pizza;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

@WebServlet("/pizzas.htm")
public class PizzasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/pizzas.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("pizzas", Arrays.asList(
				new pizza(12, "Prosciutto", BigDecimal.valueOf(5), true),
				new pizza(12, "Margherita", BigDecimal.valueOf(4), false),
				new pizza(12, "Calzone", BigDecimal.valueOf(7), true)));
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
