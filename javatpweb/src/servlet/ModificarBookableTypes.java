package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.CtrlBookingTypes;
import entity.BookableTypes;
import entity.People;
import util.AppDataException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
/**
 * Servlet implementation class ModificarBookableTypes
 */
@WebServlet("/ModificarBookableTypes")
public class ModificarBookableTypes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarBookableTypes() {
        super();
        logger = LogManager.getLogger(getClass());
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
		
		try {
			if(request.getParameter("modificar") != null){
				
				String id = request.getParameter("id");
				String nombre = request.getParameter("nombre");
				String cantReservasPendientes = request.getParameter("cantReservasPendientes");
				String estadoForm = request.getParameter("req_encargado");
				boolean req_encargado = true;
				if (estadoForm.equals("1")) {
					req_encargado = true;
				}
				else {
					req_encargado = false;
				}
				String limite = request.getParameter("limite");
				String dias = request.getParameter("dias");
				CtrlBookingTypes ctrl = new CtrlBookingTypes();
				BookableTypes bt = new BookableTypes();
				bt.setNombre(nombre);
				bt.setCantReservasPendientes(Integer.parseInt(cantReservasPendientes));
				bt.setDias(Integer.parseInt(dias));
				bt.setLimite(Integer.parseInt(limite));
				bt.setReq_encargado(req_encargado);
				bt.setId(Integer.parseInt((id)));
				try {
					ctrl.update(bt);
					request.getRequestDispatcher("/bookableTypes.jsp").forward(request, response);
				} catch (AppDataException ade) {
					request.setAttribute("Error", ade.getMessage());
				} catch (Exception e) {
					response.setStatus(502);
				}
			}
			if(request.getParameter("eliminar") != null){
				
				String id = request.getParameter("id");
				String nombre = request.getParameter("nombre");
				String cantReservasPendientes = request.getParameter("cantReservasPendientes");
				String estadoForm = request.getParameter("req_encargado");
				boolean req_encargado = true;
				if (estadoForm.equals("1")) {
					req_encargado = true;
				}
				else {
					req_encargado = false;
				}
				String limite = request.getParameter("limite");
				String dias = request.getParameter("dias");
				CtrlBookingTypes ctrl = new CtrlBookingTypes();
				BookableTypes bt = new BookableTypes();
				bt.setNombre(nombre);
				bt.setCantReservasPendientes(Integer.parseInt(cantReservasPendientes));
				bt.setDias(Integer.parseInt(dias));
				bt.setLimite(Integer.parseInt(limite));
				bt.setReq_encargado(req_encargado);
				bt.setId(Integer.parseInt((id)));
				try {
					ctrl.delete(bt);
					request.getRequestDispatcher("/bookableTypes.jsp").forward(request, response);
				} catch (AppDataException ade) {
					request.setAttribute("Error", ade.getMessage());
				} catch (SQLException se){
					request.setAttribute("Errorsql", "Imposible eliminar. Este tipo de elemento esta asociado a un elemento existente");
					logger.log(Level.ERROR, "Se intento eliminar un tipo de elemento con elementos asociados - Tipo de Elemento: "+bt.getNombre());
					request.getRequestDispatcher("WEB-INF/sqlError.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					response.setStatus(502);
				}
				logger.log(Level.WARN,((People)request.getSession().getAttribute("user")).getNombre() +" ha eliminado al tipo de elemento: "+bt.getNombre() +" de id: " +bt.getId());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
