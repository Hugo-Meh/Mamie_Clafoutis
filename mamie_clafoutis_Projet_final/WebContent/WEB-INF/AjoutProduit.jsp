<%@page import="entities.Unite"%>
<%@page import="entities.Ingredient"%>
<%@page import="entities.Patte"%>
<%@page import="entities.Categorie"%>
<%@page import="service.C"%>
<%@page import="entities.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<Categorie> allCats = (ArrayList<Categorie>) request.getAttribute(C.Categorie.categorielist);
	ArrayList<Patte> allPattes = (ArrayList<Patte>) request.getAttribute(C.Patte.patteList);
	ArrayList<Ingredient> allIngreds = (ArrayList<Ingredient>) request
			.getAttribute(C.Ingredient.ingredientList);
	ArrayList<Unite> allUnite = (ArrayList<Unite>) request.getAttribute(C.Unite.uniteList);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 -->
<title>Ajouter produit</title>
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="  css/styles.css">
<link rel="stylesheet" type="text/css" href="style/styleHeaderMenu.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<!--
--><%@ include file="include/headerMenu.jsp"%>
	<!--  
-->
	<img class="img-banner" alt="" src="images/ajouterProduit-banner.jpeg">
	<!--
-->
	<h1 class="titre">Ajouter un produit</h1>
	<form action="" id="form-ajout-produit" method="post">
		<ul id="listajout">
			<li><label class="label-form">Nom</label> <input
				class="input-form" type="text" name="nom" id="nom-prod"></li>
			<li><label class="label-form">Description</label> <textarea
					class="input-form" rows="0" cols="70" name="description"
					id="desc-prod"></textarea></li>
			<li><label class="label-form">Photo</label> <input
				class="input-form" id="input-photo" type="file" name="file"
				accept="image/*" onchange='openFile(event)'/></li>
			<li><label class="label-form">Categorie</label> <select
				name="categorie" class="select-form categ-select" id="categ-select">
					<option value="-1"></option>
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
			</select></li>
			<li><label class="label-form">Quantite</label> <input
				class="input-form" type="text" name="qte-unite" id="qte-unite">
			</li>
			<li><label class="label-form">Unité</label> <select name="unite"
				class="liste-deroulante select-form categ-select" id="unite-select">
					<option value="-1"></option>
					<%
						if (allUnite != null) {
					%>
					<%
						for (Unite u : allUnite) {
					%>

					<option value="<%=u.getId()%>"><%=u.getDenomination()%></option>
					<%
						}
						}
					%>

			</select></li>
			<li><label class="label-form">Pate</label> <select name="pates"
				class="liste-deroulante select-form categ-select" id="pate-select">
					<option value="-1"></option>
					<%
						if (allPattes != null) {
					%>
					<%
						for (Patte p : allPattes) {
					%>

					<option value="<%=p.getId()%>"><%=p.getNom()%> (<%=p.getUnite().getDenomination()%>)
					</option>
					<%
						}
						}
					%>
			</select></li>
			<li><label class="label-form">Quantité </label> <input
				type="text" name="poids" class="input-qte1 input-form" id="qte-prod"></li>
			<li><label class="label-form">Prix</label> <input
				class="input-form" type="text" name="prix" id="prix-prod"></li>
			<li><h3>Ingredient</h3></li>
			<li class="liingred">
				<button class="bouton-plus-moins btn-delete-prod">x</button> <select
				name="ingredient" class="liste-deroulante-ingred" id="ingred-select">
					<option value="-1"></option>
					<%
						if (allIngreds != null) {
					%>
					<%
						for (Ingredient i : allIngreds) {
					%>

					<option value="<%=i.getId()%>"><%=i.getDenomination()%> (<%=i.getUnite().getDenomination()%>)
					</option>
					<%
						}
						}
					%>
			</select> <label>Quantité </label> <input type="text" name="poids"
				class="input-qte" id="qte-prod2">
			</li>
			<li id="libtnadd"><label>Ajouter autre ingredient </label>
				<button class="bouton-plus-moins" id="btn-add-prod">+</button></li>
		</ul>
	</form>

	<div>
		<ul>
			<li>
				<button class="bouton bouton-ajout-prod" id="btn-ajout-prod">Ajouter</button>
			</li>
			<li>
				<button class="bouton bouton-ajout-prod">Annuler</button>
			</li>
		</ul>

	</div>
	<%@ include file="include/footer.jsp"%>
	<script src="js/jquery-3.2.1.js"></script>
	<!--  <script src="js/validationFormulaire.js"></script>-->
	<script src="js/ajout_prod.js"></script>
	<script src="js/user.js"></script>

</body>
</html>