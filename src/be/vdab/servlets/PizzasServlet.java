package be.vdab.servlets;

import be.vdab.repositories.PizzaRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/pizzas.htm", name = "PizzaServlet")
public class PizzasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/pizzas.jsp";
	private static final String PIZZA_REQUESTS = "pizzaRequests";
	private final PizzaRepository pizzaRepository = new PizzaRepository();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("pizzas", pizzaRepository.findAll());

		((AtomicInteger) this.getServletContext().getAttribute(PIZZA_REQUESTS)).incrementAndGet();

		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(PIZZA_REQUESTS, new AtomicInteger());
	}
}