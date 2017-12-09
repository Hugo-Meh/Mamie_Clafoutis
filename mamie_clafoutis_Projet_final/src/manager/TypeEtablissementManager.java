package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Type_Etablissement;
import service.ConnectionBDD;

public class TypeEtablissementManager {
	static private String queryById = "select * from type where id=?";
	static private String queryAll = "select * from type";

	static public Type_Etablissement getById(int id) {
		Type_Etablissement type_Etablissement = null;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				if (rs.next()) {
					type_Etablissement = new Type_Etablissement(id);
					type_Etablissement.setType(rs.getString("denomination"));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return type_Etablissement;
	}

	static public ArrayList<Type_Etablissement> getAll() {
		ArrayList<Type_Etablissement> typeList = null;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryAll);

			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				typeList = new ArrayList<>();
				while (rs.next()) {

					Type_Etablissement type_Etablissement = new Type_Etablissement(rs.getInt("id"));
					type_Etablissement.setType(rs.getString("denomination"));
					typeList.add(type_Etablissement);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return typeList;
	}

}
