package controleurmobile;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entities.Parametre;
import entities.ParametresProduit;
import entities.Produit;
import entities.Utilisateur;
import manager.UtilisateurManager;
import service.C;
import utils.Utils;

/**
 * Servlet implementation class AffichageIngredient
 */
@WebServlet("/AffichageIngredient")
public class AffichageIngredient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AffichageIngredient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("je suis dans affichage ingredients");
		String messagerecu,messageEnvoye = null;
		Gson gson = new Gson();
		String url = null;
		String token = null;
		Parametre param = null;
		Produit produit = null; 
		messagerecu = Utils.recieveJsonRequest(request);
		System.out.println(messagerecu);
		ParametresProduit parametresproduit = gson.fromJson(messagerecu, ParametresProduit.class);


		if(parametresproduit != null){

			token = parametresproduit.getToken();
			
			if(UtilisateurManager.getByToken(token) != null){
				
				url = parametresproduit.getUrl();
				
				if(url.equals(C.Ingredient.urldisplayAllingredientsbyproduitid)){
					
				}
				
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
