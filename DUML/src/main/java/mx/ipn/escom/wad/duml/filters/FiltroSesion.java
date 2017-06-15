package mx.ipn.escom.wad.duml.filters;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Verifica si la petición contiene la sesión adecuada, redirige a login si no
 * es encontrada.
 * 
 * @author Brenda Fuentes
 *
 */
public class FiltroSesion implements Filter {

	private ArrayList<String> exceptions;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String contextPath = "/DUML";
		String originalPath = "/";

		// Revisamos que exista en la sesión el atributo "Usuario"
		if (request instanceof HttpServletRequest) {
			HttpServletRequest servletRequest = (HttpServletRequest) request;

			Boolean loggedIn = false;
			try {
				loggedIn = (Boolean) servletRequest.getSession().getAttribute("LoggedIn");
				loggedIn = loggedIn == null ? false : loggedIn;
			} catch (Exception ex) {
				servletRequest.getSession().removeAttribute("LoggedIn");
			}

			String path = servletRequest.getServletPath();
			contextPath = servletRequest.getContextPath();
			originalPath = URLEncoder.encode(servletRequest.getRequestURL().toString(), "UTF-8");

			if (loggedIn || exceptions.contains(path)) {
				// Continuamos si ambos son válidos
				chain.doFilter(request, response);
				return;

			}

			HttpServletResponse httpResponse = (HttpServletResponse) response;

			// Redirigimos en caso contrario
			httpResponse.sendRedirect(contextPath + "/Login.jsp?r=" + originalPath);

		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String paths = config.getInitParameter("excluir");
		exceptions = new ArrayList<>();
		exceptions.add("/Login.jsp");
		exceptions.add("/Login.do");
		Collections.addAll(exceptions, paths.split(","));
	}

}