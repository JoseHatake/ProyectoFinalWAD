package mx.ipn.escom.wad.duml.servlets.diagrama;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import mx.ipn.escom.wad.duml.accesoDB.bs.DiagramaBs;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Diagrama;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;
/**
 * Servlet implementation class GuardarDiagrama
 */
@WebServlet("/GuardarDiagrama")
public class GuardarDiagrama extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private DiagramaBs diagramaBS;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarDiagrama() {
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession misession= (HttpSession) request.getSession();
		Usuario user  = (Usuario) misession.getAttribute("Usuario");
		
		String nombre = request.getParameter("nombre");
		String datos = request.getParameter("datos");
		Integer idEmpresa = 1;
		
		String ruta=user.getLogin()+"/"+user.getNombre()+"/"+nombre+".txt";
		String rutaC="../DUML/src/main/webapp/KitchenSink/archivos/"+ruta;
		
		if (!diagramaBS.existeDiagrama(idEmpresa, user.getId(), nombre)) {
			Diagrama diagrama = new Diagrama();
			diagrama.setIdEmpresa(idEmpresa);
			diagrama.setIdUsuario(user.getId());
			diagrama.setNombre(nombre);
			diagrama.setPath(rutaC);
			diagramaBS.save(diagrama);	
		}
		
		writeToFile(rutaC, datos);
		
		doGet(request, response);
	}
	
	private void writeToFile(String filename, String archivo) throws FileNotFoundException, IOException {
		File f = new File(filename);
		f.getParentFile().mkdirs();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
	    out.writeObject(archivo);
		out.close();
	}
}