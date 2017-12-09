package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Adresse;
import service.ConnectionBDD;

public class AdresseManager {
	static private String queryById = "select * from adresse where id=?";
	static private String insertQuery = "insert into adresse ( numero_rue, nom_rue, ville, province, code_postal, pays)"
			+ "values (?,?,?,?,?,?)";

	static public Adresse getById(int id) {
		Adresse adresse = null;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				if (rs.next()) {
					adresse = new Adresse(id);
					adresse.setNumero_rue(rs.getInt("numero_rue"));
					adresse.setNom_rue(rs.getString("nom_rue"));
					adresse.setVille(rs.getString("ville"));
					adresse.setProvince(rs.getString("province"));
					adresse.setCode_postal(rs.getString("code_postal"));
					adresse.setPays(rs.getString("pays"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adresse;
	}

	static public int insert(Adresse adresse) {
		int generatedKey = -1;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(insertQuery);
			ps.setInt(1, adresse.getNumero_rue());
			ps.setString(2, adresse.getNom_rue());
			ps.setString(3, adresse.getVille());
			ps.setString(4, adresse.getProvince());
			ps.setString(5, adresse.getCode_postal());
			ps.setString(6, adresse.getPays());
			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next())
					generatedKey = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return generatedKey;
	}

}
