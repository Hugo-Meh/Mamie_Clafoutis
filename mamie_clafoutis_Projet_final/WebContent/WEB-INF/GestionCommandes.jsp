<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entities.Commande"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%ArrayList<Commande> listCommande=(ArrayList<Commande>)request.getAttribute("commande"); %>
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
		<!-- =========================== Commande PID #1========================   -->
		<%if (listCommande!=null){ %>
			<table class="table table-bordered " id="table-gestion-commandes">
				<thead class="  bg-info">
					<tr>
						<!-- ROW #1 -->
						<th>ID</th>
						<th>DATE</th>
						<th>UTILISATEUR</th>
						<th>ETABLISSEMENT</th>
						<th>AFFICHAGE COMMANDE</th>
					</tr>
				</thead>

				<tbody>
				<%for(Commande c:listCommande){ %>
					<tr>
						<!--#1 TABLE ROW -->
						<td><%=c.getId() %></td>
						<td><%=new SimpleDateFormat("yyyy-MM-dd").format(c.getDate()) %></td>
						<td><%=c.getUtilisateur().getNom() %> <%=c.getUtilisateur().getPrenom() %></td>
						<td><%=c.getUtilisateur().getEtablissement().getName() %></td>
						<td>
							<button class="btn-form bouton afficher_commande" onclick="descCommande(event)" id=<%=c.getId() %>>
								Afficher
							</button>
						</td>

					</tr>
					<%} %>
				</tbody>
			</table>
			<%} %>
			
	</div>
	<div id="myModal-prod" class="modal-prod">

	</div>
		<script src="js/jquery-3.2.1.js"></script>
		<script src="js/modal_prod.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<%@ include file="include/footer.jsp"%>
</body>
</html>