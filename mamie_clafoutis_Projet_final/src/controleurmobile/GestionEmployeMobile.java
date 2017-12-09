package controleurmobile;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import actions.UtilisateurAction;
import entities.ParametresUtilisateur;
import entities.Utilisateur;
import service.C;
import utils.Utils;

/**
 * Servlet implementation class GestionEmployeMobile
 */
@WebServlet("/GestionEmployeMobile")
public class GestionEmployeMobile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionEmployeMobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String messageRecu = Utils.recieveJsonRequest(request);
		Gson gson = new Gson();
		String messageEnvoye="utilisateur inconnu";
		if (!messageRecu.equals("")) {
			ParametresUtilisateur param = gson.fromJson(messageRecu, ParametresUtilisateur.class);
			if (param.getUrl().equals(C.Utilisateur.urlActionUserdisplay)) {
				if (param.getParam() == null || param.getParam().getIdParam() == null){
					ArrayList<Utilisateur>allUsers=UtilisateurAction.displayAllUser();
					messageEnvoye=gson.toJson(allUsers);
					
				}
				else if (param.getParam().getIdParam().equals(C.Utilisateur.etabId)) {
					ArrayList<Utilisateur>allUsers=UtilisateurAction.afficherParIdEtab(Integer.parseInt(param.getParam().getValeurParam()));
					messageEnvoye=gson.toJson(allUsers);
				}
			} else if (param.getUrl().equals(C.Utilisateur.urlActionUserUpdate)) {
			//	int retour=UtilisateurAction.Modifier(gson.fromJson(param.getUserJsonType(), Utilisateur.class));
				//messageEnvoye=gson.toJson(retour);

			}else if(param.getUrl().equals(C.Utilisateur.urlActionUseradd)){
			//	int retour=UtilisateurAction.ajouterUtilsateur(gson.fromJson(param.getUserJsonType(), Utilisateur.class));
			//	messageEnvoye=gson.toJson(retour);
			}else{
				//int retour=UtilisateurAction.delete(gson.fromJson(param.getUserJsonType(), Utilisateur.class));
				//messageEnvoye=gson.toJson(retour);
			}

		}
		Utils.sendJsonResponse(messageEnvoye, response);
	}

}
