<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion Commandes</title>
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
	<img class="img-banner" alt="" src="images/gestionCommandes-banner.jpeg">

	<h1 class="titre">Gestion Commandes</h1>

	<div class="container ">
		<!-- =========================== PRODUITS PID #1========================   -->
		<form action="Produits.jsp" method="post">
			<table class="table table-bordered " id="table-gestion-commandes">
				<thead class="  bg-info">
					<tr>
						<!-- ROW #1 -->
						<th>ID</th>
						<th>DATE</th>
						<th>UTILISATEUR</th>
						<th>AFFICHAGE COMMANDE</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<!--#1 TABLE ROW -->
						<td>01</td>
						<td>12/14/17</td>
						<td>El patron del mal</td>
						<td>
							<button class="btn-form bouton" id="btn-gestionCommande">
								<a href="AffichageCommandes.jsp">Afficher</a>
							</button>
						</td>

					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<%@ include file="include/footer.jsp"%>
</body>
</html>