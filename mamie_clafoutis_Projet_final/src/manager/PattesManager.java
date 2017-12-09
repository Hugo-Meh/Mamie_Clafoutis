package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import actions.UniteAction;
import entities.Patte;
import service.ConnectionBDD;

public class PattesManager {
	private static String queryAll = "select * from patte";
	private static String queryByIdProduit="select * from patte P inner join produit_patte PP on P.id=PP.produit_id where PP.produit_id=?";
	private static String queryById = "select * from patte where id=?";
	
	public static ArrayList<Patte> getAll() {
		ArrayList<Patte> patteList = null;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryAll);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				patteList = new ArrayList<>();
				while (rs.next()) {
					Patte patte = new Patte();
					patte.setId(rs.getInt("id"));
					patte.setNom(rs.getString("nom"));
					patte.setIngredientList(IngredientManager.getByIdPatte(patte.getId()));
					patte.setUnite(UniteAction.getById(rs.getInt("unite_id")));
					patteList.add(patte);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return patteList;
	}
	public static Patte getByIdProduit(int idProduit){
		Patte patte=null;
		
		try {
			PreparedStatement ps= ConnectionBDD.getPs(queryByIdProduit);
			ps.setInt(1, idProduit);
			ResultSet rs=ps.executeQuery();
			if(rs.isBeforeFirst()){
				if(rs.next()){
					patte= new Patte();
					patte.setId(rs.getInt("id"));
					patte.setNom(rs.getString("nom"));
					patte.setUnite(UniteAction.getById(rs.getInt("unite_id")));
					//patte.setPoid(rs.getFloat("poid"));
					patte.setIngredientList(IngredientManager.getByIdPatte(patte.getId()));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patte;
	}
	
	public static Patte getById(int id){
Patte patte=null;
		
		try {
			PreparedStatement ps= ConnectionBDD.getPs(queryById);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.isBeforeFirst()){
				if(rs.next()){
					patte= new Patte();
					patte.setId(rs.getInt("id"));
					patte.setNom(rs.getString("nom"));
					patte.setUnite(UniteAction.getById(rs.getInt("unite_id")));
					//patte.setPoid(rs.getFloat("poid"));
					patte.setIngredientList(IngredientManager.getByIdPatte(patte.getId()));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patte;
	}
}