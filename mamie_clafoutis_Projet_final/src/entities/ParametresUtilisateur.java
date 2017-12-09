package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class ParametresUtilisateur implements Serializable {
	private String url;
	private Utilisateur userJsonType;
	private Parametre param;
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Parametre getParam() {
		return param;
	}

	public void setParam(Parametre param) {
		this.param = param;
	}

	public Utilisateur getUserJsonType() {
		return userJsonType;
	}

	public void setUserJsonType(Utilisateur userJsonType) {
		this.userJsonType = userJsonType;
	}

}
