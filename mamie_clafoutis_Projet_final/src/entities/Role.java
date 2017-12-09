package entities;

import java.io.Serializable;

public class Role implements Serializable{
	private int id;
	private String titre;
	
	
	public Role() {
		super();
	}
	public Role(int id) {
		super();
		this.id = id;	
	}
	public int getId() {
		return id;
	}
	public String getTitre() {
		return titre;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	

}
