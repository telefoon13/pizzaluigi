package be.vdab.servlets;

import be.vdab.entities.Adres;
import be.vdab.entities.begroeting;
import be.vdab.entities.persoon;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/index.htm", name = "IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private final AtomicInteger aantalKeerBekeken = new AtomicInteger();

	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

		request.setAttribute("begroeting", new begroeting());

		request.setAttribute("zaakvoerder",
				new persoon("Mike", "Dhoore", 1, true,
						new Adres("Gavermolenstraat", "71", "9111", "Belsele")));

		request.setAttribute("aantalKeerBekeken", aantalKeerBekeken.incrementAndGet());

		request.setAttribute("emailAdresWebmaster", this.getInitParameter("emailAdresWebmaster"));

		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}