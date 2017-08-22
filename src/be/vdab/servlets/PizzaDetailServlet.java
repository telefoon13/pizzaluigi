package be.vdab.servlets;


import be.vdab.entities.pizza;
import be.vdab.repositories.PizzaRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/pizzas/detail.htm", name = "PizzaDetailServlet")
public class PizzaDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/pizzadetail.jsp";
	private static final String PIZZADETAIL_REQUESTS = "pizzaDetailRequests";
	private final PizzaRepository pizzaRepository = new PizzaRepository();
	private String pizzaFotoPad;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			pizzaRepository.read(Long.parseLong(request.getParameter("id"))).ifPresent(pizza -> request.setAttribute("pizza", pizza));

			List<pizza> pizzas = pizzaRepository.findAll();
			request.setAttribute("pizzas", pizzas);
			request.setAttribute("pizzaIdsMetFoto",
					pizzas.stream().filter(pizza -> Files.exists(Paths.get(pizzaFotoPad, pizza.getId() + ".jpg")))
							.map(pizza -> pizza.getId()).collect(Collectors.toList()));


		} catch (NullPointerException | NumberFormatException ex) {
			request.setAttribute("fout", "id niet correct");
		}

		((AtomicInteger) this.getServletContext().getAttribute(PIZZADETAIL_REQUESTS)).incrementAndGet();

		request.getRequestDispatcher(VIEW).forward(request, response);

	}

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(PIZZADETAIL_REQUESTS, new AtomicInteger());
		pizzaFotoPad = this.getServletContext().getRealPath("/pizzafotos");
	}
}
