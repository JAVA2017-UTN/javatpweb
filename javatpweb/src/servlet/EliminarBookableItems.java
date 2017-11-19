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
import util.AppDataException;

/**
 * Servlet implementation class EliminarBookableItems
 */
@WebServlet("/EliminarBookableItems")
public class EliminarBookableItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarBookableItems() {
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
				//String nombre = request.getParameter("nombre");
				//int id_tipoElemento = Integer.parseInt(request.getParameter("tipoElemento"));
				
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
					request.getRequestDispatcher("WEB-INF/sqlError.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					response.setStatus(502);
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
