package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.CtrlBooking;
import entity.Booking;
import util.AppDataException;
import util.Emailer;

/**
 * Servlet implementation class EliminarReserva
 */
@WebServlet("/ModificarReserva")
public class ModificarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarReserva() {
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
		
		try {
			if (request.getParameter("eliminar") != null) {
				try {
					int id = Integer.parseInt(request.getParameter("id"));

					CtrlBooking ctrl = new CtrlBooking();

					try {
						ctrl.deleteById(id);
					} catch (AppDataException ade) {
						request.setAttribute("Error", ade.getMessage());
					} catch (Exception e) {
						response.setStatus(502);
					}
					//Emailer.getInstance().send("mauriminio96@gmail.com","Baja de reserva","Su reserva de id: " +id +" fue satisfactoriamente eliminada.");
					request.getRequestDispatcher("reservas.jsp").forward(request, response);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (request.getParameter("anular") != null) {
				try {
					int id = Integer.parseInt(request.getParameter("id"));

					CtrlBooking ctrl = new CtrlBooking();

					try {
						ctrl.anularById(id);
					} catch (AppDataException ade) {
						request.setAttribute("Error", ade.getMessage());
					} catch (Exception e) {
						e.printStackTrace();
						response.setStatus(502);
					}
					//Emailer.getInstance().send("mauriminio96@gmail.com","Anulación de reserva","La reserva: " +id +" fue satisfactoriamente anulada.");
					request.getRequestDispatcher("reservas.jsp").forward(request, response);
					
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
