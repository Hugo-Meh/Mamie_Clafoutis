package actions;

import entities.Adresse;
import manager.AdresseManager;

public class AdresseAction{
	
	static public Adresse getById(int id){
		Adresse adresse=null;
		adresse=AdresseManager.getById(id);
		return adresse;
	}
	
	static public int insert(Adresse adr){
		int generatedKey=AdresseManager.insert(adr);
		return generatedKey;
	}
}
