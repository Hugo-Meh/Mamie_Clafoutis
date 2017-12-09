package actions;

import java.util.ArrayList;

import entities.Unite;
import manager.UniteManager;

public class UniteAction {
	
	public static Unite getById(int id){
		return UniteManager.getById(id);
	}
	
	public static ArrayList<Unite> getAll(){
		return UniteManager.getAll();
	}

}
