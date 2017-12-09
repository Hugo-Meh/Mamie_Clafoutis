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
import service.ConnectionBDD;
import utils.Utils;

/**
 * Servlet implementation class LogIn
 */
@WebServlet(description = "servlet de validation de connexion ou de token modifie le token et renvoie les information necessaire et l'enregistre dans la base de donnée", urlPatterns = {
		"/logIn" })
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String messageRecu, messageEnvoye;
		Gson gson = new Gson();
		Utilisateur utilsateurTrouve;
		String url = "WEB-INF/connection.jsp";
		messageRecu = Utils.recieveJsonRequest(request);
		
		Utilisateur user = gson.fromJson(messageRecu, Utilisateur.class);
		if (user != null) {
			System.out.println("user   ->"+user.getUserName() + "   "+user.getPassword() );
			utilsateurTrouve = UtilisateurAction.VerifierConnexion(user);
			ConnectionBDD.closeConnection();
			
			if (utilsateurTrouve != null) {
				url="accueil";
				SessionManager.addSession(C.Utilisateur.sessionUserConnect, request, utilsateurTrouve);
				CookieManager.setCookie(C.Utilisateur.timeCookieUserInlive, C.Utilisateur.TokenCookieUser, utilsateurTrouve.getTokenIdentification(), response);
			}else{
				utilsateurTrouve= new Utilisateur();
				utilsateurTrouve.setTokenIdentification("-1");
			}
			messageEnvoye=gson.toJson(utilsateurTrouve);
			System.out.println("message envoye "+messageEnvoye);
			Utils.sendJsonResponse(messageEnvoye, response);
			System.out.println("user envoye ->"+ utilsateurTrouve.getTokenIdentification());
		}
	
		System.out.println("url sortie ->"+ url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(" je suis le do post appele doget");
		doGet(request, response);

	}
}
