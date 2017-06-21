package mx.ipn.escom.wad.duml.servlets.log;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.duml.accesoDB.bs.UsuarioBs;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioBs usuarioBs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("usuario");
		String pass = request.getParameter("clave");
		String redireccion = "";
		HttpSession sesion = request.getSession();
		
		Usuario usuario = usuarioBs.findByLogin(login, pass);
		if (usuario != null) {
			sesion.setAttribute("Usuario", usuario);
			redireccion = request.getContextPath() + "/KitchenSink/index.html";
		}
		else{
			redireccion = "index.jsp";
		}
		
		response.sendRedirect(redireccion);
	}

}
