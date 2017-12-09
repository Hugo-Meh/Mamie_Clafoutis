package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Adresse;
import entities.Etablissement;
import entities.Type_Etablissement;
import service.C;
import service.ConnectionBDD;

public class EtablissementManager {
	static public String queryById = "select * from etablissement where id=? and isVisible=true";
	public static String queryAll = "select * from etablissement where isVisible=true";
	public static String insertQuery = " insert into etablissement (name, tel, type_id, Adresse_id) values(?,?,?,?)";
	public static String queryUpdate = "update etablissement set tel=? where id = ?";
	public static String queryTogglevisibility = "update etablissement set isVisible=? where id = ?";
	//public static String queryGetGerantbyIdEtab = "select * from "+C.Etablissement.nomTable+" inner join "+C.

	static public Etablissement getById(int id) {
		Etablissement etablissement = null;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				if (rs.next()) {
					etablissement = new Etablissement(id);
					etablissement.setName(rs.getString("name"));
					etablissement.setTel(rs.getString("tel"));
					etablissement.setTypeEtablissement(new Type_Etablissement(rs.getInt("type_id")));
					etablissement.setAdresse(new Adresse(rs.getInt("Adresse_id")));
					etablissement.setVisible(rs.getBoolean("isVisible"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return etablissement;
	}

	static public ArrayList<Etablissement> getAll() {
		ArrayList<Etablissement> etabList = null;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryAll);

			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				etabList = new ArrayList<>();
				while (rs.next()) {
					Etablissement etablissement = new Etablissement();
					etablissement.setId(rs.getInt("id"));
					etablissement.setName(rs.getString("name"));
					etablissement.setTel(rs.getString("tel"));
					etablissement.setTypeEtablissement(new Type_Etablissement(rs.getInt("type_id")));
					etablissement.setAdresse(new Adresse(rs.getInt("Adresse_id")));
					etablissement.setVisible(rs.getBoolean("isVisible"));
					System.out.println("typ ->" + etablissement.getTypeEtablissement().getId());
					System.out.println("adresse ->" + etablissement.getAdresse().getId());
					etabList.add(etablissement);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return etabList;
	}

	// name, tel, type_id, Adresse_id
	public static int insert(Etablissement etab) {
		int generatedKey = -1;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(insertQuery);
			ps.setString(1, etab.getName());
			ps.setString(2, etab.getTel());
			ps.setInt(3, etab.getTypeEtablissement().getId());
			ps.setInt(4, etab.getAdresse().getId());
			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next())
					generatedKey = rs.getInt(1);
				System.out.println(" id de etab inseree" + generatedKey);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return generatedKey;
	}

	public static int update(Etablissement etab) {
		int generatedKey = -2;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryUpdate);
			ps.setString(1, etab.getTel());
			ps.setInt(2, etab.getId());
			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				generatedKey = rs.getInt("id");
				System.out.println(" id de etab inseree" + generatedKey);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return generatedKey;
	}

	public static int toggleVisibility(boolean switcher, int idEtab) {
		int generatedKey = -2;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryUpdate);
			ps.setBoolean(1, switcher);
			;
			ps.setInt(2, idEtab);
			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				generatedKey = rs.getInt("id");
				System.out.println(" id de etab inseree" + generatedKey);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return generatedKey;
	}
}
