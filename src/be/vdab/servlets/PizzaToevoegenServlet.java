package be.vdab.servlets;

import be.vdab.entities.pizza;
import be.vdab.repositories.PizzaRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/pizzas/toevoegen.htm", name = "PizzaToevoegenServlet")
public class PizzaToevoegenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/pizzatoevoegen.jsp";
	private static final String REDIRECT_URL = "%s/pizzas.htm";
	private static final String PIZZATOEVOEGEN_REQUESTS = "pizzaToevoegenRequests";
	private final PizzaRepository pizzaRepository = new PizzaRepository();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> fouten = new HashMap<>();
		String naam = request.getParameter("naam");
		BigDecimal prijs = null;

		if (!pizza.isNaamValid(naam)) {
			fouten.put("naam", "Verplicht veld.");
		}

		try {
			prijs = new BigDecimal(request.getParameter("prijs"));
			if (!pizza.isPrijsValid(prijs)) {
				fouten.put("prijs", "Een positief getal aub.");
			}
		} catch (NullPointerException | NumberFormatException ex) {
			fouten.put("prijs", "Geef een getal aub.");
		}
		if (fouten.isEmpty()) {
			boolean pikant = "pikant".equals(request.getParameter("pikant"));
			pizzaRepository.create(new pizza(naam, prijs, pikant));
			response.sendRedirect(String.format(REDIRECT_URL, request.getContextPath()));
		} else {
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		((AtomicInteger) this.getServletContext().getAttribute(PIZZATOEVOEGEN_REQUESTS)).incrementAndGet();

		request.getRequestDispatcher(VIEW).forward(request, response);

	}

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(PIZZATOEVOEGEN_REQUESTS, new AtomicInteger());
	}
}
