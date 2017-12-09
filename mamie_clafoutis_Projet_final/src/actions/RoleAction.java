package actions;

import java.util.ArrayList;

import entities.Role;
import manager.RoleManager;

public class RoleAction {

	
	static public Role getById(int id){
		Role role=null;
		role=RoleManager.getById(id);
		return role;
	}
	static public ArrayList<Role>getByIdEtab(int idEtab){
		return RoleManager.getByIdEtab(idEtab);
	}
}
