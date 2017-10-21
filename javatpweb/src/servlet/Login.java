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
 * Servlet implementation class Login
 */
@WebServlet({"/Login", "/login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        logger = LogManager.getLogger(getClass());
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
			
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			
			People per=new People();
			per.setUsuario(user);
			per.setContrasenia(pass);
			
			CtrlABMPeople ctrl= new CtrlABMPeople();
			
			People pers=ctrl.validaUsuario(per);
			
			try {
				request.setAttribute("listaPersonas", ctrl.getAll());
			} catch (AppDataException ade) {
				request.setAttribute("Error", ade.getMessage());
			} catch (Exception e) {
				response.setStatus(502);
			}
			
			request.getSession().setAttribute("user", pers);
			
			logger.log(Level.INFO,"log in "+pers.getDni());
			
			request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
			//response.getWriter().append(user).append(" ").append(pass);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
