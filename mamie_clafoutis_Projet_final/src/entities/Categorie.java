package entities;

import java.io.Serializable;

public class Categorie implements Serializable {
	
	int id;
	String denomination;
	
	public Categorie() {
			
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
}


