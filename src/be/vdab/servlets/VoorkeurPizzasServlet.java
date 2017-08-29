package be.vdab.servlets;

import be.vdab.repositories.PizzaRepository;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/pizzas/voorkeuren.htm", name = "VoorkeurPizzasServlet")
public class VoorkeurPizzasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/voorkeurpizzas.jsp";
	private static final String VOORKEURPIZZAS_REQUESTS = "voorkeurPizzasRequests";
	private final transient PizzaRepository pizzaRepository = new PizzaRepository();

	@Resource(name = PizzaRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		pizzaRepository.setDataSource(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("pizzas", pizzaRepository.findAll());

		if (request.getParameterValues("id") != null) {
			request.setAttribute("voorkeurPizzas",
					Arrays.stream(request.getParameterValues("id")).map(id -> pizzaRepository
							.read(Long.parseLong(id))).filter(optionalPizza -> optionalPizza.isPresent())
							.map(optionalPizza -> optionalPizza.get()).collect(Collectors.toList()));
		}

		((AtomicInteger) this.getServletContext().getAttribute(VOORKEURPIZZAS_REQUESTS)).incrementAndGet();

		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(VOORKEURPIZZAS_REQUESTS, new AtomicInteger());
	}

}