package utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Produit;
import service.C;

public class Utils {

	public static String generateToken(String login) {
		String token = UUID.randomUUID().toString().toUpperCase() + login;
		return token;

	}

	public static String recieveJsonRequest(HttpServletRequest request) {
		String json = "", line;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			while ((line = br.readLine()) != null) {
				json += line;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;
	}

	public static void sendJsonResponse(String jsonRetour, HttpServletResponse response) {
		PrintWriter out;
		try {
			response.setContentType("text/json;charset=UTF-8");
			out = response.getWriter();
			out.print(jsonRetour);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static final String md5(final String s) {
		final String MD5 = "MD5";
		try {
			// Create MD5 Hash
			MessageDigest digest = java.security.MessageDigest.getInstance(MD5);
			digest.update(s.getBytes());
			byte messageDigest[] = digest.digest();

			// Create Hex String
			StringBuilder hexString = new StringBuilder();
			for (byte aMessageDigest : messageDigest) {
				String h = Integer.toHexString(0xFF & aMessageDigest);
				while (h.length() < 2)
					h = "0" + h;
				hexString.append(h);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

//	public static String savephoto(Produit produit) {
//		String srcRetour = "";
//		try {
//			String imageBase=produit.getBase64().replace("data:image/png;base64,", "");
//			byte[] data = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(imageBase);
//			String path = System.getProperty("user.dir") + C.Image.imageDirectoryPath;
//			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//			String src_image = produit.getNom() +"_"+ timeStamp + ".jpg";
//			Path destinationFile = Paths.get("/home/mohamed/projet final/projet_final_novembre_2017/backend/mamie_clafoutis_Projet_final/WebContent/images/photo", src_image);
//			Files.write(destinationFile, data);
//			srcRetour = src_image;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return srcRetour;
//	}
}
