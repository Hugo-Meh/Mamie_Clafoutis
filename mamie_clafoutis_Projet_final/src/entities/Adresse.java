package entities;

import java.io.Serializable;

public class Adresse implements Serializable{
	private int id;
	private int numero_rue;
	private String nom_rue;
	private String ville;
	private String province;
	private String code_postal;
	private String pays;
	
	
	
	public Adresse(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public int getNumero_rue() {
		return numero_rue;
	}
	public String getNom_rue() {
		return nom_rue;
	}
	public String getVille() {
		return ville;
	}
	public String getProvince() {
		return province;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public String getPays() {
		return pays;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNumero_rue(int numero_rue) {
		this.numero_rue = numero_rue;
	}
	public void setNom_rue(String nom_rue) {
		this.nom_rue = nom_rue;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	

}
