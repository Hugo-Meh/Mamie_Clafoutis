package entities;

import java.io.Serializable;

import com.mysql.jdbc.Util;

import utils.Utils;

public class Utilisateur implements Serializable{
	private int id;
	private String nom;
	private String prenom;
	private Etablissement etablissement;
	private Role role;
	private String userName;
	private String password;
	private boolean isVisible;
	private String tokenIdentification;
	private String tokenInscription;
	private String tokenIdetntificationMobile;
	

	public Utilisateur() {
		super();
	}
	
	public Utilisateur(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public Etablissement getEtablissement() {
		return etablissement;
	}
	public Role getRole() {
		return role;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public String getTokenIdentification() {
		return tokenIdentification;
	}
	public String getTokenInscription() {
		return tokenInscription;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public void setTokenIdentification(String tokenIdentification) {
		this.tokenIdentification = tokenIdentification;
	}
	public void setTokenInscription(String tokenInscription) {
		this.tokenInscription = tokenInscription;
	}
	
	public void hashPassword(){
		password=Utils.md5(password);
	}

	
	public void changeTokenIdentifaction(){
		tokenIdentification=Utils.generateToken("");
	}
	
	public void changeTokenInscription(){
		tokenInscription=Utils.generateToken("");
	}
	public String getTokenIdetntificationMobile() {
		return tokenIdetntificationMobile;
	}
	public void setTokenIdetntificationMobile(String tokenIdetntificationMobile) {
		this.tokenIdetntificationMobile = tokenIdetntificationMobile;
	}
}
