package mx.ipn.escom.wad.duml.servlets.sesion;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.duml.accesoDB.bs.EmpresaBs;
import mx.ipn.escom.wad.duml.accesoDB.bs.EmpresaUsuarioBs;
import mx.ipn.escom.wad.duml.accesoDB.bs.UsuarioBs;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Empresa;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.EmpresaUsuario;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioBs usuarioBs;
	
	@Autowired
	private EmpresaBs empresaBs;
	
	@Autowired
	private EmpresaUsuarioBs empresaUsuarioBs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
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
		Usuario usuario = new Usuario();
		EmpresaUsuario empresaUsuario;
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		String login,pass;
		String[] empresasSelect;
		
		login = request.getParameter("login");
		pass = request.getParameter("password");
		empresasSelect = request.getParameterValues("empresa");
		
		usuario.setLogin(login);
		usuario.setPassword(pass);
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setPrimerApellido(request.getParameter("primer_ap"));
		usuario.setSegundoApellido(request.getParameter("segundo_ap"));
		usuarioBs.save(usuario);
		
		usuario = usuarioBs.findByLogin(login, pass);
		empresas = this.getEmpresas(empresasSelect);
		
		for(Empresa empresa : empresas){
			empresaUsuario = new EmpresaUsuario(empresa.getId(),usuario.getId());
			empresaUsuario.setEmpresaObj(empresa);
			empresaUsuario.setIdEmpresa(empresa.getId());
			empresaUsuario.setIdUsuario(usuario.getId());
			empresaUsuario.setUsuarioObj(usuario);
			empresaUsuarioBs.save(empresaUsuario);
		}
		response.sendRedirect("Login.jsp");
	}

	public ArrayList<Empresa> getEmpresas(String[] empresasSelect){
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		for(Integer x = 0; x < empresasSelect.length; x++){
			empresas.add(empresaBs.findById(Integer.parseInt(empresasSelect[x])));
		}
		return empresas;
	}
}
