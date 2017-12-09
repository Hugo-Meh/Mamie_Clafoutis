<%@page import="service.C"%>
<%@page import="entities.Type_Etablissement" %>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	<%  ArrayList<Type_Etablissement> allTypes = (ArrayList<Type_Etablissement>)request.getAttribute(C.Type_Etablissement.typeEtabList);%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter Etablissement</title>
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
	<%@ include file="include/headerMenu.jsp"%>
	<img class="img-banner" alt=""
		src="images/ajoutEtablissement-banner.jpeg">
	<h2 class="titre">Ajouter Etablissement</h2>
	<form action="" class="allForm">
		<ul>
			<li><label class="label-form">Nom</label> <input
				id="nomEtablissemnt" class="input-form" type="text" name="nom"
				placeholder=" Nom d'établissement"></li>
			<li><label class="label-form">Numéro de téléphone</label> <input
				id="telephoneEtablissement" class="input-form" type="text"
				name="numeroTel" placeholder=" Téléphone de l'établissement"></li>
			<li><h3>Adresse</h3></li>
			<li><label class="label-form">Numero de rue</label> <input
				id="numRueEtablissement" class="input-form" type="text"
				name="numero" placeholder=" Numéro de l'établissement"></li>
			<li><label class="label-form">Nom de rue</label> <input
				id="nomDeRueEtablissement" class="input-form" type="text" name="rue"
				placeholder=" Nom de rue de l'établissement"></li>
			<li><label class="label-form">Ville</label> <input
				id="villeEtablissemnt" class="input-form" type="text" name="ville"
				placeholder=" ville de l'établissement"></li>
			<li><label class="label-form">Province</label> <input
				id="provinceEtablissement" class="input-form" type="text"
				name="province" placeholder=" Province de l'établissement"></li>
			<li><label class="label-form">Code postal</label> <input
				id="codePostal" class="input-form" type="text" name="codePostal"
				placeholder=" Code postal de l'établissement"></li>
			<li><label class="label-form ">Type etablissement</label> <select
				id="listeTypeEtablissement" name="listeEtablissement">
					<option value="-1"></option>
					<%
						if (allTypes != null){
					%>
					<%
						for (Type_Etablissement t : allTypes){
					%>
					<option value="<%=t.getId()%>"><%=t.getType() %></option>
					<%
						}
					%>
					<%
						}
					%>
				
			</select></li>
		</ul>
		<button class="btn-submit bouton" id="btnAjoutEtablissement">Ajouter
			Établissement</button>
		<button class="btn-submit bouton">Annuler</button>
	</form>
	<script src="js/validationEtablissement.js"></script>
	<script src="js/ajout_etab.js"></script>
	<script src="js/jquery-3.2.1.js"></script>
	<%@ include file="include/footer.jsp"%>
</body>
</html>