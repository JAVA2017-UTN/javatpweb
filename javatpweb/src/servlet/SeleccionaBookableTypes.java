package servlet;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.CtrlBookingTypes;
import entity.BookableTypes;
import util.AppDataException;

/**
 * Servlet implementation class SeleccionaBookableTypes
 */
@WebServlet("/SeleccionaBookableTypes")
public class SeleccionaBookableTypes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeleccionaBookableTypes() {
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
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String cantReservasPendientes = request.getParameter("cantReservasPendientes");
			String estadoForm = request.getParameter("req_encargado");
			boolean req_encargado = true;
			if (estadoForm.equals("true")) {
				req_encargado = true;
			}
			else {
				req_encargado = false;
			}
			String limite = request.getParameter("limite");
			String dias = request.getParameter("dias");
			
	
			CtrlBookingTypes ctrl = new CtrlBookingTypes();
			
			BookableTypes bt = new BookableTypes();
			
			bt.setId(Integer.parseInt((id)));
			bt.setNombre(nombre);
			bt.setCantReservasPendientes(Integer.parseInt(cantReservasPendientes));
			bt.setDias(Integer.parseInt(dias));
			bt.setLimite(Integer.parseInt(limite));
			bt.setReq_encargado(req_encargado);
			
			try {
				request.setAttribute("bt", bt);
			} catch (Exception e) {
				response.setStatus(502);
			}
			
			request.getRequestDispatcher("WEB-INF/bmcBookableTypes.jsp").forward(request, response);
			
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
	}


