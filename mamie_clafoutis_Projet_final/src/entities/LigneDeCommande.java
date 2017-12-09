package entities;

import java.io.Serializable;

public class LigneDeCommande implements Serializable{
	
	Commande commande;
	float quantite;
	Patte patte;
	Unite unite;
	
	
	public Commande getCommande() {
		return commande;
	}


	public void setCommande(Commande commande) {
		this.commande = commande;
	}


	public float getQuantite() {
		return quantite;
	}


	public void setQuantite(float f) {
		this.quantite = f;
	}


	public Patte getPatte() {
		return patte;
	}


	public void setPatte(Patte patte) {
		this.patte = patte;
	}


	public Unite getUnite() {
		return unite;
	}


	public void setUnite(Unite unite) {
		this.unite = unite;
	}


	public LigneDeCommande() {
		
	}
	
	

}
