
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acceuil-Mamie Clafoutis</title>

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
	<%@ include file="include/headerMenu.jsp"%>
	<img class="img-banner" alt="" src="images/connection-banner.jpeg">

	<div id="page-acceuil-info">
		<h1 id="titreAccueil">
			Bienvenue
			<%=user.getPrenom()%></h1>
		<h3 class="infoAccueil">
			Nom:
			<%=user.getNom()%></h3>
		<h3 class="infoAccueil">
			Etablissement:
			<%=user.getEtablissement().getName()%></h3>
		<h3 class="infoAccueil">
			Role:
			<%=user.getRole().getTitre()%></h3>
	</div>

	<%@ include file="include/footer.jsp"%>
</body>
</html>