package mx.ipn.escom.wad.duml.diagrama;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.duml.accesoDB.dao.DiagramaDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Diagrama;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Empresa;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;
/**
 * Servlet implementation class GuardarDiagrama
 */
@WebServlet("/GuardarDiagrama")
public class GuardarDiagrama extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarDiagrama() {
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

		String json=request.getParameter("datos");
		
		String nombre=request.getParameter("nombre");
		
		String ruta=user.getLogin()+"/"+user.getNombre()+"/"+nombre+".txt";
		String rutaC="../DUML/src/main/webapp/KitchenSink/archivos/"+ruta;		
		DiagramaDao diagramaDao = new DiagramaDao();
		
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(diagramaDao,
				getServletConfig().getServletContext());
		
		Diagrama diagrama = new Diagrama();
		
		diagrama.setIdEmpresa(1);
		diagrama.setIdUsuario(user.getId());
		diagrama.setNombre(nombre);
		diagrama.setPath(rutaC);
		diagramaDao.save(diagrama);		
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