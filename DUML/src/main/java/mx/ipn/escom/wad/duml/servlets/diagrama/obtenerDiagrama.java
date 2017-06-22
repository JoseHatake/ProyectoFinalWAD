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

	import mx.ipn.escom.wad.duml.accesoDB.bs.DiagramaBs;
	import mx.ipn.escom.wad.duml.accesoDB.mapeo.Diagrama;
	import mx.ipn.escom.wad.duml.accesoDB.mapeo.Usuario;

	/**
	 * Servlet implementation class obtenerDiagrama
	 */
	@WebServlet("/obtenerDiagrama")
	public class obtenerDiagrama extends HttpServlet {
		private static final long serialVersionUID = 1L;
		  
		@Autowired
		private DiagramaBs diagramaBs;
		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public obtenerDiagrama() {
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

		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession misession= (HttpSession) request.getSession();
			Usuario user  = (Usuario) misession.getAttribute("Usuario");
			
			Integer idEmpresa=Integer.parseInt(request.getParameter("id_empresa"));
			System.out.println(user.getId()+" "+idEmpresa);
			List<Diagrama> diagrama=diagramaBs.findByIDS(user.getId(), idEmpresa);
			
			PrintWriter out = response.getWriter();
			
			for(int i=0;i<diagrama.size();i++){
				out.println("<option value='"+diagrama.get(i).getId()+"'>"+diagrama.get(i).getNombre()+"</option>");
			}
			
			doGet(request, response);
		}

	}
