package actions;

import java.util.ArrayList;

import entities.Commande;
import entities.LigneDeCommande;
import entities.Produit;
import manager.LigneDeCommandeManager;

public class LigneDeCommandeAction {
	
	public static int ajouterLignes(ArrayList<LigneDeCommande> lignedecommandeList){
		int retour = LigneDeCommandeManager.InsertLigneDeCommande(lignedecommandeList);
		service.ConnectionBDD.closeConnection();
		return retour;
	}
	
	public static ArrayList<LigneDeCommande> convertCommande (ArrayList<Produit> produitList, Commande commande){
		ArrayList<LigneDeCommande> retour =  LigneDeCommandeManager.ConversionLigneDeCommande(produitList, commande);
		service.ConnectionBDD.closeConnection();
		return retour;
	
	}
	
	public static ArrayList<LigneDeCommande>displayAllbyCommandeId(Commande commande){
		ArrayList<LigneDeCommande> retour = new ArrayList<LigneDeCommande>();
		retour.addAll(LigneDeCommandeManager.getAllByCommandeId(commande));
		service.ConnectionBDD.closeConnection();
		return retour;
	}
	
}
