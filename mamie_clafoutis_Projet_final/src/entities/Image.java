package entities;

import java.io.Serializable;
import java.sql.Blob;

public class Image implements Serializable{
	private int id;
	private int id_produit;
	private String src_img_norm;
	private String src_img_mobile;
	private String formatWeb;
	
	
	public Image() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public String getSrc_img_norm() {
		return src_img_norm;
	}

	public void setSrc_img_norm(String src_img_norm) {
		this.src_img_norm = src_img_norm;
	}

	public String getSrc_img_mobile() {
		return src_img_mobile;
	}

	public void setSrc_img_mobile(String src_img_mobile) {
		this.src_img_mobile = src_img_mobile;
	}

	public String getFormatWeb() {
		return formatWeb;
	}

	public void setFormatWeb(String formatWeb) {
		this.formatWeb = formatWeb;
	}

	
	
}