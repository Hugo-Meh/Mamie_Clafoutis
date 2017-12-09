package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.ProduitPatte;
import service.ConnectionBDD;

public class ProduitPatteManager {
	private static String insertAssociationProduitPatte="insert into produit_patte (poid,produit_id,patte_id) values (?,?,?)";
	private static String queryByIdProduit="select * from produit_patte where produit_id=?";
	
	public static int insertAssiciationProduitPatte(float poid,int produitId,int patteId){
		int generatedkey=0;
	
		try {
			PreparedStatement ps=ConnectionBDD.getPs(insertAssociationProduitPatte);
			ps.setFloat(1, poid);
			ps.setInt(2, produitId);
			ps.setInt(3, patteId);
			if(ps.executeUpdate()>0){
				ResultSet rs=ps.getGeneratedKeys();
				if(rs.next()){
					generatedkey=rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return generatedkey;
	}

	
	public static ProduitPatte getByIdproduit(int produitId){
		ProduitPatte produitPatte=null;
	
		try {
			PreparedStatement ps=ConnectionBDD.getPs(queryByIdProduit);
			ps.setInt(1, produitId);
			ResultSet rs=ps.executeQuery();
			if(rs.isBeforeFirst()){
				if(rs.next()){
					produitPatte= new ProduitPatte();
					produitPatte.setPoid(rs.getFloat("poid"));
					produitPatte.setProduit_id(rs.getInt("produit_id"));
					produitPatte.setPatte_id(rs.getInt("patte_id"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return produitPatte;
		
	}
}
