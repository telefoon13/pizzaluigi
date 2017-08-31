package be.vdab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

@WebServlet(urlPatterns = "/taalkiezen.htm", name = "TaalKiezenServlet", loadOnStartup = 1)
public class TaalKiezenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String language = request.getParameter("language");
		String country = request.getParameter("country");
		String redirectURL = request.getParameter("redirectURL");
		Config.set(request.getSession(), Config.FMT_LOCALE, new java.util.Locale(language, country));
		response.sendRedirect(redirectURL);
	}
}
