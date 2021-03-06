<%@page import="entities.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	ArrayList<Produit> produitsPanier = (ArrayList<Produit>) SessionManager
			.getSessionTabValue(C.Produit.tabProduitListPanier, request);
	float prixTotal = SessionManager.prixTotal(produitsPanier);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Panier</title>
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
		src="images/gestion-ingredients-banner.jpeg">

	<h2 class="titre">PANIER</h2>

	<div class="container tableau_de_produits">


		<!-- =========================== PRODUITS PID #1========================   -->
		<div class="container " id="container_panier">
			<%
				if (produitsPanier != null) {
			%>
			<table class="table table-bordered" id="tablePanier">
				<thead class="  bg-info">
					<tr>
						<!-- ROW #1 -->
						<th class="categorie_th_td">PHOTO</th>
						<th class="produits_th_td">NOM PRODUIT</th>
						<th class="prix_unitaire_th_td">PRIX UNITAIRE</th>
						<th class="quantite_th_td">QUANTITÉ</th>
						<th class="supprimer_th_td">PRIX TOTAL</th>


					</tr>
				</thead>

				<tbody>
					<%
						if (produitsPanier != null) {
					%>

					<%
						for (Produit p : produitsPanier) {
					%>
					<tr id=<%=p.getId()%>>
						<!--#1 TABLE ROW -->

						<td class="categorie_th_td"><%=p.getCategorie().getDenomination()%></td>
						<td class="produits_th_td"><%=p.getNom()%></td>


						<td class="prix_unitaire_th_td prixu"><%=p.getPrix()%></td>
						<td class="quantite_th_td">
							<div class="  text-center">

								<div style="padding-top: 10px">
									<input id="input_quantite" type="number"
										class="form-control qteprod" maxlength="3" size="3" min="0"
										placeholder="QTY " name="input_quantite "
										value="<%=p.getQuantite()%>"></label>

								</div>
							</div>
						</td>

						<td class="soust">
							<div class="text-center"></div>
						</td>

					</tr>
					<%
						}
							}
					%>

				</tbody>
			</table>
			
			<div id="infoTotalPanier">
				<p>
					SOUS-TOTAL:
					<%=prixTotal%>
				</p>
				<p>
					TPS:
					<%=(float) ((Math.ceil(prixTotal * 100 * 0.1)) / 100)%></p>
				<p>
					TVQ:
					<%=(float) ((Math.ceil(prixTotal * 100 * 0.05)) / 100)%></p>
				<p>
					TOTAL:
					<%=(float) ((Math.ceil(prixTotal * 100 * 1.15)) / 100)%></p>
			</div>
			<%
				}
			%>
		</div>
		<button class="bouton btn-submit" id="validationCommande">Valider
			Commande</button>
	</div>




	<%@ include file="include/footer.jsp"%>
	<script src="js/jquery-3.2.1.js"></script>
	<script src="js/panier.js"></script>


</body>
</html>