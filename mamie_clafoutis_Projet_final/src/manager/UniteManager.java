package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.Unite;
import service.C;
import service.ConnectionBDD;

public class UniteManager {
	static private String queryGetById = "select * from " + C.Unite.nomTable + " where id = ?";
	static private String queryGetAll = "select * from " + C.Unite.nomTable;

	// recup�rer une Unite grace a son id
	static public Unite getById(int id) {

		Unite retour = new Unite();

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryGetById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				if (rs.next()) {
					retour.setId(id);
					retour.setDenomination(rs.getString(C.Unite.denomination));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retour;
	}

	// recup�rer une Unite grace a son id
	static public ArrayList<Unite> getAll() {

		ArrayList<Unite> uniteList = null;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryGetAll);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				uniteList = new ArrayList<>();
				
				while (rs.next()) {
					Unite unite = new Unite();
					unite.setId(rs.getInt("id"));
					unite.setDenomination(rs.getString(C.Unite.denomination));
					uniteList.add(unite);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uniteList;
	}

}
