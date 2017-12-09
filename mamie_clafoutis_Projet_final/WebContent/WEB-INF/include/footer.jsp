
<%@page import="manager.TypeEtablissementManager"%>
<%@page import="manager.SessionManager"%>
<%@page import="service.C"%>
<%@page import="entities.Utilisateur"%>

<%
	Utilisateur user2 = (Utilisateur) SessionManager.getSessionValue(C.Utilisateur.sessionUserConnect, request);
%>


<footer>
	<!--hello  -->
	<!--    ------------[Navigation_Start]--------------------------------------------------------------[Navigation_Start]-->
	<div class="footer-bottom">

		<div class="container">

			<div class="row">

				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">

					<div class="copyright">Mamie Clafoutis</div>

				</div>

				<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">

					<div class="design">
						<%
							/*----------------Connection de ladmin------------------*/
							if ((user2 != null) && (user2.getRole().getId() == 1)) {
						%>

						<a href="accueil">Accueil</a> | <a href="#">Gestion Commandes</a> | <a
							href="gestionEtablissement?action=urlDisplayEtab">Gestion �tablissements </a> |	<a href="gestionP?action=displayproduit">Gestion Produits </a> | <a href="gestionEmploye?action=display">Gestion
							Utilisateurs</a>
						<%
							}
						%>
						<%
							/*----------------Connection de Chef boulanger Admin------------------*/
							if ((user2 != null) && (user2.getRole().getId() == 2) && (user2.getEtablissement().getTypeEtablissement().getId() == 1)) {
						%>

						<a href="accueil">Accueil</a> | <a href="#">Gestion Commandes</a> | <a href="gestionP?action=displayproduit">Gestion
							Produits </a>
						<%
							}
						%>
						<%
							/*----------------Connection de Chef boulanger Corporate ET cuisinier------------------*/
							if ((user2 != null) && (user2.getRole().getId() == 2) && (user2.getEtablissement().getTypeEtablissement().getId() == 2)
									|| (user2 != null) && (user2.getRole().getId() == 4) && (user2.getEtablissement().getTypeEtablissement().getId() == 2)) {
						%>

						<a href="accueil">Accueil</a> | <a href="gestionP?action=displayproduit">Produits</a>
						<%
							}
						%>
						<%
							/*----------------Connection de Gerant Corporate et Fanchise------------------*/
							if ((user2 != null) && (user2.getRole().getId() == 3) && (user2.getEtablissement().getTypeEtablissement().getId() == 3)||
									(user2 != null) && (user2.getRole().getId() == 3) && (user2.getEtablissement().getTypeEtablissement().getId() == 2)) {
						%>

						<a href="accueil">Accueil</a> | <a href="gestionP?action=displayproduit">Produits</a> | <a href="gestionEmploye?action=display">Gestion
							Utilisateurs</a>
						<%
							}
						%>
						<%
							/*----------------Connection de Chef boulanger Franchise et cuisiner Franchise------------------*/
							if ((user2 != null) && (user2.getRole().getId() == 2) && (user2.getEtablissement().getTypeEtablissement().getId() == 3)||
									(user2 != null) && (user2.getRole().getId() == 4) && (user2.getEtablissement().getTypeEtablissement().getId() == 3)) {
						%>

						<a href="accueil">Accueil</a> | <a href="gestionP?action=displayproduit">Produits</a> | <a href="gestioncommande?action=panier">Panier</a>
						<%
							}
						%>
					</div>

				</div>

			</div>

		</div>

	</div>
</footer>
