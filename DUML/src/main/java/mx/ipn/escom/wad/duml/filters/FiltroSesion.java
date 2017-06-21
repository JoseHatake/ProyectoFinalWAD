package mx.ipn.escom.wad.duml.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;

/**
 * Verifica si la petición contiene la sesión adecuada, redirige a login si no
 * es encontrada.
 * 
 * @author Brenda Fuentes
 *
 */
public class FiltroSesion implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Usuario usuario = null;
		HttpServletRequest requestUpper = (HttpServletRequest) request;
		HttpServletResponse responseUpper = (HttpServletResponse) response;
		HttpSession sesion = requestUpper.getSession();
		
		usuario = (Usuario) sesion.getAttribute("Usuario");
		if (usuario == null){
			responseUpper.sendRedirect(requestUpper.getContextPath() + "/index.jsp");
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Fintro de session iniciado...");
	}

}