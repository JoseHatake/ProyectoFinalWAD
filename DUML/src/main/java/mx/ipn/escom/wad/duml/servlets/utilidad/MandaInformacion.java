package mx.ipn.escom.wad.duml.servlets.utilidad;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.duml.accesoDB.bs.EmpresaBs;
import mx.ipn.escom.wad.duml.accesoDB.mapeo.Empresa;

/**
 * Servlet implementation class MandaInformacion
 */
@WebServlet("/MandaInformacion")
public class MandaInformacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EmpresaBs empresaBS;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MandaInformacion() {
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
		RequestDispatcher dispatcher;
		String direccion = request.getParameter("direccion");
		Integer opt = Integer.valueOf(request.getParameter("opt"));
		
		switch(opt){
			case 1:
				request.setAttribute("empresas", this.getEmpresas());
				break;
			default:
				/*
				 * No hace nada
				 * */
				break;
		}
		dispatcher = request.getRequestDispatcher(direccion);
		dispatcher.forward(request, response);
	}

	private List<Empresa> getEmpresas(){
		return empresaBS.getEmpresas();
	}
}
