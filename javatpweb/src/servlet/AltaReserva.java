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
import controllers.CtrlBookingTypes;
import controllers.CtrlBookableItems;
import entity.BookableItems;
import entity.BookableTypes;
import entity.Booking;
import entity.People;
import util.AppDataException;
import util.DuplicatedException;
import util.Emailer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

/**
 * Servlet implementation class AltaReserva
 */
@WebServlet("/AltaReserva")
public class AltaReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaReserva() {
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
			String detalle = request.getParameter("detalle");
			Date fecha = Date.valueOf(request.getParameter("fecha"));
			Time hora = Time.valueOf(request.getParameter("hora")+":00");
			int id_tipoEle = Integer.parseInt(request.getParameter("tipo_elemento"));
			int id_ele = Integer.parseInt(request.getParameter("elemento"));
			int id_persona = Integer.parseInt(request.getParameter("id_persona"));
			int cant_horas = Integer.parseInt(request.getParameter("cant_horas"));
			CtrlBooking ctrl = new CtrlBooking();
			Booking bok = new Booking();
			bok.setDetalle(detalle);
			bok.setFecha(fecha);
			bok.setHora(hora);
			bok.setId_elemento(id_ele);
			bok.setId_tipoElemento(id_tipoEle);
			bok.setId_persona(id_persona);
			bok.setAnulada(false);
			bok.setCant_horas(cant_horas);
			CtrlBookingTypes ctrlTypes = new CtrlBookingTypes();
			BookableTypes bkt = new BookableTypes();
			bkt = ctrlTypes.getById(id_tipoEle);
			CtrlBookableItems ctrlItems = new CtrlBookableItems();
			BookableItems bki = new BookableItems();
			bki = ctrlItems.getById(id_ele);
			try {
				ctrl.add(bok);	
			} catch (AppDataException ade) {
				request.setAttribute("Error", ade.getMessage());
			} catch (DuplicatedException de){
				request.setAttribute("Errorlim", de.getMessage());
				logger.log(Level.ERROR,"Se ha intentado reservar más elementos de los permitidos del tipo: "+bkt.getNombre());
				request.getRequestDispatcher("/WEB-INF/limiteError.jsp").forward(request, response);
			} catch (Exception e) {
				response.setStatus(502);
			}
			finally {
				request.getRequestDispatcher("/reservas.jsp").forward(request, response);		
			}
			
			Emailer.getInstance().send("tpjava2017@gmail.com","Alta de Reserva","La reserva: \n\n" +"Fecha: " +fecha +"\nHora: " +hora +"\nDetalle: " +detalle +"\nTipo Elemento: " +bkt.getNombre() 
					+"\nElemento: " +bki.getNombre() +"\nPersona: " +((People)request.getSession().getAttribute("user")).getNombre() +" " +((People)request.getSession().getAttribute("user")).getApellido() +"\n\nfue dada de alta.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
