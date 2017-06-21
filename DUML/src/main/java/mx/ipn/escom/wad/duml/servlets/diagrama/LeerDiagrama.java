package mx.ipn.escom.wad.duml.servlets.diagrama;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
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

import mx.ipn.escom.wad.duml.accesoDB.bs.DiagramaBs;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Diagrama;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;

/**
 * Servlet implementation class LeerDigrama
 */
@WebServlet("/LeerDigrama")
public class LeerDiagrama extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	private DiagramaBs diagramaBs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeerDiagrama() {
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
		PrintWriter out = response.getWriter();
		
		HttpSession misession= (HttpSession) request.getSession();
		Usuario user  = (Usuario) misession.getAttribute("Usuario");
		Integer idDiagrama=Integer.parseInt(request.getParameter("idDiagrama"));
		Diagrama diagrama=diagramaBs.findById(idDiagrama);
		
		//String ruta="../DUML/src/main/webapp/KitchenSink/archivos/"+user.getLogin()+"/"+user.getNombre()+"/nombre.txt";
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(diagrama.getPath()));
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