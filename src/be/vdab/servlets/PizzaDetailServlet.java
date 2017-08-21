package be.vdab.servlets;

import be.vdab.repositories.PizzaRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/pizzas/detail.htm", name = "PizzaDetailServlet")
public class PizzaDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/pizzadetail.jsp";
	private static final String PIZZADETAIL_REQUESTS = "pizzaDetailRequests";
	private final PizzaRepository pizzaRepository = new PizzaRepository();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			pizzaRepository.read(Long.parseLong(request.getParameter("id"))).ifPresent(pizza -> request.setAttribute("pizza", pizza));
		} catch (NullPointerException | NumberFormatException ex) {
			request.setAttribute("fout", "id niet correct");
		}

		((AtomicInteger) this.getServletContext().getAttribute(PIZZADETAIL_REQUESTS)).incrementAndGet();

		request.getRequestDispatcher(VIEW).forward(request, response);

	}

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(PIZZADETAIL_REQUESTS, new AtomicInteger());
	}
}
