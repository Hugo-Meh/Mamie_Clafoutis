package actions;

import java.util.ArrayList;

import entities.Role;
import manager.ProduitManager;
import manager.RoleManager;

public class RoleAction {

	
	static public Role getById(int id){
		Role role=null;
		role=RoleManager.getById(id);
		service.ConnectionBDD.closeConnection();
		return role;
	}
	static public ArrayList<Role>getByIdEtab(int idEtab){
		ArrayList<Role> retour = RoleManager.getByIdEtab(idEtab);
		service.ConnectionBDD.closeConnection();
		return retour;
	}
}
