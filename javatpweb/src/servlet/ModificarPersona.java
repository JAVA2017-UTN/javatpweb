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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

/**
 * Servlet implementation class ModificarPersona
 */
@WebServlet("/ModificarPersona")
public class ModificarPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPersona() {
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
			if (request.getParameter("modificar") != null) {
				int id = Integer.parseInt(request.getParameter("id"));
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
				per.setId(id);
				per.setDni(dni);
				per.setNombre(nombre);
				per.setApellido(apellido);
				per.setEstado(estado);
				per.setUsuario(user);
				per.setContrasenia(pass);
				per.setTipo_usuario(Integer.parseInt(tipo_usu));
				try {
					ctrl.update(per);
				} catch (AppDataException ade) {
					request.setAttribute("Error", ade.getMessage());
				} catch (Exception e) {
					response.setStatus(502);
				}
			}
			if (request.getParameter("eliminar") != null) {
				int id = Integer.parseInt(request.getParameter("id"));
				String dni = request.getParameter("dni");
				String user = request.getParameter("usuario");
				String pass = request.getParameter("contrasenia");
				String nombre = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");
				String estadoForm = request.getParameter("estado");
				String tipo_usu = request.getParameter("tipo_usuario");
				boolean estado = true;
				if (estadoForm == "1") {
					estado = true;
				}
				else {
					estado = false;
				}
				CtrlABMPeople ctrl = new CtrlABMPeople();
				People per = new People();
				per.setId(id);
				per.setDni(dni);
				per.setNombre(nombre);
				per.setApellido(apellido);
				per.setEstado(estado);
				per.setUsuario(user);
				per.setContrasenia(pass);
				per.setTipo_usuario(Integer.parseInt(tipo_usu));
				try {
					ctrl.delete(per);
				} catch (AppDataException ade) {
					request.setAttribute("Error", ade.getMessage());
				} catch (Exception e) {
					response.setStatus(502);
				}
				logger.log(Level.WARN,((People)request.getSession().getAttribute("user")).getNombre() +" ha eliminado al usuario: "+user +" de id: " +id);
			}
			
			
			request.getRequestDispatcher("people.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
