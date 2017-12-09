package actions;

import java.util.ArrayList;

import entities.Type_Etablissement;
import manager.TypeEtablissementManager;

public class Type_Etablissement_Action {
	static public Type_Etablissement getById(int id) {
		Type_Etablissement type_Etablissement = TypeEtablissementManager.getById(id);
		return type_Etablissement;
	}
	
	
	static public ArrayList<Type_Etablissement>showAll(){
		ArrayList<Type_Etablissement> typeList=null;
		typeList=TypeEtablissementManager.getAll();
		
		return typeList;
	}
}
