package controleurmobile;

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
import actions.UtilisateurAction;
import entities.Commande;
import entities.Etablissement;
import entities.LigneDeCommande;
import entities.Message;
import entities.Parametre;
import entities.ParametresCommande;
import entities.ParametresProduit;
import entities.Produit;
import entities.Utilisateur;
import manager.UtilisateurManager;
import service.C;
import utils.Utils;

/**
 * Servlet implementation class GestionCommande
 */
@WebServlet("/GestionCommande")
public class GestionCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("je suis dans la gestion de commande");
		String messagerecu,messageEnvoye = null;
		Gson gson = new Gson();
		String url = null;
		String token = null;
		messagerecu = Utils.recieveJsonRequest(request);
		System.out.println(messagerecu);
		ParametresCommande parametrescommande = gson.fromJson(messagerecu, ParametresCommande.class);
		System.out.println(gson.fromJson(messagerecu, ParametresProduit.class));
		
		if(parametrescommande != null){
			System.out.println(parametrescommande);
			token = parametrescommande.getToken();
			url = parametrescommande.getUrl();
			System.out.println(token);
			System.out.println(url);
			System.out.println(C.Commande.urlsoumettrecommande);
		
			

			if(UtilisateurManager.getByToken(token) != null){
				
				Utilisateur utilisateur = UtilisateurManager.getByToken(token);
				Etablissement etablisement = utilisateur.getEtablissement();
				int idRole = utilisateur.getRole().getId();
				int idType = etablisement.getTypeEtablissement().getId();
				

				if(url.equals(C.Commande.urlsoumettrecommande)){
				
					if ((idRole == C.Role.idChefBoulanger || idRole == C.Role.idGerant) && (idType == C.Etablissement.idFranchise) ){
						System.out.println("vous êtes authorisé");
						ArrayList<Produit> produitList = parametrescommande.getProduitList();

						Commande commande = new Commande();
						commande.setDate(new Date ());
						commande.setUtilisateur(utilisateur);
						commande.setId(CommandeAction.ajoutercommande(commande));
						ArrayList<LigneDeCommande> lignedecommandeList = LigneDeCommandeAction.convertCommande(produitList, commande);
						LigneDeCommandeAction.ajouterLignes(lignedecommandeList);

						Message message = new Message();
						message.setMessageContent(C.Message.successCommande);
						messageEnvoye = gson.toJson(message);
						Utils.sendJsonResponse(messageEnvoye, response);
						
					}
				}
				
				if (url.equals(C.Commande.urlaffichercommandes)){
					System.out.println("j'affiche les commandes");
					if ((idRole == C.Role.idChefBoulanger || idRole == C.Role.idGerant) && (idType == C.Etablissement.idFranchise)){
						Etablissement etablissement = utilisateur.getEtablissement();
						ArrayList<Utilisateur> utilisateurList = new ArrayList<Utilisateur>();
						utilisateurList = (UtilisateurAction.getGerantBoulangerByEtab(etablissement));
						System.out.println(utilisateurList);
						ArrayList<Commande> commandeList = new ArrayList<Commande>();
						for (Utilisateur user : utilisateurList){
							commandeList.addAll(CommandeAction.displayCommandeByUtilisateur(user));
							
						}
						System.out.println(commandeList.size());
						
						for (Commande commande : commandeList){
							System.out.println(commande.getId());
							
							commande.setLigneDeCommande(LigneDeCommandeAction.displayAllbyCommandeId(commande));
							System.out.println(	commande.getLigneDeCommande());
							System.out.println(	commande);
							messageEnvoye = gson.toJson(commande);
						}
						System.out.println(	messageEnvoye);
						
						System.out.println(	messageEnvoye);
						Utils.sendJsonResponse(messageEnvoye, response);
						
						
						
						
						
					}
					else if ((idRole == C.Role.idChefBoulanger || idRole == C.Role.idAdmin) && (idType == C.Etablissement.idSiege)){
						ArrayList<Commande> commandeList = new ArrayList<Commande>();
						
						for (Commande commande : commandeList){
							commande.setLigneDeCommande(LigneDeCommandeAction.displayAllbyCommandeId(commande));
							
						}
						
						messageEnvoye = gson.toJson(commandeList);
						System.out.println(	messageEnvoye);
						Utils.sendJsonResponse(messageEnvoye, response);
					}
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
