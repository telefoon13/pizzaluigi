package be.vdab.servlets;

import be.vdab.repositories.PizzaRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/pizzas/bestellen.htm", name = "PizzaBestellenServlet")
public class PizzaBestellenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/pizzabestellen.jsp";
	private static final String PIZZABESTELLEN_REQUESTS = "pizzaBestellenRequests";
	private static final String MANDJE = "mandje";
	private final PizzaRepository pizzaRepository = new PizzaRepository();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Bij toevoegen van ID's kijken of er al een mandje is bij neen een maken en invoegen bij ja gewoon invoegen
		if (request.getParameterValues("id") != null) {
			HttpSession session = request.getSession();
			@SuppressWarnings("uncheked")
			Set<Long> mandje = (Set<Long>) session.getAttribute(MANDJE);

			if (mandje == null) {
				mandje = new LinkedHashSet<>();
			}

			mandje.addAll(Arrays.stream(request.getParameterValues("id")).map(id -> Long.parseLong(id)).collect(Collectors.toSet()));
			session.setAttribute(MANDJE, mandje);
		}
		//Redirect
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Alle pizzas laden
		request.setAttribute("pizzas", pizzaRepository.findAll());

		//Kijken of er mandje bestaat en zo ja deze ophalen
		HttpSession session = request.getSession(false);
		if (session != null) {
			@SuppressWarnings("uncheked")
			Set<Long> mandje = (Set<Long>) session.getAttribute(MANDJE);
			if (mandje != null) {
				request.setAttribute("pizzasInMandje",
						mandje.stream().map(id -> pizzaRepository.read(id)).filter(optionalPizza -> optionalPizza.isPresent())
								.map(optionalPizza -> optionalPizza.get()).collect(Collectors.toList()));
			}
		}

		//Bezoekers teller
		((AtomicInteger) this.getServletContext().getAttribute(PIZZABESTELLEN_REQUESTS)).incrementAndGet();

		//Request view
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	//bij init pagina
	@Override
	public void init() throws ServletException {
		//bezoekers teller
		this.getServletContext().setAttribute(PIZZABESTELLEN_REQUESTS, new AtomicInteger());
	}
}
