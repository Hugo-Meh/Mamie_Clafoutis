<%@ page import="entities.Ingredient" %>
<%@ page import="service.C" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<% ArrayList<Ingredient> allIngredients = (ArrayList<Ingredient>)request.getAttribute(C.Produit.categorie_id); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion Ingredients</title>
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

	<img class="img-banner" alt="" src="images/gestion-ingredients-banner.jpeg">

	<h1 class="titre">Gestion Ingredients</h1>

	<div class="container ">
		<!-- =========================== PRODUITS PID #1========================   -->
		<button class="btn-submit bouton" id="bouton-gestion-ingredients">
			<a href="AjouterIngredient.jsp">Ajouter Ingredients</a>
		</button>
		<form action="Produits.jsp" method="post" id="table-gestion-ingredients">
			<table class="table table-bordered ">
				<thead class="  bg-info">
					<tr>
						<!-- ROW #1 -->
						<th>INGREDIENT</th>
						<th>MODIFIER/SUPPRIMER</th>
					</tr>
				</thead>

				<tbody>
				<%
					if (allIngredients != null){ 
				%>
				<%
					for (Ingredient ingredients : allIngredients){
				%>
					<tr>
						<!--#1 TABLE ROW -->
						
						<td><%= ingredients.getDenomination() %></td>
						<td>
							<div class="  text-center">
								<button type="button"
									class="btn btn-danger glyphicon glyphicon-trash"></button>
							</div>
						</td>
					</tr>
					<%
					  	}
						}
					%>
				</tbody>
			</table>
		</form>
	</div>
	<!-- ===========================END  PRODUITS PID #1 ========================   -->


	<%@ include file="include/footer.jsp"%>
</body>
</html>