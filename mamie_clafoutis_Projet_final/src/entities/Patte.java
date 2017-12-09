package entities;

import java.util.ArrayList;

public class Patte {
	private int id;
	private String nom;
	private float poid;
	private ArrayList<Ingredient>ingredientList;
	private Unite unite;
	
	public Patte() {
		super();
		
	}
	
	public Patte(int id) {
		super();
		this.id = id;
	}
	public float getPoid() {
		return poid;
	}
	public void setPoid(float poid) {
		this.poid = poid;
	}
	public Unite getUnite() {
		return unite;
	}
	public void setUnite(Unite unite) {
		this.unite = unite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Ingredient> getIngredientList() {
		return ingredientList;
	}
	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}
	

}
