package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

import com.google.gson.Gson;

public class Ingredient implements Serializable {

	int id;
	String denomination;
	float quantite;
	Unite unite;

	public Ingredient() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public float getQuantite() {
		return quantite;
	}

	public void setQuantite(float quantite) {
		this.quantite = quantite;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	public static ArrayList<Ingredient> removeIngredientSelected(int[] ingredientSelected,
			ArrayList<Ingredient> listIngredient) {
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		for (Ingredient ingred : listIngredient) {
			int i = 0;
			boolean trouve = false;
			while (i < ingredientSelected.length && !trouve) {
				if (ingred.getId() == ingredientSelected[i]) {
					trouve = true;
				}
				i++;
			}
			if (i >= ingredientSelected.length && !trouve) {
				ingredients.add(ingred);
			}
		}
		return ingredients;

	}

}
