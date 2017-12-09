package conroler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import actions.ProduitAction;
import entities.ParametresProduit;
import entities.Produit;
import service.C;
import utils.Utils;

/**
 * Servlet implementation class GestionProduit
 */
@WebServlet("/GestionProduit")
public class GestionProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionProduit() {
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
		
		
		messagerecu = Utils.recieveJsonRequest(request);
		ParametresProduit parametresproduit = gson.fromJson(messagerecu, ParametresProduit.class);
		System.out.println(parametresproduit.getUrl());
		if(parametresproduit != null){
			
			Produit produitrecu = gson.fromJson(messagerecu, Produit.class);
			
			if (parametresproduit.getUrl().equals(C.Produit.urlActionProduitAdd)){
				if(ProduitAction.Ajouter(produitrecu) != -1){
					// l'insertion c'est bien d�roul�e
				}
				else{
					// l'insertion s'est mal d�roul�e
				}
			}
			
			if (parametresproduit.getUrl().equals(C.Produit.urlActionProduitDisplay)){
				
				ArrayList<Produit> listProduit = ProduitAction.displayAll();
				
				/*for(int i =0;i<listProduit.size();i++){
					
					gson.toJson(listProduit.get(i));
				}*/
				System.out.println(gson.toJson(listProduit));
				messageEnvoye = gson.toJson(listProduit);
				
				
				
			}
			
			
			//request.getRequestDispatcher("WEB-INF/GestionProduit.jsp").forward(request, response);
			
		}
		// construction + envoie message produit par categorie.
		
		ArrayList<Produit> listProduit = ProduitAction.displayByCategorie(1);
		System.out.println(gson.toJson(listProduit));
		messageEnvoye = gson.toJson(listProduit);
		Utils.sendJsonResponse(messageEnvoye, response);
		
		// construction + envoie message all product.
		/*ArrayList<Produit> listProduit = ProduitAction.displayAll();
		System.out.println(gson.toJson(listProduit));
		messageEnvoye = gson.toJson(listProduit);
		Utils.sendJsonResponse(messageEnvoye, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
