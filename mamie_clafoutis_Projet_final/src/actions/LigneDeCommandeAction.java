package actions;

import java.util.ArrayList;

import entities.Commande;
import entities.LigneDeCommande;
import entities.Produit;
import manager.LigneDeCommandeManager;

public class LigneDeCommandeAction {
	
	public static int ajouterLignes(ArrayList<LigneDeCommande> lignedecommandeList){
		return LigneDeCommandeManager.InsertLigneDeCommande(lignedecommandeList);
	}
	
	public static ArrayList<LigneDeCommande> convertCommande (ArrayList<Produit> produitList, Commande commande){
		return LigneDeCommandeManager.ConversionLigneDeCommande(produitList, commande);
	}
	
	public static ArrayList<LigneDeCommande>displayAllbyCommandeId(Commande commande){
		ArrayList<LigneDeCommande> retour = new ArrayList<LigneDeCommande>();
		retour.addAll(LigneDeCommandeManager.getAllByCommandeId(commande));
		return retour;
	}
	
}
