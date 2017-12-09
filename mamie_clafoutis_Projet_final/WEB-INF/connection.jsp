
<%@page import="entities.Utilisateur"%>
<%@page import="com.google.gson.Gson"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<!--HEADER-->
	<%@ include file="include/headerMenu.jsp"%>

	<img class="img-banner" alt="" src="images/connection-img-banner.jpeg" id="img-accueil">
	<img id="logo-mamieclafoutis" alt=""
		src="images/mamieclafoutis_logo.png">
	<h1 class="titre" id="titre-connection">Connectez-vous !</h1>
	<form action="" method="post" id="form-connect">
		<ul>
			<li><label class="label-form" for="username">Nom
					d'utilisateur</label> <input class="input-form" type="text" name="username"
				id="username" placeholder=" Votre nom d'utilisateur"></li>
			<li><label class="label-form" for="password">Mot de
					passe</label> <input class="input-form" type="password" name="password"
				id="password" placeholder=" Votre mot de passe"></li>
		</ul>
		<div id="erreur" class="erreur_msg"></div>

		<input class="bouton btn-submit" type="submit" id="btnConnexion"
			value="Soumettre" />

	</form>
	<!--FOOTER-->
	<%@ include file="include/footer.jsp"%>
	<script src="js/main.js"></script>

</body>

</html>