<%@page import="entities.Role"%>
<%@page import="entities.Etablissement"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="utils.Utils"%>
<%@page import="manager.SessionManager"%>
<%@page import="service.C"%>
<%@page import="entities.Utilisateur"%>
<%@page import="entities.Type_Etablissement" %>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <% 
   		ArrayList<Etablissement> allEtablissements = (ArrayList<Etablissement>) request.getAttribute(C.Etablissement.etabList);
   		Etablissement monEtablissement = (Etablissement)request.getAttribute(C.Etablissement.unEtablissement);
	%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion Etablissement</title>
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
<!--HEADER -->
<%@ include file="include/headerMenu.jsp"  %>
<!--FIN HEADER  -->
	<img class="img-banner" alt="" src="images/gestion-etablissement-banner.jpeg">


	<h1 class="titre">Gestion Etablissement</h1>
	<!-- affichage gestion etablissement administration -->
	<% if ((user != null) && (user.getRole().getId()==1)) { %>
	<div class="container ">
		<!-- =========================== PRODUITS PID #1========================   -->
		
		<button class="bouton btn-submit" id="btn-gestion-etablissement">
			<a href="gestionEtablissement?action=urlAddEtab">Ajouter Etablissement</a>
		</button>
		<form action="Produits.jsp" method="post">
			<table class="table table-bordered ">
				<thead class="  bg-info">
					<tr>
						<!-- ROW #1 -->
					
						<th>NOM ETABLISSEMENT</th>
						<th>ADRESSE</th>
						<th>CODE POSTAL</th>
						<th>TELEPHONE</th>
						<th>TYPE ETABLISSEMENT</th>
					</tr>
				</thead>

				<tbody>
				<% 
				   if(allEtablissements != null){
				%>
				<%
					for(Etablissement etablissements : allEtablissements) {
				%>
				
					<tr>
						<!--#1 TABLE ROW -->
						
						<td><%=etablissements.getName() %></td>
						
						<% if (etablissements.getAdresse() !=null){ %>
						<td><%=etablissements.getAdresse().getNumero_rue()+" " %><%= etablissements.getAdresse().getNom_rue()+" " %>
						<%=etablissements.getAdresse().getVille()+" " %><%=etablissements.getAdresse().getPays() %></td>
						<%} %>
						<td><%=etablissements.getAdresse().getCode_postal() %></td>
						<td><%=etablissements.getTel() %></td>
						<% if(etablissements.getTypeEtablissement() != null) {%>
						<td><%=etablissements.getTypeEtablissement().getType() %></td>
					<%} %>
						
					</tr>
					<%
				 	   }
			 		   }
					%>
				</tbody>
			</table>
		</form>
	</div>
	<%
      }	
	%>
	<!-- affichage gestion etablissement pour gerent et chefboulanger -->
	<%
	if ((user != null) && (user.getRole().getId()==2) && (user.getEtablissement().getId()==2) )  {
	%>
	<div id="infoGestionEtablissement">
		<ul>
			<li><label  class="label-form">Nom etablissement</label><%=monEtablissement.getName() %></li>
			<li><label  class="label-form">Adresse</label><%=monEtablissement.getAdresse().getNumero_rue()+" " %><%=monEtablissement.getAdresse().getNom_rue()+", " %>
			<%=monEtablissement.getAdresse().getVille()+", " %><%=monEtablissement.getAdresse().getPays() %></li>
			<li><label  class="label-form">Code Postal</label><%=monEtablissement.getAdresse().getCode_postal() %></li>
			<li><label  class="label-form">Telephone</label><%=monEtablissement.getTel() %>
			<li><label  class="label-form">Type etablissement</label><%=monEtablissement.getTypeEtablissement().getType() %>
		</ul>
		
		
		<button class="bouton btn-submit" >Modifier</button>
	</div>

	<%} %>
	<!--FOOTER  -->
	<%@ include file="include/footer.jsp" %>

</body>
</html>