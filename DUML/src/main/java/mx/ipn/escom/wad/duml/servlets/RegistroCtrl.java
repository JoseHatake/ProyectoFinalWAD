package mx.ipn.escom.wad.duml.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.duml.accesoDB.dao.UsuarioDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;

public class RegistroCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String primerAp = request.getParameter("primer_ap");
		String segundoAp = request.getParameter("segundo_ap");

		if (login == null || login.isEmpty()) {
			sendError("El login no puede ser vacío", request, response);
			return;
		}
		
		if (password == null || password.isEmpty()) {
			sendError("El password no puede ser vacío", request, response);
			return;
		}
		
		if (nombre == null || nombre.isEmpty()) {
			sendError("El nombre no puede ser vacío", request, response);
			return;
		}
		
		if (primerAp == null || primerAp.isEmpty()) {
			sendError("El primer apellido no puede ser vacío", request, response);
			return;
		}
		
		if (segundoAp == null || segundoAp.isEmpty()) {
			sendError("El segundo apellido no puede ser vacío", request, response);
			return;
		}
		
		UsuarioDao usuarioDao = new UsuarioDao();
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(usuarioDao,
				getServletConfig().getServletContext());

		
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setPassword(password);
		usuario.setNombre(nombre);
		usuario.setPrimerApellido(primerAp);
		usuario.setSegundoApellido(segundoAp);
		
		usuarioDao.save(usuario);
		response.sendRedirect(request.getContextPath() + "/Login.jsp?m=" + URLEncoder.encode("Inicie sesión para continuar", "UTF-8"));
	}

	private void sendError(String error, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		response.sendRedirect(request.getContextPath() + "/Registro.jsp?e=" + URLEncoder.encode(error, "UTF-8"));
	}
}
