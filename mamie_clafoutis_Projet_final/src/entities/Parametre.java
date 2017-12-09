package entities;

import java.io.Serializable;

public class Parametre implements Serializable{
	
	private String idParam;
	private String valeurParam;
	
	
	public Parametre() {
		super();
	}
	public Parametre(String idParam, String valeurParam) {
		super();
		this.idParam = idParam;
		this.valeurParam = valeurParam;
	}
	public String getIdParam() {
		return idParam;
	}
	public void setIdParam(String idParam) {
		this.idParam = idParam;
	}
	public String getValeurParam() {
		return valeurParam;
	}
	public void setValeurParam(String valeurParam) {
		
		this.valeurParam = valeurParam;

	}
	
}
