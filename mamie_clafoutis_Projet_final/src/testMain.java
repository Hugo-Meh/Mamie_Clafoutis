import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import actions.CommandeAction;
import actions.LigneDeCommandeAction;
import actions.PatteAction;
import entities.Commande;
import entities.LigneDeCommande;
import entities.Patte;
import manager.PattesManager;

public class testMain {

	public static void main(String[] args) {
		Gson gson = new Gson();
//	ArrayList<Commande>cl=CommandeAction.displayAll();
//		for(Commande c:cl){
//			System.out.println(gson.toJson(c.getUtilisateur().getEtablissement()));
//			
//		}
		
		ArrayList<Patte>p=PatteAction.displayAll();
		Patte p1= PattesManager.getByIdProduit(1);
		System.out.println(gson.toJson(p1));
//		for(Patte pp:p){
//			System.out.println(gson.toJson(pp));
//		}
	Commande c= new Commande(5);
		ArrayList<LigneDeCommande>lc=LigneDeCommandeAction.displayAllbyCommandeId(c)
	}
}
