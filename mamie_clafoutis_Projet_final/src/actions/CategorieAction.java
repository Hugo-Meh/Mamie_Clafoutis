package actions;

import java.util.ArrayList;

import entities.Categorie;
import manager.CategorieManager;

public class CategorieAction {
	public static ArrayList<Categorie> displayAll(){
		return CategorieManager.getAll();
	}

}
