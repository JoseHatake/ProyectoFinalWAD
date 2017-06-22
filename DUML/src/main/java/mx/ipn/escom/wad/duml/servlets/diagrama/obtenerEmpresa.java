package mx.ipn.escom.wad.duml.servlets.diagrama;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.duml.accesoDB.bs.EmpresaBs;
import mx.ipn.escom.wad.duml.accesoDB.bs.EmpresaUsuarioBs;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Empresa;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.EmpresaUsuario;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;

/**
 * Servlet implementation class obtenerEmpresa
 */
@WebServlet("/obtenerEmpresa")
public class obtenerEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EmpresaBs empresaBs;
	
	@Autowired
	private EmpresaUsuarioBs empresaUsuarioBs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public obtenerEmpresa() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession misession= (HttpSession) request.getSession();
		Usuario user  = (Usuario) misession.getAttribute("Usuario");

		List<EmpresaUsuario> listaEmpresausuario = empresaUsuarioBs.findByIdUsuario(user.getId());
		List<Empresa> empresa = new ArrayList<>();
		
		for (EmpresaUsuario listaEmpresa : listaEmpresausuario) {
			empresa.add(empresaBs.findById(listaEmpresa.getIdEmpresa()));
		}
		
		PrintWriter out = response.getWriter();
		
		for(int i=0;i<empresa.size();i++){
			out.println("<option value='"+empresa.get(i).getId()+"'>"+empresa.get(i).getNombre()+"</option>");
		}
		
		doGet(request, response);
	}

}
