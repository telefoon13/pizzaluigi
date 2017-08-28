package be.vdab.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener()
public class MandjeListener implements ServletContextListener,
		HttpSessionListener, HttpSessionAttributeListener {

	private static final String MANDJE = "mandje";
	private static final String AANTAL_MANDJES = "aantalMandjes";

	// Public constructor is required by servlet spec
	public MandjeListener() {
	}

	// -------------------------------------------------------
	// ServletContextListener implementation
	// -------------------------------------------------------
	public void contextInitialized(ServletContextEvent sce) {
	  /* This method is called when the servlet context is
		 initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */
		sce.getServletContext().setAttribute(AANTAL_MANDJES, new AtomicInteger());
	}

	public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
	}

	// -------------------------------------------------------
	// HttpSessionListener implementation
	// -------------------------------------------------------
	public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
	}

	public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
	}

	// -------------------------------------------------------
	// HttpSessionAttributeListener implementation
	// -------------------------------------------------------

	public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
		if (MANDJE.equals(sbe.getName())) {
			((AtomicInteger) sbe.getSession().getServletContext().getAttribute(AANTAL_MANDJES)).incrementAndGet();
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
		if (MANDJE.equals(sbe.getName())) {
			((AtomicInteger) sbe.getSession().getServletContext().getAttribute(AANTAL_MANDJES)).decrementAndGet();
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
	}
}
