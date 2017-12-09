package actions;

import java.util.ArrayList;

import entities.Commande;
import entities.Utilisateur;
import manager.CommandeManager;
import service.ConnectionBDD;

public class CommandeAction {
	
	public static int ajoutercommande (Commande commande){
		return CommandeManager.InsertCommande(commande);
	}
	
	public static ArrayList<Commande> displayCommandeByUtilisateur (Utilisateur utilisateur){
		ArrayList<Commande> retour = new ArrayList<Commande>();
		
		retour = CommandeManager.GetAllPendingByUser(utilisateur);
		
		return retour;
	}
 public static ArrayList<Commande>displayAll(){
	 ArrayList<Commande>commandes=CommandeManager.GetAllPending();
	 ConnectionBDD.closeConnection();
	 return commandes;
 }
 
 public static ArrayList<Commande>displayByIdEtab(int etabId){
	 ArrayList<Commande>commandes=CommandeManager.GetByEtabId(etabId);
	 ConnectionBDD.closeConnection();
	 return commandes;
 }
 

}
