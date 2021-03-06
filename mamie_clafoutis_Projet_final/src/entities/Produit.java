package entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;

public class Produit implements Serializable  {
		
	private int id;
	private String nom;
	private Categorie categorie;
	private String description;
	private float prix;
	private boolean estVisible;
	private String reference;
	private float poid;
	private Unite unite;
	private ArrayList<Image>imageList;
	private ArrayList<Ingredient> ingredientList;
	private Patte patte;
	private int quantite;
	
	
	
	

	public Produit() {
		
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public boolean isEstVisible() {
		return estVisible;
	}

	public void setEstVisible(boolean estVisible) {
		this.estVisible = estVisible;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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

	public ArrayList<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public Patte getPatte() {
		return patte;
	}

	public void setPatte(Patte patte) {
		this.patte = patte;
	}	
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public ArrayList<Image> getImageList() {
		return imageList;
	}

	public void setImageList(ArrayList<Image> imageList) {
		this.imageList = imageList;
	}

	
	
	
	
	static public ArrayList<Produit>setQuantiteForArray(ArrayList<Produit>listProduit){
		ArrayList<Produit>list=listProduit;
		for(Produit p:list){
			p.setQuantite(-1);
		}
		return list;
	}
}
