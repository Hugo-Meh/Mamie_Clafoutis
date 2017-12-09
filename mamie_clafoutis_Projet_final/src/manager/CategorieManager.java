package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Categorie;
import service.C;
import service.ConnectionBDD;

public class CategorieManager {

	static private String queryGetAll = "select * from " + C.Categorie.nomTable;
	static private String queryGetById = "select * from " + C.Categorie.nomTable + " where id = ?";
	static private String queryInsert = "";

	// recup�rer un ArrayList de toute les categories
	static public ArrayList<Categorie> getAll() {
		ArrayList<Categorie> retour = new ArrayList<Categorie>();

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryGetAll);
			ResultSet rs;
			rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					Categorie categorie = new Categorie();

					categorie.setId(rs.getInt(C.Categorie.id));
					categorie.setDenomination(rs.getString(C.Categorie.denomination));
					retour.add(categorie);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retour;
	}

	// recup�rer une categorie grace a son id
	static public Categorie GetById(int id) {

		Categorie retour = new Categorie();

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryGetById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				if (rs.next()) {
					retour.setId(id);
					retour.setDenomination(rs.getString(C.Categorie.denomination));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return retour;
	}
}
