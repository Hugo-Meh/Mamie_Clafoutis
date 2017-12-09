package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import actions.UniteAction;
import entities.Ingredient;
import service.C;
import service.ConnectionBDD;

public class IngredientManager {
	private static String queryAll = "select * from ingredient";
	private static String quereyByIdProduit = "select I.id as id,LI.quantite as quantite,I.unite_id,I.denomination as denomination "
			+ "from ingredient I inner join ligne_ingredient LI on I.id=LI.produit_id where LI.produit_id=?";
	private static String queryByIdPatte="select I.id as id ,IP.quantite as quantite ,I.unite_id , I.denomination as denomination  "
			+ "from  ingredient I inner join ingredient_patte IP on I.id=IP.ingredient_id where IP.patte_id=? ";
	
	public static ArrayList<Ingredient> getAll() {
		ArrayList<Ingredient> ingredientList = null;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryAll);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				ingredientList = new ArrayList<>();
				while (rs.next()) {
					Ingredient ingredient = new Ingredient();
					ingredient.setId(rs.getInt("id"));
					ingredient.setDenomination(rs.getString("denomination"));
					ingredient.setQuantite(rs.getFloat("quantite"));
					ingredient.setUnite(UniteAction.getById(rs.getInt("unite_id")));
					ingredientList.add(ingredient);

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ingredientList;
	}

	public static ArrayList<Ingredient> getByIdProduit(int idProduit) {
		ArrayList<Ingredient> ingredientList = null;

		try {
			PreparedStatement ps = ConnectionBDD.getPs(quereyByIdProduit);
			ps.setInt(1, idProduit);
			ResultSet rs=ps.executeQuery();
			if(rs.isBeforeFirst()){
				ingredientList= new ArrayList<>();
				while(rs.next()){
					Ingredient ingredient= new Ingredient();
					ingredient.setId(rs.getInt(C.Ingredient.id));
					ingredient.setDenomination(rs.getString("denomination"));
					ingredient.setQuantite(rs.getFloat("quantite"));
					ingredient.setUnite(UniteAction.getById(rs.getInt("unite_id")));
					System.out.println("ingredient patte"+ingredient.getDenomination());
					ingredientList.add(ingredient);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ingredientList;
	}
	
	public static ArrayList<Ingredient> getByIdPatte(int idPatte){
		ArrayList<Ingredient>ingredientList=null;
		
		try {
			PreparedStatement ps= ConnectionBDD.getPs(queryByIdPatte);
			ps.setInt(1, idPatte);
			ResultSet rs=ps.executeQuery();
			if(rs.isBeforeFirst()){
				ingredientList= new ArrayList<>();
				while(rs.next()){
					Ingredient ingredient= new Ingredient();
					ingredient.setId(rs.getInt(C.Ingredient.id));
					ingredient.setDenomination(rs.getString(C.Ingredient.denomination));
					ingredient.setQuantite(rs.getFloat("quantite"));
					ingredient.setUnite(UniteAction.getById(rs.getInt("unite_id")));
					ingredientList.add(ingredient);
					System.out.println("ingredient patte "+ingredient.getDenomination());
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ingredientList;
	}
}
