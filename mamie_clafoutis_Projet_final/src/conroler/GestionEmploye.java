package conroler;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import actions.EtablissementAction;
import actions.RoleAction;
import actions.UtilisateurAction;
import entities.Etablissement;
import entities.Parametre;
import entities.ParametresUtilisateur;
import entities.Role;
//import entities.ParametresUtilisateur;
import entities.Utilisateur;
import manager.SessionManager;
import service.C;
import service.ConnectionBDD;
import utils.Utils;

/**
 * Servlet implementation class GestionEmploye
 */
@WebServlet("/gestionEmploye")
public class GestionEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionEmploye() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "WEB-INF/GestionUtilisateurs.jsp";
		String action = request.getParameter("action");

		Utilisateur user = (Utilisateur) SessionManager.getSessionValue(C.Utilisateur.sessionUserConnect, request);
		ArrayList<Utilisateur> allUsers = null;
		if (user != null) {
			if (action.equals(C.Utilisateur.urlActionUseradd)) {

				ArrayList<Role> RoleList = RoleAction.getByIdEtab(user.getEtablissement().getId());
				request.setAttribute("role", RoleList);
				url = "WEB-INF/AjouterUtilisateur.jsp";
				if (user.getEtablissement().getTypeEtablissement().getId() == 1) {
					ArrayList<Etablissement> etabList = EtablissementAction.getAll();

					request.setAttribute("etab", etabList);

				}
			} else if (user.getEtablissement().getTypeEtablissement().getId() != 1) {
				allUsers = UtilisateurAction.afficherParIdEtab(user.getEtablissement().getId());
				ConnectionBDD.closeConnection();
				request.setAttribute(C.Utilisateur.cleUsers, allUsers);
			} else {
				allUsers = UtilisateurAction.displayAllUser();
				ConnectionBDD.closeConnection();
				request.setAttribute(C.Utilisateur.cleUsers, allUsers);
			}

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String messageRecu = Utils.recieveJsonRequest(request);
		System.out.println();
		Gson gson = new Gson();
		String messageRetour = "";
		Utilisateur userSession = (Utilisateur) SessionManager.getSessionValue(C.Utilisateur.sessionUserConnect,
				request);
		System.out.println(messageRecu);
		if (userSession != null) {
			ParametresUtilisateur paramUser = gson.fromJson(messageRecu, ParametresUtilisateur.class);
			System.out.println(messageRecu);
			Utilisateur user = paramUser.getUserJsonType();
			System.out.println(paramUser.getUserJsonType().getNom());
			if (user != null) {

				if (paramUser.getUrl().equals(C.Utilisateur.urlActionUseradd)) {
					int retour = UtilisateurAction.ajouterUtilsateur(user);
					ConnectionBDD.closeConnection();
					messageRetour = "" + retour;

				} else if (paramUser.getUrl().equals(C.Utilisateur.urlActionUserUpdate)) {
					if (paramUser.getParam() == null) {
						int retour = UtilisateurAction.Modifier(user);
						ConnectionBDD.closeConnection();
						messageRetour = "" + retour;
					}else {
						if(paramUser.getParam().getIdParam().equals("pwd")){
							user.setId(userSession.getId());
							user.setUserName(userSession.getUserName());
							int retour = UtilisateurAction.modifierpassword(user, paramUser.getParam().getValeurParam());
							messageRetour=""+retour;
						}
					}
				} else if (paramUser.getUrl().equals(C.Utilisateur.urlActionUserdelete)) {
					int retour = UtilisateurAction.delete(user);
					ConnectionBDD.closeConnection();
					messageRetour = "" + retour;
				}
			}

		}
		System.out.println("message retour **" + messageRetour + "**");
		Utils.sendJsonResponse(messageRetour, response);
	}
}
