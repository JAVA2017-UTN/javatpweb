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
 * Servlet implementation class altaBookableItems
 */
@WebServlet({"/AltaBookableItems", "/altaBookableItems"})
public class AltaBookableItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaBookableItems() {
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
			
			String nombre = request.getParameter("nombre");
			int id_tipoElemento = Integer.parseInt(request.getParameter("tipoElemento"));
		
			
			CtrlBookableItems ctrl = new CtrlBookableItems();
			
			BookableItems bi = new BookableItems();
			
			
			bi.setNombre(nombre);
			bi.setId_tipoElemento(id_tipoElemento);
			
			
			try {
				ctrl.add(bi);
			} catch (AppDataException ade) {
				request.setAttribute("Error", ade.getMessage());
			} catch (Exception e) {
				response.setStatus(502);
			}
			
			request.getRequestDispatcher("/bookableItems.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
