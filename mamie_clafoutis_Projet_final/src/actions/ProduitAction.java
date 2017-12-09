package actions;



import java.util.ArrayList;

import entities.Ingredient;
import entities.Produit;
import manager.ImageManager;
import manager.IngredientManager;
import manager.LigneIngredientManager;
import manager.PattesManager;
import manager.ProduitManager;
import manager.ProduitPatteManager;
import service.C;
import service.ConnectionBDD;
import utils.Utils;

public class ProduitAction {

	public static int Ajouter(Produit produit) {
		int retour = 0;

		int produitId = ProduitManager.Insert(produit);
		if (produitId > 0) {
			System.out.println(produit.getImageList().get(0).getFormatWeb());
			ImageManager.insert(produit.getImageList().get(0).getFormatWeb(), produitId);
			ProduitPatteManager.insertAssiciationProduitPatte(produit.getPatte().getPoid(), produitId,
					produit.getPatte().getId());
			for (Ingredient ingredient : produit.getIngredientList())

				retour = LigneIngredientManager.insertLigneingredientProduit(ingredient.getId(), produitId,
						ingredient.getQuantite());
		}

		return retour;
	}

	public static ArrayList<Produit> displayAll() {

		return ProduitManager.getAll();

	}

	public static ArrayList<Produit> displayByCategorie(int id) {

		return ProduitManager.getByCategorie(id);

	}

	public static Produit displayById(int id) {
		Produit produit = ProduitManager.GetById(id);
		int idP = produit.getId();
		produit.setIngredientList(IngredientManager.getByIdProduit(idP));
		produit.setPatte(PattesManager.getByIdProduit(idP));
		produit.setImageList(ImageManager.getByIdproduit(idP));
		return produit;
	}

	static public int toggleVisibily(boolean switchVisibility, int idProduit) {
		int retour = ProduitManager.toggleVisibility(switchVisibility, idProduit);
		ConnectionBDD.closeConnection();
		return retour;
	}

	static public ArrayList<Produit> displayInvisibleProduit() {
		return ProduitManager.getProduitCache();
	}
}
