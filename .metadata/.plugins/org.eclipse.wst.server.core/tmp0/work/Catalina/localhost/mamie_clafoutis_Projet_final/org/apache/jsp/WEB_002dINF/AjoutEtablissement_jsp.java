/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.1
 * Generated at: 2017-12-08 02:19:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import service.C;
import entities.Type_Etablissement;
import java.util.ArrayList;
import manager.TypeEtablissementManager;
import manager.SessionManager;
import service.C;
import entities.Utilisateur;
import entities.Type_Etablissement;
import manager.TypeEtablissementManager;
import manager.SessionManager;
import service.C;
import entities.Utilisateur;

public final class AjoutEtablissement_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/include/headerMenu.jsp", Long.valueOf(1512699549000L));
    _jspx_dependants.put("/WEB-INF/include/footer.jsp", Long.valueOf(1512698168000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("manager.SessionManager");
    _jspx_imports_classes.add("entities.Utilisateur");
    _jspx_imports_classes.add("manager.TypeEtablissementManager");
    _jspx_imports_classes.add("service.C");
    _jspx_imports_classes.add("entities.Type_Etablissement");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t");
  ArrayList<Type_Etablissement> allTypes = (ArrayList<Type_Etablissement>)request.getAttribute(C.Type_Etablissement.typeEtabList);
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Ajouter Etablissement</title>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Roboto+Condensed\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"  css/styles.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"style/styleHeaderMenu.css\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Utilisateur user = (Utilisateur) SessionManager.getSessionValue(C.Utilisateur.sessionUserConnect, request);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("\t<div class=\"container-inverse Header_Nav_Container\">\r\n");
      out.write("\t\t<nav class=\"navbar navbar-inverse Header_Nav_Menu \" role=\"navigation\">\r\n");
      out.write("\t\t\t<!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("\t\t\t<div class=\"collapse navbar-collapse\"\r\n");
      out.write("\t\t\t\tid=\"bs-navbar-navbar-collapse-1\">\r\n");
      out.write("\t\t\t\t");

					/*----------------Connection de ladmin------------------*/
					if ((user != null) && (user.getRole().getId() == 1)) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand  Google_Link\" href=\"accueil\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"Retour vers la page d'accueil\">Accueil</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\">Gestion Commandes</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"gestionEtablissement?action=urlDisplayEtab\">Gestion\r\n");
      out.write("\t\t\t\t\t\t\td'établissements</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"gestionP?action=displayproduit\">Gestion\r\n");
      out.write("\t\t\t\t\t\t\tProduits</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"gestionEmploye?action=display\">Gestion\r\n");
      out.write("\t\t\t\t\t\t\tUtilisateurs</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\" class=\"signup_link\" id=\"profil\"><span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-user\"></span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"logOut\" class=\"login_link\"><span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-log-out\"></span></a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t\t");

					/*----------------Connection de Chef boulanger Admin------------------*/
					if ((user != null) && (user.getRole().getId() == 2) && (user.getEtablissement().getTypeEtablissement().getId() == 1)) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand  Google_Link\" href=\"accueil\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"Retour vers la page d'accueil\">Accueil</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\">Gestion Commandes</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"gestionP?action=displayproduit\">Gestion Produits</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\" class=\"signup_link\" id=\"profil\"><span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-user\"></span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"logOut\" class=\"login_link\"><span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-log-out\"></span></a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t\t");

					/*----------------Connection de Chef boulanger Corporate ET cuisinier------------------*/
					if ((user != null) && (user.getRole().getId() == 2) && (user.getEtablissement().getTypeEtablissement().getId() == 2)
							|| (user != null) && (user.getRole().getId() == 4) && (user.getEtablissement().getTypeEtablissement().getId() == 2)) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand  Google_Link\" href=\"accueil\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"Retour vers la page d'accueil\">Accueil</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"gestionP?action=displayproduit\">Produit</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\" class=\"signup_link\" id=\"profil\"><span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-user\"></span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"logOut\" class=\"login_link\"><span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-log-out\"></span></a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t\t");

					/*----------------Connection de Gerant Corporate et Fanchise------------------*/
					if ((user != null) && (user.getRole().getId() == 3) && (user.getEtablissement().getTypeEtablissement().getId() == 3)
							|| (user != null) && (user.getRole().getId() == 3) && (user.getEtablissement().getTypeEtablissement().getId()== 2)) {
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand  Google_Link\" href=\"accueil\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"Retour vers la page d'accueil\">Accueil</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"gestionP?action=displayproduit\">Produits</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"gestionEmploye?action=display\">Gestion Utilisateurs</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"gestioncommande?action=panier\">Panier</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\" class=\"signup_link\" id=\"profil\"><span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-user\"></span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"gestioncommande?action=panier\" class=\"login_link\"><span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-shopping-cart\"></span></a></li>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<li><a href=\"logOut\" class=\"login_link\"><span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-log-out\"></span></a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t\t");

					/*----------------Connection de Chef boulanger Franchise et cuisiner Franchise------------------*/
					if ((user != null) && (user.getRole().getId() == 2) && (user.getEtablissement().getTypeEtablissement().getId() == 3)
							|| (user != null) && (user.getRole().getId() == 4) && (user.getEtablissement().getTypeEtablissement().getId() == 3)) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand  Google_Link\" href=\"accueil\"\r\n");
      out.write("\t\t\t\t\t\ttitle=\"Retour vers la page d'accueil\">Accueil</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"gestionP?action=displayproduit\">Produit</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"gestioncommande?action=panier\">Panier</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Inscription.html\" class=\"signup_link\" id=\"profil\"><span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-user\"></span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"gestioncommande?action=panier\" class=\"login_link\"><span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-shopping-cart\"></span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"logOut\" class=\"login_link\"><span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-log-out\"></span></a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"myModal\" class=\"modal\">\r\n");
      out.write("\t\t<!-- Modal content -->\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<span class=\"close\">&times;</span>\r\n");
      out.write("\t\t\t<h3 id=\"titreProfil\">Votre Profil</h3>\r\n");
      out.write("\t\t\t");

				if (user != null) {
			
      out.write("\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\tNom:\r\n");
      out.write("\t\t\t\t");
      out.print(user.getNom());
      out.write("</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\tPrenom:\r\n");
      out.write("\t\t\t\t");
      out.print(user.getPrenom());
      out.write("</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\tEtablissement:\r\n");
      out.write("\t\t\t\t");
      out.print(user.getEtablissement().getName());
      out.write("</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\tUsername:\r\n");
      out.write("\t\t\t\t");
      out.print(user.getUserName());
      out.write("</p>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><label class=\"label-form\">Votre Password</label><input\r\n");
      out.write("\t\t\t\t\tclass=\"input-form\" type=\"text\" placeholder=\"votre password\" id=\"mdp1\"></li>\r\n");
      out.write("\t\t\t\t<li><label class=\"label-form\">Nouveau Password</label> <input\r\n");
      out.write("\t\t\t\t\tclass=\"input-form\" type=\"text\" placeholder=\"nouveau password\" id=\"mdp2\"></li>\r\n");
      out.write("\t\t\t\t<li><label class=\"label-form\">Nouveau Password</label><input\r\n");
      out.write("\t\t\t\t\tclass=\"input-form\" type=\"text\" placeholder=\"nouveau password\" id=\"mdp3\"></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"changer votre password\"\r\n");
      out.write("\t\t\t\tclass=\"bouton btn-submit btnpass\" id=\"");
      out.print(user.getId());
      out.write("\">\r\n");

				}
			
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<script src=\"js/modal.js\"></script>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<img class=\"img-banner\" alt=\"\"\r\n");
      out.write("\t\tsrc=\"images/ajoutEtablissement-banner.jpeg\">\r\n");
      out.write("\t<h2 class=\"titre\">Ajouter Etablissement</h2>\r\n");
      out.write("\t<form action=\"\" class=\"allForm\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li><label class=\"label-form\">Nom</label> <input\r\n");
      out.write("\t\t\t\tid=\"nomEtablissemnt\" class=\"input-form\" type=\"text\" name=\"nom\"\r\n");
      out.write("\t\t\t\tplaceholder=\" Nom d'établissement\"></li>\r\n");
      out.write("\t\t\t<li><label class=\"label-form\">Numéro de téléphone</label> <input\r\n");
      out.write("\t\t\t\tid=\"telephoneEtablissement\" class=\"input-form\" type=\"text\"\r\n");
      out.write("\t\t\t\tname=\"numeroTel\" placeholder=\" Téléphone de l'établissement\"></li>\r\n");
      out.write("\t\t\t<li><h3>Adresse</h3></li>\r\n");
      out.write("\t\t\t<li><label class=\"label-form\">Numero de rue</label> <input\r\n");
      out.write("\t\t\t\tid=\"numRueEtablissement\" class=\"input-form\" type=\"text\"\r\n");
      out.write("\t\t\t\tname=\"numero\" placeholder=\" Numéro de l'établissement\"></li>\r\n");
      out.write("\t\t\t<li><label class=\"label-form\">Nom de rue</label> <input\r\n");
      out.write("\t\t\t\tid=\"nomDeRueEtablissement\" class=\"input-form\" type=\"text\" name=\"rue\"\r\n");
      out.write("\t\t\t\tplaceholder=\" Nom de rue de l'établissement\"></li>\r\n");
      out.write("\t\t\t<li><label class=\"label-form\">Ville</label> <input\r\n");
      out.write("\t\t\t\tid=\"villeEtablissemnt\" class=\"input-form\" type=\"text\" name=\"ville\"\r\n");
      out.write("\t\t\t\tplaceholder=\" ville de l'établissement\"></li>\r\n");
      out.write("\t\t\t<li><label class=\"label-form\">Province</label> <input\r\n");
      out.write("\t\t\t\tid=\"provinceEtablissement\" class=\"input-form\" type=\"text\"\r\n");
      out.write("\t\t\t\tname=\"province\" placeholder=\" Province de l'établissement\"></li>\r\n");
      out.write("\t\t\t<li><label class=\"label-form\">Code postal</label> <input\r\n");
      out.write("\t\t\t\tid=\"codePostal\" class=\"input-form\" type=\"text\" name=\"codePostal\"\r\n");
      out.write("\t\t\t\tplaceholder=\" Code postal de l'établissement\"></li>\r\n");
      out.write("\t\t\t<li><label class=\"label-form \">Type etablissement</label> <select\r\n");
      out.write("\t\t\t\tid=\"listeTypeEtablissement\" name=\"listeEtablissement\">\r\n");
      out.write("\t\t\t\t\t<option value=\"-1\"></option>\r\n");
      out.write("\t\t\t\t\t");

						if (allTypes != null){
					
      out.write("\r\n");
      out.write("\t\t\t\t\t");

						for (Type_Etablissement t : allTypes){
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print(t.getId());
      out.write('"');
      out.write('>');
      out.print(t.getType() );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</select></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<button class=\"btn-submit bouton\" id=\"btnAjoutEtablissement\">Ajouter\r\n");
      out.write("\t\t\tÉtablissement</button>\r\n");
      out.write("\t\t<button class=\"btn-submit bouton\">Annuler</button>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<script src=\"js/validationEtablissement.js\"></script>\r\n");
      out.write("\t<script src=\"js/ajout_etab.js\"></script>\r\n");
      out.write("\t<script src=\"js/jquery-3.2.1.js\"></script>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Utilisateur user2 = (Utilisateur) SessionManager.getSessionValue(C.Utilisateur.sessionUserConnect, request);

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<footer>\r\n");
      out.write("\t<!--hello  -->\r\n");
      out.write("\t<!--    ------------[Navigation_Start]--------------------------------------------------------------[Navigation_Start]-->\r\n");
      out.write("\t<div class=\"footer-bottom\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"copyright\">Mamie Clafoutis</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 col-sm-8 col-md-8 col-lg-8\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"design\">\r\n");
      out.write("\t\t\t\t\t\t");

							/*----------------Connection de ladmin------------------*/
							if ((user2 != null) && (user2.getRole().getId() == 1)) {
						
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"accueil\">Accueil</a> | <a href=\"#\">Gestion Commandes</a> | <a\r\n");
      out.write("\t\t\t\t\t\t\thref=\"gestionEtablissement?action=urlDisplayEtab\">Gestion ï¿½tablissements </a> |\t<a href=\"gestionP?action=displayproduit\">Gestion Produits </a> | <a href=\"gestionEmploye?action=display\">Gestion\r\n");
      out.write("\t\t\t\t\t\t\tUtilisateurs</a>\r\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");

							/*----------------Connection de Chef boulanger Admin------------------*/
							if ((user2 != null) && (user2.getRole().getId() == 2) && (user2.getEtablissement().getTypeEtablissement().getId() == 1)) {
						
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"accueil\">Accueil</a> | <a href=\"#\">Gestion Commandes</a> | <a href=\"gestionP?action=displayproduit\">Gestion\r\n");
      out.write("\t\t\t\t\t\t\tProduits </a>\r\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");

							/*----------------Connection de Chef boulanger Corporate ET cuisinier------------------*/
							if ((user2 != null) && (user2.getRole().getId() == 2) && (user2.getEtablissement().getTypeEtablissement().getId() == 2)
									|| (user2 != null) && (user2.getRole().getId() == 4) && (user2.getEtablissement().getTypeEtablissement().getId() == 2)) {
						
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"accueil\">Accueil</a> | <a href=\"gestionP?action=displayproduit\">Produits</a>\r\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");

							/*----------------Connection de Gerant Corporate et Fanchise------------------*/
							if ((user2 != null) && (user2.getRole().getId() == 3) && (user2.getEtablissement().getTypeEtablissement().getId() == 3)||
									(user2 != null) && (user2.getRole().getId() == 3) && (user2.getEtablissement().getTypeEtablissement().getId() == 2)) {
						
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"accueil\">Accueil</a> | <a href=\"gestionP?action=displayproduit\">Produits</a> | <a href=\"gestionEmploye?action=display\">Gestion\r\n");
      out.write("\t\t\t\t\t\t\tUtilisateurs</a>\r\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");

							/*----------------Connection de Chef boulanger Franchise et cuisiner Franchise------------------*/
							if ((user2 != null) && (user2.getRole().getId() == 2) && (user2.getEtablissement().getTypeEtablissement().getId() == 3)||
									(user2 != null) && (user2.getRole().getId() == 4) && (user2.getEtablissement().getTypeEtablissement().getId() == 3)) {
						
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"accueil\">Accueil</a> | <a href=\"gestionP?action=displayproduit\">Produits</a> | <a href=\"gestioncommande?action=panier\">Panier</a>\r\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}