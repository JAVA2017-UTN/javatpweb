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
 * Servlet implementation class Login
 */
@WebServlet({"/Login", "/login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
			
			try {
				request.getSession().setAttribute("user", ctrl.validaUsuario(per));								
			} catch (AppDataException ade) {
				request.setAttribute("Error", ade.getMessage());
			} catch (Exception e) {
				response.setStatus(502);
			}
			if(ctrl.validaUsuario(per) != null) {
				try {
					request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);												
				} catch (Exception e) {
					response.setStatus(502);
				}	
			}
			else {
				try {
					request.getRequestDispatcher("WEB-INF/errorLogueo.jsp").forward(request, response);												
				} catch (Exception e) {
					response.setStatus(502);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
