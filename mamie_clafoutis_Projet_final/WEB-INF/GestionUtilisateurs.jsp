<%@page import="entities.Role"%>
<%@page import="entities.Etablissement"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="utils.Utils"%>
<%@page import="manager.SessionManager"%>
<%@page import="service.C"%>
<%@page import="entities.Utilisateur"%>
<%@page import="java.util.ArrayList"%>

<%
	ArrayList<Role> allRoles = (ArrayList<Role>) request.getAttribute("role");
	ArrayList<Etablissement> allEtablissement = (ArrayList<Etablissement>) request.getAttribute("etab");
	ArrayList<Utilisateur> allUsers = (ArrayList<Utilisateur>) request.getAttribute(C.Utilisateur.cleUsers);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion utilisateurs</title>

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
	<img class="img-banner" alt="" src="images/banner-img2.jpeg">

	<h1 class="titre">Gestion Utilisateurs</h1>
	<div class="containerGP ">
		<!-- =========================== PRODUITS PID #1========================   -->
		<a href="gestionEmploye?action=addUser"><button
				class="bouton btn-submit">Ajouter Utilisateur</button></a>
		<form action="Produits.jsp" method="post">
			<table class="table table-bordered " id="tableGestionUtili">
				<thead class="  bg-info">
					<tr>
						<!-- ROW #1 -->
						<th>PRENOM</th>
						<th>NOM</th>
						<th>ETABLISSEMENT</th>
						<th>USERNAME</th>
						<th>MODIFIER/SUPPRIMER</th>
					</tr>
				</thead>

				<tbody>
					<%
						if (allUsers != null) {
					%>
					<%
						for (Utilisateur users : allUsers) {
					%>
					<tr class="tr_user">
						<!--#1 TABLE ROW -->
						<td id="nom<%=users.getId()%>"><%=users.getPrenom()%></td>
						<td class="usernom"><%=users.getNom()%></td>
						<td class="useretab"><%=users.getEtablissement().getName()%></td>
						<td class="userlogin"><%=users.getUserName()%></td>
						<td>
							<div class="text-center">

								<button type="button" id="<%=users.getId()%>"
									class="bouton btn_detele_user">Supprimer</button>
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
	<script src="js/gestion_user.js"></script>
</body>
</html>