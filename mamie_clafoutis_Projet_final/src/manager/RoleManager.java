package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Role;
import service.ConnectionBDD;

public class RoleManager {
	static private String queryById="select * from role where id=?";
	static private String queryByEtab="select * from role R inner join role_etablissement RE on "
			+ "  R.id=RE.role_id inner join type T on T.id=RE.type_id where T.id=?";
	
	static public Role getById(int id){
		Role role=null;
		
		
		try {
			PreparedStatement ps=ConnectionBDD.getPs(queryById);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.isBeforeFirst()){
				if(rs.next()){
					role= new Role(id);
					role.setTitre(rs.getString("denomination"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}
	public static ArrayList<Role>getByIdEtab(int idEtab){
		ArrayList<Role> roleList=null;
		

		try {
			PreparedStatement ps=ConnectionBDD.getPs(queryByEtab);
			ps.setInt(1, idEtab);
			ResultSet rs=ps.executeQuery();
			if(rs.isBeforeFirst()){
				roleList= new ArrayList<>();
				while(rs.next()){
					Role role= new Role();
					role.setId(rs.getInt("id"));
					role.setTitre(rs.getString("denomination"));
					roleList.add(role);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleList;
	}

}
