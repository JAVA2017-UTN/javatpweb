package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.CtrlBookingTypes;
import entity.BookableTypes;
import util.AppDataException;

/**
 * Servlet implementation class ModificarBookableTypes
 */
@WebServlet("/ModificarBookableTypes")
public class ModificarBookableTypes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarBookableTypes() {
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
			if(request.getParameter("modificar") != null){
				String id = request.getParameter("id");
				String nombre = request.getParameter("nombre");
				String cantReservasPendientes = request.getParameter("cantReservasPendientes");
			
				
				CtrlBookingTypes ctrl = new CtrlBookingTypes();
				
				BookableTypes bt = new BookableTypes();
				
				bt.setId(Integer.parseInt((id)));
				bt.setNombre(nombre);
				bt.setCantReservasPendientes(Integer.parseInt(cantReservasPendientes));
				
				try {
					ctrl.update(bt);
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
			
				
				CtrlBookingTypes ctrl = new CtrlBookingTypes();
				
				BookableTypes bt = new BookableTypes();
				
				bt.setId(Integer.parseInt((id)));
				bt.setNombre(nombre);
				bt.setCantReservasPendientes(Integer.parseInt(cantReservasPendientes));
				
				try {
					ctrl.delete(bt);
				} catch (AppDataException ade) {
					request.setAttribute("Error", ade.getMessage());
				} catch (Exception e) {
					response.setStatus(502);
				}
			}
			
			
			request.getRequestDispatcher("/bookableTypes.jsp").forward(request, response);
			
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
