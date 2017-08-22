package be.vdab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Cookie cookie = new Cookie("gebruikersnaam", URLEncoder.encode(request.getParameter("gebruikersnaam"), "UTF-8"));
		cookie.setMaxAge(COOCKIE_MAX_LEEFTIJD);
		response.addCookie(cookie);
		response.sendRedirect(request.getRequestURI());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if ("gebruikersnaam".equals(cookie.getName())) {
					request.setAttribute("gebruikersnaam", URLDecoder.decode(cookie.getValue(), "UTF-8"));
					break;
				}
			}
		}

		((AtomicInteger) this.getServletContext().getAttribute(IDENTIFICATIE_REQUESTS)).incrementAndGet();

		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(IDENTIFICATIE_REQUESTS, new AtomicInteger());
	}
}
