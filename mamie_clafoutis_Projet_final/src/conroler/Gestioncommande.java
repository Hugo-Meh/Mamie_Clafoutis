package conroler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import actions.CommandeAction;
import actions.LigneDeCommandeAction;
import actions.PatteAction;
import actions.ProduitAction;
import entities.Commande;
import entities.LigneDeCommande;
import entities.Parametre;
import entities.ParametresProduit;
import entities.Produit;
import entities.Utilisateur;
import manager.SessionManager;
import service.C;
import utils.Utils;

/**
 * Servlet implementation class Gestioncommande
 */
@WebServlet("/gestioncommande")
public class Gestioncommande extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Gestioncommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String url = "accueil";
		System.out.println("gestion de commande");
		Utilisateur user = (Utilisateur) SessionManager.getSessionValue(C.Utilisateur.sessionUserConnect, request);
		if (user != null) {
			int typeId = user.getEtablissement().getTypeEtablissement().getId();
			int roleId = user.getRole().getId();
			int etabId = user.getEtablissement().getId();

			if (action.equals(C.Commande.urlVoirPanier)) {
				url = "WEB-INF/PagePanier.jsp";
			} else if (action.equals(C.Commande.urlVoirCommandesEncours)) {
				ArrayList<Commande> listCommande = null;
				url = "WEB-INF/GestionCommandes.jsp";
				if (typeId == C.Etablissement.idSiege) {
					System.out.println("list siege " + etabId);
					listCommande = CommandeAction.displayAll();
				} else if (typeId == C.Etablissement.idFranchise) {
					System.out.println("listfranchise " + etabId);
					listCommande = CommandeAction.displayByIdEtab(etabId);
				}
				request.setAttribute("commande", listCommande);
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
		Utilisateur user = (Utilisateur) SessionManager.getSessionValue(C.Utilisateur.sessionUserConnect, request);
		String messageRecu = Utils.recieveJsonRequest(request);
		String messageEnvoye = "-3";
		System.out.println(messageRecu);

		Gson gson = new Gson();
		if (user != null) {
			if (!messageRecu.equals("")) {
				System.out.println("message panier recu" + messageRecu);
				ParametresProduit parametresProduit = gson.fromJson(messageRecu, ParametresProduit.class);
				System.out.println(parametresProduit.getUrl());
				if (parametresProduit.getUrl().equals(C.Commande.urlAjouterAuPanier)) {
					if (parametresProduit.getProduitJsonType() != null) {
						int produitId = parametresProduit.getProduitJsonType().getId();
						Produit produit = ProduitAction.displayById(produitId);
						produit.setQuantite(parametresProduit.getProduitJsonType().getQuantite());
						SessionManager.addSessionInTable(C.Produit.tabProduitListPanier, request, produit);
						messageEnvoye = "produitajoute";

					}
				} else if (parametresProduit.getUrl().equals(C.Commande.urlsoumettrecommande)) {
					ArrayList<Produit> produits = SessionManager.getSessionTabValue(C.Produit.tabProduitListPanier,
							request);
					if (produits != null) {
						Commande commande = new Commande();
						commande.setDate(new Date());
						commande.setUtilisateur(user);
						commande.setId(CommandeAction.ajoutercommande(commande));
						ArrayList<LigneDeCommande> lignedecommandeList = LigneDeCommandeAction.convertCommande(produits,
								commande);
						LigneDeCommandeAction.ajouterLignes(lignedecommandeList);
						SessionManager.removeValue(C.Produit.tabProduitListPanier, request);
						messageEnvoye = gson.toJson("commande valide");
					}
				} else if (parametresProduit.getUrl().equals(C.Commande.urlModifierPanier)) {
					Produit produit = parametresProduit.getProduitJsonType();
					if (produit != null) {
						int qte = produit.getQuantite() > 0 ? produit.getQuantite() : 0;
						produit.setQuantite(qte);
						ArrayList<Produit> produits = SessionManager.getSessionTabValue(C.Produit.tabProduitListPanier,
								request);
						ParametresProduit pp = SessionManager.modifierPanier(produits, produit);
						messageEnvoye = gson.toJson(pp);

					}
				} else if (parametresProduit.getUrl().equals(C.Commande.urlDetailCommande)) {
					Parametre param = parametresProduit.getParametreList();
					System.out.println("detailcommande");
					if (param != null) {
						if (param.getIdParam().equals("idCommande")) {
							int idcommande = Integer.parseInt(param.getValeurParam());
							Commande commande = new Commande();
							commande.setId(idcommande);
							ArrayList<LigneDeCommande> lc = LigneDeCommandeAction.displayAllbyCommandeId(commande);
							messageEnvoye = gson.toJson(lc);
						}
					}
				}
			}
			System.out.println(messageEnvoye);
			Utils.sendJsonResponse(messageEnvoye, response);
		}
	}

}