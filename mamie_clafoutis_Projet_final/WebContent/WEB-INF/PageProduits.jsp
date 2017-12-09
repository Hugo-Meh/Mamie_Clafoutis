<%@page import="entities.Categorie"%>
<%@page import="entities.Produit"%>
<%@page import="manager.SessionManager"%>
<%@page import="service.C"%>

<%@page import="entities.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<Produit> allProduits = (ArrayList<Produit>) request.getAttribute(C.Produit.produitList);
	ArrayList<Categorie> allCats = (ArrayList<Categorie>) request.getAttribute(C.Categorie.categorielist);
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produits</title>
<link rel="stylesheet" type="text/css" href="  css/styles.css">
<link rel="stylesheet" type="text/css" href="style/styleHeaderMenu.css">
<link rel="stylesheet" type="text/css" href="style/MamieClafoutis.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="include/headerMenu.jsp"%>
	<img class="img-banner" alt="" src="images/gestion-prod-banner.jpg">
	<h1 class="titre">Nos produits</h1>
	<%
		if (user != null) {
			int idEtab=user.getEtablissement().getTypeEtablissement().getId();
	%>
	<select name="categoriemenu" id="menucats-prod" class="select-produit">
		<option value="allcats">Toutes les catégories</option>
		<%
			if (allCats != null) {
				
		%>
		<%
			for (Categorie c : allCats) {
		%>

		<option value="<%=c.getId()%>"><%=c.getDenomination()%></option>
		<%
			}
				}
		%>
	</select>

	<div id="wrapper_produit">
		<%
			if (allProduits != null) {
		%>
		<%
			for (Produit p : allProduits) {
		%>
		<div class="produit_unit">
			<h3 class="prod-details"><%=p.getNom()%></h3>
			<%if(p.getImageList()!=null){ %>
			<%if(p.getImageList().get(0).getSrc_img_norm()!=null){ %>
			<img
				src='images/photo/<%=p.getImageList().get(0).getSrc_img_norm()%>'
				class="img_prod2 " />
				<%}else if(p.getImageList().get(0).getFormatWeb()!=null){ %>
				<img
				src=<%=p.getImageList().get(0).getFormatWeb()%>
				class="img_prod2 " />
				<%}else { %>
				<img
				src='images/mamieclafoutis_logo.png' class="img_prod2 " />
				<%} %>
				<%} %>
			<h3 class="prod-details"><%=p.getCategorie().getDenomination()%></h3>
			<%if(idEtab==C.Etablissement.idFranchise|| idEtab==C.Etablissement.idPro) {%>
			<div class='div-qty-produit'>
			
				<label>Quantitée</label> <input
					class="input-form valid-caract input-qty-panier " type="number"
					id="quantite<%=p.getId()%>" name="qtyPanier">
			</div>
			<%} %>
			<div>
			<%if(idEtab==C.Etablissement.idFranchise|| idEtab==C.Etablissement.idPro) {%>
				<button class="bouton  btnPanier" id="<%=p.getId()%>">Ajouter
					au panier</button>
					<%} %>
				<button class="bouton btn_desc_prod detail-prod-class"
					value="<%=p.getId()%>">Description</button>
			</div>
		</div>

		<%
			}
				}
		%>
	</div>
	<div id="myModal-prod" class="modal-prod">
		<!-- Modal content -->


	</div>
	<%@ include file="include/footer.jsp"%>
	<script src="js/modal_prod.js"></script>
	<script src="js/produits.js"></script>
	<script src="js/panier.js"></script>
	<%
		}
	%>
</body>
</html>