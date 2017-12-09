package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Commande implements Serializable {
	int id;
	Utilisateur utilisateur;
	Date date;
	boolean valide;
	ArrayList<LigneDeCommande> ligneDeCommande;
	
	
	public ArrayList<LigneDeCommande> getLigneDeCommande() {
		return ligneDeCommande;
	}

	public void setLigneDeCommande(ArrayList<LigneDeCommande> ligneDeCommande) {
		this.ligneDeCommande = ligneDeCommande;
	}

	public Commande(int id) {
		super();
		this.id = id;
	}

	public Commande() {

	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public boolean isValide() {
		return valide;
	}
	
	public void setValide(boolean valide) {
		this.valide = valide;
	}
}
