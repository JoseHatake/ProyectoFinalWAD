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

import mx.ipn.escom.wad.duml.accesoDB.dao.UsuarioDao;
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
		String login = request.getParameter("usuario");
		String nombre = request.getParameter("nombre");
		UsuarioDao usuarioDao = new UsuarioDao();
		
		Usuario usuario = usuarioDao.findByLogin(login);
		String json=request.getParameter("datos");
		System.out.println(login);
		String ruta="/home/ady/Escritorio/Info/"+login+usuario.getNombre()+nombre+".txt";
		writeToFile("/home/ady/Escritorio/dato.txt",json);
		//guardar ruta del diagrama
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