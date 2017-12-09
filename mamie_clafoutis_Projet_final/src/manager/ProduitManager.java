package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import actions.UniteAction;
import entities.Categorie;
import entities.Produit;

import service.C;
import service.ConnectionBDD;

public class ProduitManager {

	static private String queryGetAll = "select * from " + C.Produit.nomTable + " where " + C.Produit.estvisible
			+ "=true";
	static private String queryGetById = "select * from " + C.Produit.nomTable + " where id=?" + " and "
			+ C.Produit.estvisible + "=true";
	static private String queryGetByCategorie = "select * from " + C.Produit.nomTable + " where categorie_id = ?"
			+ " and " + C.Produit.estvisible + "=true";;
	static private String queryinsert = "insert into produit (" + C.Produit.nom + ", " + C.Produit.categorie_id + ", "
			+ C.Produit.description + ", " + C.Produit.prix + ", "  + C.Produit.reference
			+ ", " + C.Produit.poid + ", " + C.Produit.unite_id + ") values (?,?,?,?,?,?,?)";
	static private String queryToggleVisibility = "update " + C.Produit.nomTable + " set " + C.Produit.estvisible + "=?"
			+ " where " + C.Produit.id + "=?";

	static private String queryGetAllInvisible = "select * from " + C.Produit.nomTable + " where "
			+ C.Produit.estvisible + "=false";

	static public ArrayList<Produit> getAll() {
		ArrayList<Produit> retour = new ArrayList<Produit>();

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryGetAll);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					Produit produit = new Produit();
					produit.setId(rs.getInt(C.Produit.id));
					produit.setImageList(ImageManager.getByIdproduit(produit.getId()));
					produit.setNom(rs.getString(C.Produit.nom));
					produit.setCategorie(CategorieManager.GetById(rs.getInt(C.Produit.categorie_id)));
					produit.setDescription(rs.getString(C.Produit.description));
					produit.setPrix(rs.getFloat(C.Produit.prix));
					produit.setEstVisible(rs.getBoolean(C.Produit.estvisible));
					produit.setReference(rs.getString(C.Produit.reference));
					produit.setPoid(rs.getFloat(C.Produit.poid));
					produit.setUnite(UniteManager.getById(rs.getInt(C.Produit.unite_id)));
					retour.add(produit);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retour;

	}

	static public Produit GetById(int id) {
		Produit retour = new Produit();

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryGetById);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				if (rs.next()) {
					retour.setId(id);
					retour.setId(rs.getInt(C.Produit.id));
					retour.setNom(rs.getString(C.Produit.nom));
					retour.setCategorie(CategorieManager.GetById(rs.getInt(C.Produit.categorie_id)));
					retour.setDescription(rs.getString(C.Produit.description));
					retour.setPrix(rs.getFloat(C.Produit.prix));
					retour.setEstVisible(rs.getBoolean(C.Produit.estvisible));
					retour.setReference(rs.getString(C.Produit.reference));
					retour.setPoid(rs.getFloat(C.Produit.poid));
					retour.setUnite(UniteAction.getById(rs.getInt(C.Produit.unite_id)));
					retour.setIngredientList(IngredientManager.getByIdProduit(retour.getId()));
					retour.setPatte(PattesManager.getByIdProduit(retour.getId()));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retour;
	}

	static public ArrayList<Produit> getByCategorie(int id) {
		ArrayList<Produit> retour = new ArrayList<Produit>();
		;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryGetByCategorie);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					Produit produit = new Produit();
					produit.setId(rs.getInt(C.Produit.id));
					produit.setImageList(ImageManager.getByIdproduit(produit.getId()));
					produit.setNom(rs.getString(C.Produit.nom));

					Categorie categorie = new Categorie();
					// categorie.setId(rs.getInt(C.Produit.categorie_id));
					// produit.setCategorie(categorie);
					produit.setCategorie(CategorieManager.GetById(rs.getInt(C.Produit.categorie_id)));
					produit.setDescription(rs.getString(C.Produit.description));
					produit.setPrix(rs.getFloat(C.Produit.prix));
					produit.setEstVisible(rs.getBoolean(C.Produit.estvisible));
					produit.setReference(rs.getString(C.Produit.reference));
					produit.setPoid(rs.getFloat(C.Produit.poid));
					produit.setUnite(UniteAction.getById(rs.getInt(C.Produit.unite_id)));

					retour.add(produit);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retour;

	}

	// voir si on veut faire plusieur query insert ou update.
	static public int Insert(Produit produit) {
		int retour = -1;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryinsert);
			ps.setString(1, produit.getNom());
			ps.setInt(2, produit.getCategorie().getId());
			ps.setString(3, produit.getDescription());
			ps.setFloat(4, produit.getPrix());
		
			ps.setString(5,"ref");
			ps.setFloat(6, produit.getPoid());
			ps.setInt(7, produit.getUnite().getId());

			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next())
					retour = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionBDD.closeConnection();
		}

		return retour;
	}

	public static int toggleVisibility(boolean switchVisibility, int idProduit) {
		int retour = -1;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryToggleVisibility);
			ps.setBoolean(1, switchVisibility);
			ps.setInt(2, idProduit);
			retour = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionBDD.closeConnection();
		}

		return retour;
	}

	public static ArrayList<Produit> getProduitCache() {
		ArrayList<Produit> produitsList = null;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryGetAllInvisible);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				produitsList = new ArrayList<>();
				while (rs.next()) {
					Produit produit = new Produit();
					produit.setId(rs.getInt(C.Produit.id));
					produit.setImageList(ImageManager.getByIdproduit(produit.getId()));
					produit.setNom(rs.getString(C.Produit.nom));
					produit.setCategorie(CategorieManager.GetById(rs.getInt(C.Produit.categorie_id)));
					produit.setDescription(rs.getString(C.Produit.description));
					produit.setPrix(rs.getFloat(C.Produit.prix));
					produit.setEstVisible(rs.getBoolean(C.Produit.estvisible));
					produit.setReference(rs.getString(C.Produit.reference));
					produit.setPoid(rs.getFloat(C.Produit.poid));
					produit.setUnite(UniteManager.getById(rs.getInt(C.Produit.unite_id)));
					produitsList.add(produit);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produitsList;
	}
}
