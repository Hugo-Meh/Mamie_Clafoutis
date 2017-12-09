<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter Ingredient</title>
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
		src="images/ajouterIngredients-banner.jpeg">

	<h2 class="titre">Ajouter Ingrédient</h2>

	<form action=""  class="allForm">
		<label>Ingrédient</label>
		<input class="input-form" type="text" name="nom" placeholder=" Nom de l'ingrédient" id="nomIngredient"><br>

		<button class="bouton btn-submit" id="btnAjoutIngredient">Ajouter Ingredient</button>
		<button class="bouton btn-submit">Annuler</button>
	</form>
	<script src="js/validationIngredient.js"></script>
	<script src="js/jquery-3.2.1.js"></script>
	<%@ include file="include/footer.jsp"%>
</body>
</html>