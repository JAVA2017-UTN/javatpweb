package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.CtrlABMPeople;
import entity.People;
import util.AppDataException;

/**
 * Servlet implementation class EditaPersona
 */
@WebServlet("/EditaPersona")
public class SeleccionaPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeleccionaPersona() {
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
			String dni = request.getParameter("dni");
			String user = request.getParameter("user");
			String pass = request.getParameter("contra");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			Boolean estadoForm = Boolean.parseBoolean(request.getParameter("estado"));
			boolean estado;
			if (estadoForm) {
				estado = true;
			}
			else {
				estado = false;
			}
			CtrlABMPeople ctrl = new CtrlABMPeople();
			People per = new People();
			per.setDni(dni);
			per.setId(Integer.parseInt(id));
			per.setNombre(nombre);
			per.setApellido(apellido);
			per.setEstado(estado);
			per.setUsuario(user);
			per.setContrasenia(pass);
			try {
				request.setAttribute("persona", per);
			} catch (Exception e) {
				response.setStatus(502);
			}
			
			request.getRequestDispatcher("WEB-INF/bmcPersona.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
