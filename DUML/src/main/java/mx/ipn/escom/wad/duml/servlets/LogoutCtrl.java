package mx.ipn.escom.wad.duml.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutCtrl
 */
public class LogoutCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("LoggedIn", false);
		request.getSession().removeAttribute("Usuario");
		request.getSession().removeAttribute("Usuario.id");
		request.getSession().removeAttribute("Usuario.login");
		request.getSession().removeAttribute("Usuario.nombre");
		request.getSession().removeAttribute("Usuario.primer_ap");
		request.getSession().removeAttribute("Usuario.segundo_ap");
		response.sendRedirect(request.getContextPath() + "/Login.jsp");
	}

}
