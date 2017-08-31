package be.vdab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/identificatie.htm", name = "IdentificatieServlet")
public class IdentificatieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/identificatie.jsp";
	private static final String IDENTIFICATIE_REQUESTS = "identificatieRequests";
	private static final int COOCKIE_MAX_LEEFTIJD = 60 * 30;/*60sec * 30 min = 30min*/

	//POST methode
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Met coockie
		Cookie cookie = new Cookie("gebruikersnaam", URLEncoder.encode(request.getParameter("gebruikersnaam"), "UTF-8"));
		cookie.setMaxAge(COOCKIE_MAX_LEEFTIJD);
		response.addCookie(cookie);

		//Met session
		HttpSession session = request.getSession();
		session.setAttribute("gebruikersnaam2", request.getParameter("gebruikersnaam2"));

		//Redirect
		response.sendRedirect(request.getRequestURI());
	}

	//GET methode
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Met coockie
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if ("gebruikersnaam".equals(cookie.getName())) {
					request.setAttribute("gebruikersnaam", URLDecoder.decode(cookie.getValue(), "UTF-8"));
					break;
				}
			}
		}

		//Met Session
		HttpSession session = request.getSession(false);
		if (session != null) {
			String gebruikersnaam2 = (String) session.getAttribute("gebruikersnaam2");
			if (gebruikersnaam2 != null) {
				request.setAttribute("gebruikersnaam2", gebruikersnaam2);
			}
		}

		//Bezoekers teller
		((AtomicInteger) this.getServletContext().getAttribute(IDENTIFICATIE_REQUESTS)).incrementAndGet();


		//Request view
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	//bij init pagina
	@Override
	public void init() throws ServletException {
		//bezoekers teller
		this.getServletContext().setAttribute(IDENTIFICATIE_REQUESTS, new AtomicInteger());
	}
}
