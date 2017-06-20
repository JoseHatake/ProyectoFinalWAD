package mx.ipn.escom.wad.duml.diagrama;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.duml.accesoDB.dao.EmpresaDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Empresa;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;

/**
 * Servlet implementation class obtenerEmpresa
 */
@WebServlet("/obtenerEmpresa")
public class obtenerEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public obtenerEmpresa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession misession= (HttpSession) request.getSession();
		Usuario user  = (Usuario) misession.getAttribute("Usuario");
		
		EmpresaDao empresaDao = new EmpresaDao();
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(empresaDao,
				getServletConfig().getServletContext());
		
		List<Empresa> empresa=empresaDao.findbyUsuario(user.getId());
		PrintWriter out = response.getWriter();
		
		for(int i=0;i<empresa.size();i++){
			out.println("<option value='"+empresa.get(i).getId()+"'>"+empresa.get(i).getNombre()+"</option>");
		}
		
		
		
		doGet(request, response);
	}

}
