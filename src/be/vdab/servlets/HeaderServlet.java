package be.vdab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/headers.htm", name = "HeaderServlet")
public class HeaderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/headers.jsp";
	private static final String HEADERS_REQUESTS = "headersRequests";
	private final Map<String, String> browsers = new HashMap<>();

	public HeaderServlet() {
		browsers.put("firefox", "Firefox");
		browsers.put("chrome", "Chrome");
		browsers.put("msie", "Internet Explorer");
		browsers.put("trident", "Internet Explorer");
		browsers.put("opera", "Opera");
		browsers.put("apple", "Safari");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userAgent = request.getHeader("user-agent").toLowerCase();
		browsers.entrySet().stream().filter(entry -> userAgent.contains(entry.getKey())).findFirst().ifPresent(browser -> request.setAttribute("browser", browser.getValue()));

		Map<String, String> headers = new LinkedHashMap<>();
		for (Enumeration<String> headerNames = request.getHeaderNames(); headerNames.hasMoreElements(); ) {
			String headerName = headerNames.nextElement();
			headers.put(headerName, request.getHeader(headerName));
		}
		request.setAttribute("headers", headers);

		request.getRequestDispatcher(VIEW).forward(request, response);

	}

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(HEADERS_REQUESTS, new AtomicInteger());
	}
}