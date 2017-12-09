package entities;

import java.io.Serializable;

public class Etablissement implements Serializable{
	private int id;private String  name;
	private String tel;
	private Type_Etablissement typeEtablissement;
	private Adresse adresse; 
	private boolean isVisible;
	
	
	
	
	public Etablissement() {
		super();
	}
	public Etablissement(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public Type_Etablissement getTypeEtablissement() {
		return typeEtablissement;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setTypeEtablissement(Type_Etablissement typeEtablissement) {
		this.typeEtablissement = typeEtablissement;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	

}
