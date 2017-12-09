package actions;

import java.util.ArrayList;

import entities.Ingredient;
import manager.IngredientManager;
import service.ConnectionBDD;


public class IngredientAction {

	
	public static ArrayList<Ingredient>displayAll(){
		ArrayList<Ingredient>ingredients=IngredientManager.getAll();
		ConnectionBDD.closeConnection();
		return ingredients;
	}

}
