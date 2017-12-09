package actions;

import java.util.ArrayList;

import entities.Etablissement;
import entities.Utilisateur;
import manager.RoleManager;
import manager.UtilisateurManager;
import service.ConnectionBDD;
import sun.security.util.Password;

public class UtilisateurAction {
	
	public static Utilisateur autentificationUser(String tokenIdentification) {
		Utilisateur user = UtilisateurManager.getByToken(tokenIdentification);
		if (user != null) {
			user.changeTokenIdentifaction();
			UtilisateurManager.UpdateToken(user);
			user.setEtablissement(EtablissementAction.getById(user.getEtablissement().getId()));
			user.setRole(RoleManager.getById(user.getRole().getId()));

		}
		service.ConnectionBDD.closeConnection();
		return user;
	}
	
	public static Utilisateur autentificationUserNochange(String tokenIdentification) {
		Utilisateur user = UtilisateurManager.getByToken(tokenIdentification);
		if (user != null) {
			//user.changeTokenIdentifaction();
			//UtilisateurManager.UpdateToken(user);
			user.setEtablissement(EtablissementAction.getById(user.getEtablissement().getId()));
			user.setRole(RoleManager.getById(user.getRole().getId()));

		}
		service.ConnectionBDD.closeConnection();
		return user;
	}

	public static Utilisateur getUserByUserName(String userName) {
		Utilisateur user = null;
		user = UtilisateurManager.getByUserName(userName);
		service.ConnectionBDD.closeConnection();
		return user;
	}

	public static int ajouterUtilsateur(Utilisateur newUser) {
		int idgenerated = -1;
		Utilisateur user = getUserByUserName(newUser.getUserName());
		if (user == null) {

			newUser.hashPassword();
			newUser.changeTokenInscription();
			idgenerated = UtilisateurManager.InsertUser(newUser);
		}
		service.ConnectionBDD.closeConnection();
		return idgenerated;

	}

	public static int Modifier(Utilisateur user) {
		int keyUserUpdate = -1;
		Utilisateur userbyUserName = getUserByUserName(user.getUserName());
		if (userbyUserName != null) {
			keyUserUpdate = UtilisateurManager.Update(user);
		}
		service.ConnectionBDD.closeConnection();
		return keyUserUpdate;
	}

	public static Utilisateur VerifierConnexion(Utilisateur utilsateur) {
		Utilisateur user = null;
		utilsateur.hashPassword();
		user = UtilisateurManager.getUserLogIn(utilsateur);
		if (user != null) {
			user.changeTokenIdentifaction();
			UtilisateurManager.UpdateToken(user);
			user.setEtablissement(EtablissementAction.getById(user.getEtablissement().getId()));
			user.setRole(RoleManager.getById(user.getRole().getId()));
		}
		service.ConnectionBDD.closeConnection();
		return user;
	}
	
	public static ArrayList<Utilisateur>displayAllUser(){
		ArrayList<Utilisateur> allUser=null;
		allUser=UtilisateurManager.getAll();
		ConnectionBDD.closeConnection();
		return allUser;
	}
	public static ArrayList<Utilisateur> afficherParIdEtab(int idEtab){
		return UtilisateurManager.getUserByIdEtab(idEtab);
	}
	
	public static int delete(Utilisateur user){
		return UtilisateurManager.delete(user);
	}

	public static ArrayList<Utilisateur> getGerantBoulangerByEtab (Etablissement etablissement){
		ArrayList<Utilisateur> retour = new ArrayList<Utilisateur>();
		int idEtablissement = etablissement.getId();
		retour.add(UtilisateurManager.getGerantByIdEtab(idEtablissement));
		retour.add(UtilisateurManager.getChefBoulangerByIdEtab(idEtablissement));
		service.ConnectionBDD.closeConnection();
		return retour;
	}

	public static int modifierpassword(Utilisateur user,String password){
		int retour=-1;
		Utilisateur utilisateur= VerifierConnexion(user);
		if(utilisateur!=null){
			retour= UtilisateurManager.UpdatePassword(user, password);
		}
		service.ConnectionBDD.closeConnection();
		return retour;
	}
}
