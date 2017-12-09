package entities;

import java.io.Serializable;

public class Type_Etablissement implements Serializable{
	private int id;
	private String type;
	
	
	
	public Type_Etablissement(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
