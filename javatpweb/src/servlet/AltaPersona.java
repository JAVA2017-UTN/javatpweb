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
 * Servlet implementation class AltaPersona
 */
@WebServlet("/AltaPersona")
public class AltaPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaPersona() {
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
			String dni = request.getParameter("dni");
			String user = request.getParameter("usuario");
			String pass = request.getParameter("contrasenia");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String estadoForm = request.getParameter("estado");
			String tipo_usu = request.getParameter("tipo_usuario");
			boolean estado = true;
			if (estadoForm.equals("1")) {
				estado = true;
			}
			else {
				estado = false;
			}
			CtrlABMPeople ctrl = new CtrlABMPeople();
			People per = new People();
			per.setDni(dni);
			per.setNombre(nombre);
			per.setApellido(apellido);
			per.setEstado(estado);
			per.setUsuario(user);
			per.setContrasenia(pass);
			per.setTipo_usuario(Integer.parseInt(tipo_usu));
			try {
				ctrl.add(per);
			} catch (AppDataException ade) {
				request.setAttribute("Error", ade.getMessage());
			} catch (Exception e) {
				response.setStatus(502);
			}
			
			request.getRequestDispatcher("people.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
