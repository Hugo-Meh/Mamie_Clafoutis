package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import entities.Commande;
import entities.LigneDeCommande;
import entities.Patte;
import entities.Produit;
import entities.Unite;
import service.C;
import service.ConnectionBDD;

public class LigneDeCommandeManager {
	
	private static String queryInsertLigneDeCommande = "insert into "+C.LigneDeCommande.nomTable+" ("+C.LigneDeCommande.commande_id+" ,"+C.LigneDeCommande.quantite+" ,"+C.LigneDeCommande.patte_id+") values (?,?,?)";
	private static String queryGetAllByCommandeId = "select * from "+C.LigneDeCommande.nomTable+" where "+C.LigneDeCommande.commande_id+"=?";
	private static String queryConversionPatte= "select * from "+C.Produit.nomTable+" inner join "+C.produit_patte.nomTable+" on "+C.Produit.nomTable+"."+C.Produit.id+" = "+C.produit_patte.id_produit+" inner join "+C.Patte.nomTable+" on "+C.produit_patte.id_patte+" = "+C.Patte.nomTable+"."+C.Patte.id+" where "+C.Produit.nomTable+"."+C.Produit.id+"=?";
	private static String querybyId= " select * from ligne_de_commande where commande_id=? and patte_id=?";
	
	private static String update="update ligne_de_commande set quantite=quantite+? where commande_id=? and patte_id=?";
	
	public static int InsertLigneDeCommande(ArrayList<LigneDeCommande> lignedecommandeList){
		int retour = -1;
		for(LigneDeCommande ligne : lignedecommandeList){
			try {
				PreparedStatement ps = ConnectionBDD.getPs(queryInsertLigneDeCommande);
				ps.setInt(1, ligne.getCommande().getId());
				ps.setFloat(2, ligne.getQuantite());
				ps.setInt(3, ligne.getPatte().getId());
				
				System.out.println(ligne.getPatte().getId());
				if (ps.executeUpdate() > 0) {
					ResultSet rs = ps.getGeneratedKeys();
					if (rs.next())
						retour = rs.getInt(1);
				}

			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}
	
	public static ArrayList<LigneDeCommande> ConversionLigneDeCommande (ArrayList<Produit> listProduits, Commande commande){
		ArrayList<LigneDeCommande> retour = new ArrayList<LigneDeCommande>();
		
		for (Produit produit : listProduits){
		
			Patte patte = new Patte ();
			LigneDeCommande lignedecommande = new LigneDeCommande();
			
			try {
				PreparedStatement ps = ConnectionBDD.getPs(queryConversionPatte);
				ps.setInt(1, produit.getId());
				ResultSet rs;
				rs = ps.executeQuery();
				if (rs.isBeforeFirst()) {
					if (rs.next()) {
						patte.setId(rs.getInt(C.Patte.nomTable+"."+C.Patte.id));
						patte.setNom(rs.getString(C.Patte.nom));
						patte.setUnite(UniteManager.getById(rs.getInt( C.Patte.unite_id)));
						patte.setPoid(rs.getFloat(C.produit_patte.poid));
						
						boolean trouve = false;
						if (!retour.isEmpty()){
			
							for(LigneDeCommande ligne : retour){
								if(ligne.getPatte().getId() == patte.getId()){
									System.out.println(ligne.getQuantite()+patte.getPoid()*produit.getQuantite());
									ligne.setQuantite(ligne.getQuantite()+patte.getPoid()*produit.getQuantite());
									trouve = true;
									break;
									
								}
							}
						}
						if(!trouve) {
							lignedecommande.setPatte(patte);
							lignedecommande.setCommande(commande);
							lignedecommande.setUnite(patte.getUnite());
							System.out.println(patte.getPoid()*produit.getQuantite());
							lignedecommande.setQuantite(patte.getPoid()*produit.getQuantite());
							
							retour.add(lignedecommande);
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return retour;
	}
	
	public static LigneDeCommande getById(int commandeId,int patteId){
		LigneDeCommande lc=null;
		
		try {
			PreparedStatement ps= ConnectionBDD.getPs(querybyId);
			ps.setInt(1, commandeId);
			ps.setInt(2, patteId);
			ResultSet rs= ps.executeQuery();
			if(rs.isBeforeFirst()){
				if(rs.next()){
					lc= new LigneDeCommande();
					lc.setCommande(new Commande(commandeId));
					lc.setPatte(new Patte(patteId));
					lc.setQuantite(rs.getFloat("quantite"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lc;
	}
	
	//version momo
	public static int  insert(int commandeId,Patte pate){
		int retour=-1;
		
		try {
			PreparedStatement ps= ConnectionBDD.getPs(queryInsertLigneDeCommande);
			ps.setInt(1, commandeId);
			ps.setFloat(2, pate.getPoid());
			ps.setInt(3, pate.getId());
			if(ps.executeUpdate()>0){
				ResultSet rs=ps.getGeneratedKeys();
				if(rs.next()){
					retour=rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retour;
	}
	
	public static boolean update(int commandeId,Patte pate){
		boolean retour =false;
		
		try {
			PreparedStatement ps=ConnectionBDD.getPs(update);
			ps.setFloat(1, pate.getPoid());
			ps.setInt(2, commandeId);
			ps.setInt(3, pate.getId());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionBDD.closeConnection();
		}
		
		return retour;
	}
	
	public static ArrayList<LigneDeCommande> getAllByCommandeId(Commande commande){
		ArrayList<LigneDeCommande> retour = new ArrayList<LigneDeCommande>();
		
		try {
			PreparedStatement ps= ConnectionBDD.getPs(queryGetAllByCommandeId);
			ps.setInt(1, commande.getId());
			ResultSet rs= ps.executeQuery();
			if(rs.isBeforeFirst()){
				if(rs.next()){
					LigneDeCommande ligne = new LigneDeCommande();
					ligne.setCommande(commande);
					ligne.setPatte(PattesManager.getById(rs.getInt(C.LigneDeCommande.patte_id)));
					ligne.setQuantite(rs.getFloat(C.LigneDeCommande.quantite));
					retour.add(ligne);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return retour;
	}
}
