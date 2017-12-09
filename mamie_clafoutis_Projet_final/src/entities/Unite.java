package entities;

import java.io.Serializable;

public class Unite implements Serializable {
	int id;
	String denomination;
	
	public Unite() {
	
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