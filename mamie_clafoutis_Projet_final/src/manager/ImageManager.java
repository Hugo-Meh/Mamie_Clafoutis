package manager;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Image;
import service.C;
import service.ConnectionBDD;

public class ImageManager {

	private static String queryByIdProduct="select * from src_image where produit_id=? ";
	private static String insertImage="insert into src_image (formatweb, produit_id) values (?,?)";
	
	
	public static ArrayList<Image>getByIdproduit(int id){
		ArrayList<Image> imageList= null;
	
		try {
			PreparedStatement ps= ConnectionBDD.getPs(queryByIdProduct);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.isBeforeFirst()){
				imageList= new ArrayList<>();
				while(rs.next()){
					Image img= new Image();
					img.setId_produit(id);
					img.setId(rs.getInt("id"));
					img.setSrc_img_norm(rs.getString("src_image_taille_normal"));
					img.setSrc_img_mobile(C.Image.srcPath+rs.getString("src_image_mobile"));
					img.setFormatWeb(rs.getString("formatweb"));
					imageList.add(img);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return imageList;
	}
	
	public static int insert(String base,int produitId){
		int generatedKey=-1;
		
		
		try {
			PreparedStatement ps= ConnectionBDD.getPs(insertImage);
			ps.setString(1, base);
			ps.setInt(2, produitId);
			if(ps.executeUpdate()>0){
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
