<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<!--HEADER-->
	<%@ include file="include/headerMenu.jsp"%>
	<img class="img-banner" alt=""
		src="images/affichageCommande-banner.jpeg">
	<table class="table table-bordered " id="table-affichage-commandes">
		<thead class="  bg-info">
			<tr>
				<th colspan="3">Commande Num:01</th>
			</tr>
			<tr>
				<th colspan="3">01/03/17</th>
			</tr>
			<tr>
				<!-- ROW #1 -->
				<th>UTILISATEUR</th>
				<th>ÉTABLISSEMENT</th>
				<th>PRIX</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<!--#1 TABLE ROW -->
				<td></td>
				<td></td>
				<td>15.99</td>
			</tr>
			<tr>
				<td colspan="3">Prix total</td>
			</tr>
		</tbody>
	</table>
	<!--FOOTER-->
 	<%@ include file="include/footer.jsp"%>
</body>
</html>