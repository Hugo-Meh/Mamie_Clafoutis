package controleurmobile;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import actions.EtablissementAction;
import actions.ProduitAction;
import actions.UtilisateurAction;
import entities.Etablissement;
import entities.Parametre;
import entities.ParametresProduit;
import entities.Produit;
import entities.Utilisateur;
import manager.UtilisateurManager;
import service.C;
import utils.Utils;

/**
 * Servlet implementation class GestionProduit
 */
@WebServlet("/GestionProduitMobile")
public class GestionProduitMobile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionProduitMobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("je suis dans la gestion de produit");
		String messagerecu,messageEnvoye = null;
		Gson gson = new Gson();
		String url = null;
		String token = null;
		Parametre param = null;
		messagerecu = Utils.recieveJsonRequest(request);
		System.out.println(messagerecu);
		ParametresProduit parametresproduit = gson.fromJson(messagerecu, ParametresProduit.class);
		System.out.println(gson.fromJson(messagerecu, ParametresProduit.class));
		param = parametresproduit.getParametreList();
		System.out.println(param);
		if(parametresproduit != null){
			
			token = parametresproduit.getToken();
			System.out.println(token);
			System.out.println(UtilisateurManager.getByToken(token) != null);
			if(UtilisateurManager.getByToken(token) != null){
				
				url = parametresproduit.getUrl();		
				System.out.println(url.equals(C.Produit.urlActionProduitDisplay));
				if (url.equals(C.Produit.urlActionProduitDisplay)){
					ArrayList<Produit> listProduit = ProduitAction.displayAll();
					messageEnvoye = gson.toJson(listProduit);
					System.out.println(messageEnvoye);
					Utils.sendJsonResponse(messageEnvoye, response);	
				}

				else if (url.equals(C.Produit.urlActionProduitDisplayCategorie)){
					System.out.println(param != null && param.getIdParam().equals("categorieId"));
					System.out.println(param );
					System.out.println(param.getIdParam());
					if (param != null && param.getIdParam().equals("categorieId") ){
						System.out.println("categorie");
						int valeurParam = Integer.parseInt(param.getValeurParam());
						ArrayList<Produit> listProduit = ProduitAction.displayByCategorie(valeurParam);
						System.out.println(gson.toJson(listProduit));
						messageEnvoye = gson.toJson(listProduit);
						System.out.println(messageEnvoye);
						Utils.sendJsonResponse(messageEnvoye, response);
					}
					else{
						// gerer erreur param message
					}
				}

				else if (url == C.Produit.urlActionProduitDisplayId || url.equals(C.Ingredient.urldisplayAllingredientsbyproduitid)){

					if (param.getIdParam() == "produitId" ){
						
						Utilisateur utilisateur = UtilisateurManager.getByToken(token);
						Etablissement etablisement = utilisateur.getEtablissement();
						int idType = etablisement.getTypeEtablissement().getId();
						
						int valeurParam = Integer.parseInt(param.getValeurParam());
						Produit produit = ProduitAction.displayById(valeurParam);
						
						if(idType != C.Etablissement.idCorpo){
							produit.getPatte().setIngredientList(null);
						}
						messageEnvoye = gson.toJson(produit);
						Utils.sendJsonResponse(messageEnvoye, response);

					}
					else{
						// gerer erreur param message
					}
				}

				else{
					// gerer erreur url message
				}

			}

		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
