package conroler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Utilisateur;
import manager.CookieManager;
import manager.SessionManager;
import service.C;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogOut() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur user = (Utilisateur) SessionManager.getSessionValue(C.Utilisateur.sessionUserConnect, request);
		String url = "WEB-INF/connection.jsp";
		if (user != null) {
			SessionManager.removeValue(C.Utilisateur.sessionUserConnect, request);
			CookieManager.supprimerCookie(C.Utilisateur.TokenCookieUser, request, response);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
