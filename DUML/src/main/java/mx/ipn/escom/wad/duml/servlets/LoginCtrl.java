package mx.ipn.escom.wad.duml.servlets;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.duml.accesoDB.dao.UsuarioDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;

/**
 * 
 * Servlet implementation class LoginCtrl
 */
public class LoginCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCtrl() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		String redirigirA = request.getParameter("redirigir_a");
		String contextPath = request.getContextPath();

		login = login == null ? "" : login;
		clave = clave == null ? "" : clave;
		redirigirA = redirigirA == null ? contextPath + "/" : redirigirA;

		if (login.isEmpty() || clave.isEmpty()) {
			response.sendRedirect(contextPath + "/Login.jsp?e=Usuario+o+contrase%C3%B1a+inv%C3%A1lidos&r="
					+ URLEncoder.encode(redirigirA, "UTF-8"));
			return;
		}

		UsuarioDao usuarioDao = new UsuarioDao();
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(usuarioDao,
				getServletConfig().getServletContext());

		Usuario usuario = usuarioDao.findByLogin(login);
		if (!usuario.getPassword().equals(clave)) {
			response.sendRedirect(contextPath + "/Login.jsp?e=Usuario+o+contrase%C3%B1a+inv%C3%A1lidos&r="
					+ URLEncoder.encode(redirigirA, "UTF-8"));
			return;
		}

		request.getSession().setAttribute("LoggedIn", true);
		request.getSession().setAttribute("Usuario", usuario);
		request.getSession().setAttribute("Usuario.id", usuario.getId());
		request.getSession().setAttribute("Usuario.login", usuario.getLogin());
		request.getSession().setAttribute("Usuario.nombre", usuario.getNombre());
		request.getSession().setAttribute("Usuario.primer_ap", usuario.getPrimerApellido());
		request.getSession().setAttribute("Usuario.segundo_ap", usuario.getSegundoApellido());
		response.sendRedirect(redirigirA);
	}
}
