package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.ConnectionBDD;

public class LigneIngredientManager {
	private static String insertAssociationIngredientProduit="insert into ligne_ingredient (ingredient_id,produit_id,quantite) values (?,?,?)";
	
	public static int insertLigneingredientProduit(int ingredientId,int produitId,float quantite){
		int generatedKey=0;
		
		try {
			PreparedStatement ps=ConnectionBDD.getPs(insertAssociationIngredientProduit);
			ps.setInt(1, ingredientId);
			ps.setInt(2, produitId);
			ps.setFloat(3, quantite);
			if(ps.executeUpdate()>0){
				ResultSet rs=ps.getGeneratedKeys();
				if(rs.next()){
					generatedKey=rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionBDD.closeConnection();
		}
		
		
		
		return generatedKey;
	}
	

}
