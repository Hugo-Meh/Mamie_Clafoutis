package service;

public class C {

	public static class Connexion {
		static public final int typeAndroid = 1;
		static public final int typeWeb = 2;
	}

	public static class Utilisateur {		
		static final public String nomTable = "utilisateur";
		static final public String etabId="etabId";
		static public final String cleUsers="cleUsers";
		static public final int timeCookieUserInlive=60*60*24*30;
		static public final String sessionUserConnect="sessionUserConnect";
		static public final String TokenCookieUser="TokenCookieUser";
		static public final String urlActionUserUpdate="updateUser";
		static public final String urlActionUseradd="addUser";
		static public final String urlActionUserdisplay="display";
		static public final String urlActionUserdelete="delete";
		static public final String id = "id";
		static public final String nom = "nom";
		static public final String prenom = "prenom";
		static public final String etablissement_id = "etablissement_id ";
		static public final String role_id = "role_id";
		static public final String username = "username";
		static public final String password = "password";
		static public final String isVisible = "isVisible";
		static public final String tokenIdentification = "tokenIdentification";
		static public final String tokenInscription = "tokenInscription";
	}

	public static class Etablissement {
		static final public int idCorpo = 2 ;
		static final public int idSiege = 1 ;
		static final public int idFranchise = 3 ;
		static final public int idPro = 4 ;
		public static final String urlDeleteEtab = "urlDeleteEtab";
		public static final String urlUpdateEtab = "urlUpdateEtab";
		public static final String urlDisplayEtab = "urlDisplayEtab";
		public static final String urlAddEtab = "urlAddEtab";
		public static final String etabList = "etabList";
		public static final String unEtablissement = "unEtablissement";
		public static final String nomTable = "etablissement";
		public static final String id = "id";
		public static final String name = "name";
		public static final String tel = "tel";
		public static final String type_id = "type_id";
		public static final String adresse_id = "adresse_id";
		public static final String isVisible = "isVisible";

	}

	public static class Role {
		static final public int idGerant =3;
		static final public int idChefBoulanger =2;
		static final public int idAdmin =1;
		static final public int idCuisinier =4;
		static final public int idVendeur =5;
		
		

	}

	public static class Type_Etablissement {
		public static final String typeEtabList = "typeEtabList";
	}

	public static class Adresse {

	}

	public static final class Produit {
		static public final String tabProduitListPanier="tabProduitListPanier" ;
		static public final int timeCookieUserInlive = 60 * 60 * 24 * 30;
		static public final String produitList = "produitList";
		static public final String urlActionProduitAdd = "addproduit";
		static public final String urlActionProduitDisplay = "displayproduit";
		static public final String urlActionProduitDisplayCategorie = "displayproduitCategorie";
		static public final String urlActionProduitDisplayId = "displayproduitId";
		static public final String urlUpdateProduit = "urlUpdateProduit";

		public static final String nomTable = "produit";
		public static final String id = "id";
		public static final String nom = "nom";
		public static final String categorie_id = "categorie_id";
		public static final String description = "description";
		public static final String prix = "prix";
		public static final String estvisible = "estvisible";
		public static final String reference = "reference";
		public static final String poid = "poid";
		public static final String unite_id = "unite_id";
		public static final String quantite = "quantite";
	}

	public static final class Categorie {
		static public final String urlgetallcategories = "getallcategories";
		static public final String categorielist = "categorielist";
		public static final String nomTable = "categorie";
		public static final String id = "id";
		public static final String denomination = "denomination";

	}

	public static final class Unite {

		public static final String uniteList = "uniteList";
		public static final String nomTable = "unite";
		static public final String allunite = "getallunite";
		public static final String id = "id";
		public static final String denomination = "denomination";

	}

	public static final class Patte {
		public static final String patteList = "patteList";
		public static final String nomTable = "patte";
		public static final String id = "id";
		public static final String nom = "nom";
		public static final String unite_id = "unite_id";
		

	}

	public static final class Ingredient {
		public static final String urlIngredient = "urlIngredient";
		public static final String ingredientList = "ingredientList";
		public static final String urldisplayAllingredientsbyproduitid = "displayAllingredientsbyproduitid";
		public static final String id = "id";
		public static final String denomination = "denomination";
		public static final String quantite = "quantite";
		public static final String unite_id = "unite_id";
	}

	public static class Image {

		public static final String srcPath = "http://172.16.40.219:9080/mamie_clafoutis_Projet_final/images/photo/";


		
		public static final String imageDirectoryPath="/WebContent/images/photo";

	}

	public static class Commande {
		public static final String urlModifierPanier="urlModifierPanier";
		public static final String urlDetailCommande="detailCommande";
		public static final String urlVoirCommandesEncours="display";
		public static final String urlAjouterAuPanier="urlAjouterAuPanier";
		public static final String urlsoumettrecommande = "soumettrecommande";
		public static final String urlaffichercommandes = "affichercommandes";
		public static final String nomTable = "commande";
		public static final String id = "id";
		public static final String utilisateur_id = "utilisateur_id";
		public static final String date = "date";
		public static final String valide = "valide";
		public static final String urlVoirPanier="panier";
		
	}
	
	public static class LigneDeCommande {
		public static final String nomTable = "ligne_de_commande";
		public static final String commande_id = "commande_id";
		public static final String quantite = "quantite";
		public static final String patte_id = "patte_id";
		public static final String unite_id = "unite_id";
	}
	
	public static class produit_patte {
		public static final String nomTable = "produit_patte";
		public static final String id_produit = "produit_id";
		public static final String id_patte = "patte_id";
		public static final String poid = "poid";
	}
	
	public static class Message {
		public static final String successCommande = "Votre commande a �t� enregistr�e avec succ�s";
	}
}
