package controleurmobile;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import actions.CategorieAction;
import entities.Categorie;
import entities.Parametre;
import entities.ParametresProduit;
import entities.Produit;
import manager.UtilisateurManager;
import service.C;
import utils.Utils;

/**
 * Servlet implementation class AffichageCategorie
 */
@WebServlet("/AffichageCategorie")
public class AffichageCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageCategorie() {
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
		messagerecu = Utils.recieveJsonRequest(request);
		System.out.println(messagerecu);
		ParametresProduit parametresproduit = gson.fromJson(messagerecu, ParametresProduit.class);


		if(parametresproduit != null){

			token = parametresproduit.getToken();
			
			if(UtilisateurManager.getByToken(token) != null){
				
				url = parametresproduit.getUrl();
				param = parametresproduit.getParametreList();
				
				if(url.equals(C.Categorie.urlgetallcategories)){
					
					ArrayList<Categorie> categories = CategorieAction.displayAll();
					messageEnvoye = gson.toJson(categories);
					System.out.println(messageEnvoye);
					Utils.sendJsonResponse(messageEnvoye, response);

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
