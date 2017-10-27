package servlet;

import java.io.IOException;
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
				String id = request.getParameter("id");
				String nombre = request.getParameter("nombre");
				String id_tipoElemento = request.getParameter("idTipoElemento");
				
				CtrlBookableItems ctrl = new CtrlBookableItems();
				
				BookableItems bi = new BookableItems();
				
				bi.setId(Integer.parseInt((id)));
				bi.setNombre(nombre);
				bi.setId_tipoElemento(Integer.parseInt(id_tipoElemento));
				
				try {
					ctrl.update(bi);
				} catch (AppDataException ade) {
					request.setAttribute("Error", ade.getMessage());
				} catch (Exception e) {
					response.setStatus(502);
				}
			}
			if(request.getParameter("eliminar") != null){
				String id = request.getParameter("id");
				String nombre = request.getParameter("nombre");
				
				CtrlBookableItems ctrl = new CtrlBookableItems();
				
				BookableItems bi = new BookableItems();
				
				bi.setId(Integer.parseInt((id)));
				bi.setNombre(nombre);
				
				try {
					ctrl.delete(bi);
				} catch (AppDataException ade) {
					request.setAttribute("Error", ade.getMessage());
				} catch (Exception e) {
					response.setStatus(502);
				}
			}
			
			
			request.getRequestDispatcher("/bookableItems.jsp").forward(request, response);
			
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
