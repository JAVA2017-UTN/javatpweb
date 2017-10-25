package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BookableTypes;
import controllers.CtrlBookingTypes;

/**
 * Servlet implementation class BookableTypesServlet
 */
@WebServlet({"/BookableTypesServlet", "/bookabletypes", "/bookableTypes"})
public class BookableTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookableTypesServlet() {
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
			String nombre=request.getParameter("nombre");
			String cantReservasPendientes=request.getParameter("cantReservasPendientes");
		
			BookableTypes bt = new BookableTypes();
			bt.setId(Integer.parseInt(id));
			bt.setNombre(nombre);
			bt.setCantReservasPendientes(Integer.parseInt(cantReservasPendientes));
			
			CtrlBookingTypes ctrl = new CtrlBookingTypes();
			
			BookableTypes bookTypes = null; //this.mapearDeForm????

			request.setAttribute("listaTiposElementos", ctrl.getAll());
			request.getSession().setAttribute("id", bookTypes);
			request.getRequestDispatcher("WEB-INF/bookableTypes.jsp").forward(request, response);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
			//doGet(request, response);
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	

}
