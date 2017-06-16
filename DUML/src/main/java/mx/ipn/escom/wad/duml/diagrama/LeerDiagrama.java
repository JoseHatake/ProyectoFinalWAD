package mx.ipn.escom.wad.duml.diagrama;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.escom.wad.duml.accesoDB.dao.UsuarioDao;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;

/**
 * Servlet implementation class LeerDigrama
 */
@WebServlet("/LeerDigrama")
public class LeerDiagrama extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeerDiagrama() {
        super();
        // TODO Auto-generated constructor stub
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
		PrintWriter out = response.getWriter();
		
		String login = request.getParameter("usuario");
		String nombre = request.getParameter("nombre");
		UsuarioDao usuarioDao = new UsuarioDao();
		
		Usuario usuario = usuarioDao.findByLogin(login);
		
		
		//consultar nombre del archivo
		String ruta="/home/ady/Escritorio/datos.txt";
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(ruta));
		try {
			String datos=(String) in.readObject();
			out.println(""+datos+"");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
		
		
	
		
		doGet(request, response);
	}

}