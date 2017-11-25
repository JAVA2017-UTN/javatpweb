package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.CtrlBookableItems;
import entity.BookableItems;
import entity.People;
import util.AppDataException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

/**
 * Servlet implementation class EliminarBookableItems
 */
@WebServlet("/EliminarBookableItems")
public class EliminarBookableItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarBookableItems() {
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
				int id = Integer.parseInt(request.getParameter("id"));
				String nombre = request.getParameter("nombre");
				int id_tipoElemento = Integer.parseInt(request.getParameter("tipoElemento"));
				
				CtrlBookableItems ctrl = new CtrlBookableItems();
				
				BookableItems bi = new BookableItems();
				
				bi.setId(id);
				bi.setNombre(nombre);
				bi.setId_tipoElemento(id_tipoElemento);
				
				try {
					ctrl.update(bi);
					request.getRequestDispatcher("/bookableItems.jsp").forward(request, response);
				} catch (AppDataException ade) {
					request.setAttribute("Error", ade.getMessage());
				} catch (Exception e) {
					response.setStatus(502);
				}
			}
			if(request.getParameter("eliminar") != null){
				
				int id = Integer.parseInt(request.getParameter("id"));	
				CtrlBookableItems ctrl = new CtrlBookableItems();
				BookableItems bi = new BookableItems();
				bi.setId(id);
				try {
					ctrl.delete(bi);
					
					request.getRequestDispatcher("/bookableItems.jsp").forward(request, response);
				} catch (AppDataException ade) {
					request.setAttribute("Error", ade.getMessage());
				} catch (SQLException se){
					se.printStackTrace();
					request.setAttribute("Errorsql", "Imposible eliminar. Este elemento esta asociado a una reserva pendiente");
					logger.log(Level.ERROR, "Se intento eliminar un elemento asociado a una reserva activa - Elemento: "+bi.getNombre());
					request.getRequestDispatcher("WEB-INF/sqlError.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					response.setStatus(502);
				}
				logger.log(Level.WARN,((People)request.getSession().getAttribute("user")).getNombre() +" ha eliminado al elemento: "+bi.getNombre() +" de id: " +bi.getId());
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
