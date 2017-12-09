package actions;

import java.util.ArrayList;
import java.util.Date;

import entities.Commande;
import entities.Patte;
import entities.Produit;
import entities.ProduitPatte;
import entities.Utilisateur;
import manager.LigneDeCommandeManager;
import manager.PattesManager;
import manager.ProduitPatteManager;

public class PatteAction {

	public static ArrayList<Patte> displayAll() {
		ArrayList<Patte> patteList = null;
		patteList = PattesManager.getAll();
		service.ConnectionBDD.closeConnection();
		return patteList;
	}

	public static ArrayList<Patte> convertTabProduitsToTabPates(ArrayList<Produit> produits) {
		ArrayList<Patte> pattes = null;
		if (produits != null) {
			pattes = new ArrayList<>();
			for (Produit produit : produits) {
				Patte pate = new Patte();
				ProduitPatte pp = ProduitPatteManager.getByIdproduit(produit.getId());
				pate.setId(pp.getPatte_id());
				pate.setPoid(pp.getPoid() * produit.getQuantite());
				pattes.add(pate);
			}
			
		}
		service.ConnectionBDD.closeConnection();

		return pattes;
	}

	// version momo
	public static void enregistrerCommande(ArrayList<Produit> produits, int userId) {
		ArrayList<Patte> pattes = convertTabProduitsToTabPates(produits);
		Commande commande = new Commande();
		if (pattes != null) {
			commande.setUtilisateur(new Utilisateur(userId));
			commande.setDate(new Date());
			commande.setValide(true);
			int gk = CommandeAction.ajoutercommande(commande);
			if (gk > 0) {
				for (Patte patte : pattes){
					if(LigneDeCommandeManager.getById(gk, patte.getId())==null){
					LigneDeCommandeManager.insert(gk, patte);
					}else{
						LigneDeCommandeManager.update(gk, patte);
					}
						
				}
					
			}
		}
		service.ConnectionBDD.closeConnection();
	}
}
