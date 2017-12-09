package conroler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import actions.UtilisateurAction;
import entities.Utilisateur;
import manager.CookieManager;
import manager.SessionManager;
import service.C;
import utils.Utils;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Accueil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("je suis doget accueil");

		String urlDestination = "WEB-INF/connection.jsp";
		String token= CookieManager.getCookieValue(C.Utilisateur.TokenCookieUser, request);
		if(token != null){
			Utilisateur userTosend = UtilisateurAction.autentificationUser(token);
			if(userTosend!=null){
				SessionManager.addSession(C.Utilisateur.sessionUserConnect, request, userTosend);
				CookieManager.setCookie(C.Utilisateur.timeCookieUserInlive, C.Utilisateur.TokenCookieUser, userTosend.getTokenIdentification(), response);
				urlDestination="WEB-INF/Acceuil.jsp";
			}else{
				urlDestination = "WEB-INF/connection.jsp";
				CookieManager.setCookie(0, C.Utilisateur.TokenCookieUser, "", response);
			}
		}
		request.getRequestDispatcher(urlDestination).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
