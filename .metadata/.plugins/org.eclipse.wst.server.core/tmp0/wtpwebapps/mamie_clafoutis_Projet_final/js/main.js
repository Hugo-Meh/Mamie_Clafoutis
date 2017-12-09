/**
 * 
 */

document.addEventListener('DOMContentLoaded', function() {
	console.log('DOM contruit');
	var login = document.getElementById("username");
	var pass = document.getElementById("password");
	var lettre = /^[A-Za-z]+$/;

	
	var page_menu1 = document.getElementById("page_menu1");
	
	
	
	if(login.value != lettre && pass.value != lettre){
		var form = document.getElementById("form-connect");
		form.addEventListener("submit", connexion);
	}
	

	page_menu1.addEventListener("click", gestionProduit);
});

function connexion(event) {
	console.log("fonction connexion");
	event.preventDefault();

	var login = document.getElementById("username");
	var pass = document.getElementById("password");
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "logIn", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	var Utilisateur = new Object();
	Utilisateur.userName = login.value;
	Utilisateur.password = pass.value;
	console.log(Utilisateur);
	var utilsateurTosend = JSON.stringify(Utilisateur);
	xhr.send(utilsateurTosend);

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var jsonString = xhr.responseText;
			console.log(jsonString);
			var objectUtilisateur = JSON.parse(jsonString);
			console.log("test" + objectUtilisateur.userName);
			console.log(objectUtilisateur.password);
			console.dir(jsonString);

			console.log(objectUtilisateur.tokenIdentification);
			var token = objectUtilisateur.tokenIdentification;
			if (token == "-1") {
				// ajouter un message d'erreur a l'utilisateur
				var erreur = document.getElementById("erreur");
				erreur.innerHTML = "* mauvais nom d'utilisateur ou mauvais mot de passe veuillez réessayer";
			} else {

				document.location.href = "/mamie_clafoutis_Projet_final/accueil"
			}

		}
	}

}
function gestionProduit(event) {
	console.log("gestion employe");
	event.preventDefault();
	xhr.open("POST", "gestionEmploye", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	var parametresUtilisateur = new Object();
	parametresUtilisateur.url = "display";
	var paramToSend = JSON.stringify(parametresUtilisateur);
	xhr.send(utilsateurTosend);

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var jsonString = xhr.responseText;
			console.log(jsonString);
			var utilisateurs = JSON.parse(jsonString);
			for(user of utilisateurs){
				console.log(user);
				console.log(user.nom);
			}
				
		}
	}

}

function descCommande(event){
	console.log(event.target.id);
	var idCommande=event.target.id;
	var param= new Object();
	
	param.url="detailCommande";
	var commande= new Object();
	commande.idParam="idCommande";
	commande.valeurParam=idCommande;
	param.parametreList=commande;
	 
	var xhr = new XMLHttpRequest();
		xhr.open("POST", "gestioncommande", true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		var paramToSend = JSON.stringify(param);
		console.log(paramToSend);
		xhr.send(paramToSend);
		 
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var jsonString = xhr.responseText;
				console.log(jsonString);
				$("#myModal-prod");
				var ObjectLigneCommande=JSON.parse(jsonString);
			}
		}
}
