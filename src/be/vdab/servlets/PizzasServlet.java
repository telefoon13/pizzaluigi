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
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/pizzas.htm")
public class PizzasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/pizzas.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<Long, pizza> pizzas = new LinkedHashMap<>();
		pizzas.put(12L, new pizza(12, "Prosciutto", BigDecimal.valueOf(5), true));
		pizzas.put(14L, new pizza(14, "Margherita", BigDecimal.valueOf(4), false));
		pizzas.put(17L, new pizza(17, "Calzone", BigDecimal.valueOf(7), true));
		request.setAttribute("pizzas", pizzas);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
