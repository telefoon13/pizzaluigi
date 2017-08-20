package be.vdab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/statistiek.htm", name = "StatistiekServlet")
public class StatistiekServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/statistiek.jsp";
	private static final String STATISTIEK_REQUESTS = "statistiekRequests";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		((AtomicInteger) this.getServletContext().getAttribute(STATISTIEK_REQUESTS)).incrementAndGet();

		request.getRequestDispatcher(VIEW).forward(request, response);

	}

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(STATISTIEK_REQUESTS, new AtomicInteger());
	}
}
