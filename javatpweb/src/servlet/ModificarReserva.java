package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.CtrlBooking;
import entity.People;
import util.AppDataException;
import util.Emailer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

/**
 * Servlet implementation class EliminarReserva
 */
@WebServlet("/ModificarReserva")
public class ModificarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarReserva() {
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
			if (request.getParameter("eliminar") != null) {
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					String fecha = request.getParameter("fecha");
					String hora = request.getParameter("hora");
					String detalle = request.getParameter("detalle");
					String tipo_ele = request.getParameter("tipo_ele");
					String ele = request.getParameter("ele");

					CtrlBooking ctrl = new CtrlBooking();

					try {
						ctrl.deleteById(id);
					} catch (AppDataException ade) {
						request.setAttribute("Error", ade.getMessage());
					} catch (Exception e) {
						response.setStatus(502);
					}
					finally {
						request.getRequestDispatcher("reservas.jsp").forward(request, response);						
					}
					Emailer.getInstance().send("tpjava2017@gmail.com","Baja de reserva","La reserva: \n\n" +"ID: "+id +"\nFecha: " +fecha +"\nHora: " +hora 
					+"\nDetalle: " +detalle +"\nTipo Elemento: " +tipo_ele +"\nElemento: " +ele
					+"\n\n fue dada de baja.");
					logger.log(Level.INFO,((People)request.getSession().getAttribute("user")).getNombre() +" ha eliminado su reserva: "+id);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (request.getParameter("anular") != null) {
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					String fecha = request.getParameter("fecha");
					String hora = request.getParameter("hora");
					String detalle = request.getParameter("detalle");
					String tipo_ele = request.getParameter("tipo_ele");
					String ele = request.getParameter("ele");

					CtrlBooking ctrl = new CtrlBooking();

					try {
						ctrl.anularById(id);
					} catch (AppDataException ade) {
						request.setAttribute("Error", ade.getMessage());
					} catch (Exception e) {
						e.printStackTrace();
						response.setStatus(502);
					}
					finally {
						request.getRequestDispatcher("reservas.jsp").forward(request, response);						
					}
					Emailer.getInstance().send("tpjava2017@gmail.com","Anulación de reserva","La reserva: \n\n" +"ID: "+id +"\nFecha: " +fecha +"\nHora: " +hora 
							+"\nDetalle: " +detalle +"\nTipo Elemento: " +tipo_ele +"\nElemento: " +ele
					+"\n\n fue anulada.");
					logger.log(Level.WARN,((People)request.getSession().getAttribute("user")).getNombre() +" ha anulado la reserva: "+id);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
