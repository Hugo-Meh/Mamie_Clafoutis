package actions;

import java.util.ArrayList;

import entities.Etablissement;
import entities.Utilisateur;
import manager.EtablissementManager;
import service.ConnectionBDD;

public class EtablissementAction {

	static public Etablissement getById(int id) {
		Etablissement etablissement = null;
		etablissement = EtablissementManager.getById(id);
		if (etablissement != null) {
			etablissement.setTypeEtablissement(
					Type_Etablissement_Action.getById(etablissement.getTypeEtablissement().getId()));
			etablissement.setAdresse(AdresseAction.getById(etablissement.getAdresse().getId()));
			
		}
		ConnectionBDD.closeConnection();
		return etablissement;

	}

	static public ArrayList<Etablissement> getAll() {
		ArrayList<Etablissement> etabList = EtablissementManager.getAll();

		if (etabList != null) {
			for (Etablissement etab : etabList) {
				etab.setAdresse(AdresseAction.getById(etab.getAdresse().getId()));
				etab.setTypeEtablissement(Type_Etablissement_Action.getById(etab.getTypeEtablissement().getId()));
			}
			ConnectionBDD.closeConnection();
		}

		return etabList;
	}

	static public int insert(Etablissement etab) {
		int generatedKey = -2;
		if (etab != null) {
			int nouvelleCle = AdresseAction.insert(etab.getAdresse());
			if (nouvelleCle > 0) {
				etab.getAdresse().setId(nouvelleCle);
				generatedKey = EtablissementManager.insert(etab);
			}
		}
		service.ConnectionBDD.closeConnection();
		return generatedKey;
	}

	public static int update(Etablissement etab) {
		int generatedKey = -2;
		if (etab != null) {
			generatedKey = EtablissementManager.update(etab);
		}
		service.ConnectionBDD.closeConnection();
		return generatedKey;

	}

	public static int toggleVisibility(boolean switcher, int idEtab) {

		int generatedKey = -2;

		generatedKey = EtablissementManager.toggleVisibility(switcher, idEtab);
		service.ConnectionBDD.closeConnection();
		return generatedKey;

	}
	
}
