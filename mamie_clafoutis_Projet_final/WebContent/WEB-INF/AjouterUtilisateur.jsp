<%@page import="entities.Role"%>
<%@page import="entities.Etablissement"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Role> allRoles = (ArrayList<Role>) request.getAttribute("role");
	ArrayList<Etablissement> allEtablissement = (ArrayList<Etablissement>) request.getAttribute("etab");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//FR" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter Utilisateur</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<img class="img-banner" alt=""
		src="images/ajouterUtilisateur-banner.jpeg">
	<h2 class="titre">Ajouter un utilisateur</h2>

	<form action="" class="allForm">
		<ul>
			<li><label class="label-form">Nom</label> <input
				class="input-form valid-caract" type="text" id="nom" name="nom"
				placeholder=" Nom de l'utilisateur"></li>
			<li><label class="label-form">Prenom</label> <input
				class="input-form valid-caract" type="text" id="prenom" name="prenom"
				placeholder=" Prénom de l'utilisateur"></li>
			<li><label class="label-form">Etablissement</label><select
				name="listeEtablissement" id="addetab" class="select-form select-form categ-select">
					<option value="-1"></option>
					<%
						if (allEtablissement != null) {
					%>
					<%
						for (Etablissement e : allEtablissement) {
					%>
					<option value="<%=e.getId()%>"><%=e.getName()%></option>
					<%
						}
						}
					%>
			</select></li>
			<li><label class="label-form">Role</label> <select
				name="listeRole" id="addrole" class="select-form valid-select select-form categ-select">
					<option value="-1"></option>
					<%
						if (allRoles != null) {
					%>
					<%
						for (Role r : allRoles) {
					%>
					<option value="<%=r.getId()%>"><%=r.getTitre()%></option>
					<%
						}
						}
					%>
			</select></li>
			<li><label class="label-form">Username</label> <input
				class="input-form valid-caract" type="text" id="username" name="username"
				placeholder=" Username de l'utilisateur"></li>
			<li><label class="label-form">Password</label> <input
				class="input-form valid-caract" type="text" id="password" name="password"
				placeholder=" Mot de passe de l'utilisateur"></li>
		</ul>
		<button class="bouton btn-submit" id="btnAjoutUser">Ajouter
			Utilisateur</button>

		<button class="bouton btn-submit">Annuler</button>
	</form>
	
	<script src="js/user.js"></script>
	<script src="js/validationFormulaire.js"></script>
	<script src="js/jquery-3.2.1.js"></script>

	<%@ include file="include/footer.jsp"%>
</body>
</html>