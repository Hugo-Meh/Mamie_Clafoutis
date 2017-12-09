package conroler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import actions.CategorieAction;
import actions.IngredientAction;
import actions.PatteAction;
import actions.ProduitAction;
import actions.UniteAction;
import entities.Categorie;
import entities.Ingredient;
import entities.ParametresProduit;
import entities.Patte;
import entities.Produit;
import entities.Unite;
import entities.Utilisateur;
import manager.SessionManager;
import service.C;
import service.ConnectionBDD;
import utils.Utils;

/**
 * Servlet implementation class GestionP
 */
@WebServlet("/gestionP")
@MultipartConfig
public class GestionP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionP() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "WEB-INF/GestionProduit.jsp";
		String action = request.getParameter("action");
		Utilisateur user = (Utilisateur) SessionManager.getSessionValue(C.Utilisateur.sessionUserConnect, request);
		if (user != null) {
			int idRole = user.getRole().getId();
			int idEtab = user.getEtablissement().getTypeEtablissement().getId();

			if (action.equals(C.Produit.urlActionProduitAdd)) {
				if (idEtab == C.Etablissement.idSiege && idRole == C.Role.idAdmin) {
					url = "WEB-INF/AjoutProduit.jsp";
					ArrayList<Ingredient> ingredientList = IngredientAction.displayAll();
					ArrayList<Patte> patteList = PatteAction.displayAll();
					ArrayList<Categorie> categorieList = CategorieAction.displayAll();
					ArrayList<Unite> uniteList = UniteAction.getAll();
					request.setAttribute(C.Patte.patteList, patteList);
					request.setAttribute(C.Ingredient.ingredientList, ingredientList);
					request.setAttribute(C.Categorie.categorielist, categorieList);
					request.setAttribute(C.Unite.uniteList, uniteList);
				}

			} else {
				ArrayList<Produit> produitList = ProduitAction.displayAll();
				ConnectionBDD.closeConnection();
				ArrayList<Categorie> categorieList = CategorieAction.displayAll();
				ConnectionBDD.closeConnection();
				if ((idEtab == 3 && (idRole == 2 || idRole == 3)) || (idEtab == 4 && idRole == 6)
						|| (idEtab == 2 && (idRole == 2 || idRole == 3))) {
					url = "WEB-INF/PageProduits.jsp";
					if (idEtab == 2) {
						produitList = Produit.setQuantiteForArray(produitList);
					}

				}
				request.setAttribute(C.Produit.produitList, produitList);
				request.setAttribute(C.Categorie.categorielist, categorieList);
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
		Gson gson = new Gson();
		String messageEnvoye = "-3";
		String messageRecu = Utils.recieveJsonRequest(request);
		System.out.println(messageRecu);
		ParametresProduit param = gson.fromJson(messageRecu, ParametresProduit.class);
		Utilisateur user = (Utilisateur) SessionManager.getSessionValue(C.Utilisateur.sessionUserConnect, request);
		if (user != null) {
			int idRole = user.getRole().getId();
			int idEtab = user.getEtablissement().getTypeEtablissement().getId();
			if (param != null) {
				if (param.getUrl().equals(C.Produit.urlActionProduitDisplay)) {
					if (param.getParametreList() == null) {
						ArrayList<Produit> produitList = ProduitAction.displayAll();
						ConnectionBDD.closeConnection();
						if (idEtab == 2) {
							produitList = Produit.setQuantiteForArray(produitList);
						}
						messageEnvoye = gson.toJson(produitList);

					} else {
						if (param.getParametreList().getIdParam().equals("categorie")) {
							if (param.getParametreList().getValeurParam().equals("-1")) {
								ArrayList<Produit> produitList = ProduitAction.displayInvisibleProduit();
								if (idEtab == 2) {
									produitList = Produit.setQuantiteForArray(produitList);
								}
								ConnectionBDD.closeConnection();
								messageEnvoye = gson.toJson(produitList);
							} else {
								ArrayList<Produit> produitList = ProduitAction.displayByCategorie(
										Integer.parseInt(param.getParametreList().getValeurParam()));
								if (idEtab == 2) {
									produitList = Produit.setQuantiteForArray(produitList);
								}
								ConnectionBDD.closeConnection();
								messageEnvoye = gson.toJson(produitList);
							}
						} else if (param.getParametreList().getIdParam().equals("produitId")) {
							int produitId = Integer.parseInt(param.getParametreList().getValeurParam());

							Produit produit = ProduitAction.displayById(produitId);
							if (idEtab == 3) {
								produit.getPatte().setIngredientList(null);
							} else if (idEtab == 4) {
								produit.setPatte(null);
							}
							messageEnvoye = gson.toJson(produit);
						}
					}
				} else if (param.getUrl().equals(C.Produit.urlActionProduitAdd)) {
					messageEnvoye = "" + ProduitAction.Ajouter(param.getProduitJsonType());

				} else if (param.getUrl().equals(C.Produit.urlUpdateProduit)) {
					if (param.getProduitJsonType() != null) {
						if (param.getParametreList() != null) {
							if (param.getParametreList().getIdParam().equals("switch")) {
								boolean switchVisibility = param.getParametreList().getValeurParam().equals("1");
								int idProduit = param.getProduitJsonType().getId();
								messageEnvoye = "" + ProduitAction.toggleVisibily(switchVisibility, idProduit);

							}
						}
					}
				} else if (param.getUrl().equals(C.Ingredient.urlIngredient)) {
					ArrayList<Ingredient> ingredientList = IngredientAction.displayAll();
					if (param.getIngredientId().length > 0) {
						ingredientList = Ingredient.removeIngredientSelected(param.getIngredientId(), ingredientList);
					}
					messageEnvoye = gson.toJson(ingredientList);
				}
			}
			System.out.println(messageEnvoye);
			Utils.sendJsonResponse(messageEnvoye, response);
		}
	}

}
