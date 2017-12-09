package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import entities.Commande;
import entities.Utilisateur;
import service.C;
import service.ConnectionBDD;

public class CommandeManager {
	
	private static String queryInsertCommande = "insert into "+C.Commande.nomTable+" ("+C.Commande.utilisateur_id+" ,"+C.Commande.date+" ,"+C.Commande.valide+") values (?,?,?)";
	private static String queryGetPendingByUtilisateurId = "select * from "+C.Commande.nomTable+" where "+C.Commande.utilisateur_id+"=? and "+C.Commande.valide+"=false";
	private static String queryGetAllPending = "select * from "+C.Commande.nomTable+" where "+C.Commande.valide+"=true order by date";
	private static String queryGetByIdEtab = "select C.id, C.utilisateur_id, C.date, C.valide from "+C.Commande.nomTable+" C inner join "+C.Utilisateur.nomTable +" U on U."+C.Utilisateur.id+"=C."+C.Commande.utilisateur_id+" where C."+C.Commande.valide+"=true and "+C.Utilisateur.etablissement_id +"=? order by C.date";
	
	static public int InsertCommande (Commande commande){
		int retour = -1;
		
		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryInsertCommande);
			ps.setInt(1, commande.getUtilisateur().getId());
			ps.setLong(2, commande.getDate().getTime());
			ps.setBoolean(3, commande.isValide());
			if (ps.executeUpdate() > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next())
					retour = rs.getInt(1);
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retour;
		
	}
	
	static public ArrayList<Commande> GetAllPending(){
		ArrayList<Commande> retour = null;
		
		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryGetAllPending);
			ResultSet rs;
			rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				 retour = new ArrayList<Commande>();
				while (rs.next()) {
					Commande commande = new Commande();
					commande.setId(rs.getInt(C.Commande.id));
					commande.setUtilisateur(UtilisateurManager.getById(rs.getInt(C.Commande.utilisateur_id)));
					commande.setDate(new Date(rs.getLong(C.Commande.date)));
					commande.setValide(rs.getBoolean(C.Commande.valide));
					retour.add(commande);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return retour;	
	}
	
	static public ArrayList<Commande> GetAllPendingByUser(Utilisateur utilisateur){
		ArrayList<Commande> retour = new ArrayList<Commande>();
		
		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryGetPendingByUtilisateurId);
			ps.setInt(1, utilisateur.getId());
			ResultSet rs;
			rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				if (rs.next()) {
					Commande commande = new Commande();
					commande.setId(rs.getInt(C.Commande.id));
					commande.setUtilisateur(UtilisateurManager.getById(rs.getInt(C.Commande.utilisateur_id)));
					commande.setDate(new Date(rs.getLong(C.Commande.date)));
					commande.setValide(rs.getBoolean(C.Commande.valide));
					retour.add(commande);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return retour;	
	}
	static public ArrayList<Commande> GetByEtabId(int EtabId){
		ArrayList<Commande> retour = null;
		
		try {
			PreparedStatement ps = ConnectionBDD.getPs(queryGetByIdEtab);
			ps.setInt(1, EtabId);
			ResultSet rs;
			rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				 retour = new ArrayList<Commande>();
				while (rs.next()) {
					Commande commande = new Commande();
					commande.setId(rs.getInt(C.Commande.id));
					commande.setUtilisateur(UtilisateurManager.getById(rs.getInt(C.Commande.utilisateur_id)));
					commande.setDate(new Date(rs.getLong(C.Commande.date)));
					commande.setValide(rs.getBoolean(C.Commande.valide));
					retour.add(commande);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retour;	
	}
		
	
}
