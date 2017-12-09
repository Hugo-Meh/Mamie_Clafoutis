package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class ParametresCommande implements Serializable{
	String url;
	ArrayList<Produit> produitList;
	String token;
	ArrayList<Commande> commandeList;
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public ArrayList<Produit> getProduitList() {
		return produitList;
	}
	
	public void setProduitList(ArrayList<Produit> produitList) {
		this.produitList = produitList;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	
	public ParametresCommande() {
	
	}
	
	
}
