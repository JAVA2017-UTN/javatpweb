package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.CtrlBooking;
import entity.Booking;
import util.AppDataException;

/**
 * Servlet implementation class AltaReserva
 */
@WebServlet("/AltaReserva")
public class AltaReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaReserva() {
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
			String detalle = request.getParameter("detalle");
			Date fecha = Date.valueOf(request.getParameter("fecha"));
			Time hora = Time.valueOf(request.getParameter("hora")+":00");
			int id_tipoEle = Integer.parseInt(request.getParameter("tipo_elemento"));
			/*int id_ele = Integer.parseInt(request.getParameter("elemento"));*/
			int id_ele = 1;
			int id_persona = Integer.parseInt(request.getParameter("id_persona"));
			CtrlBooking ctrl = new CtrlBooking();
			Booking bok = new Booking();
			bok.setDetalle(detalle);
			bok.setFecha(fecha);
			bok.setHora(hora);
			bok.setId_elemento(id_ele);
			bok.setId_tipoElemento(id_tipoEle);
			bok.setId_persona(id_persona);
			try {
				ctrl.add(bok);
			} catch (AppDataException ade) {
				request.setAttribute("Error", ade.getMessage());
			} catch (Exception e) {
				response.setStatus(502);
			}
			
			request.getRequestDispatcher("reservas.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
