/**
 * 
 */
document.addEventListener('DOMContentLoaded', function () {
	console.log('DOM contruit');
	console.log('user');

	
	var ajout = document.getElementById("btnAjoutUser");
	
	ajout.addEventListener("click", lien);

});


function lien(event) {
	console.log("fonction lien");
	event.preventDefault();
	
	var nom = document.getElementById("nom");
	var prenom = document.getElementById("prenom");
	var etab = document.getElementById("addetab");
	var role = document.getElementById("addrole");
	var login = document.getElementById("username");
	var pass = document.getElementById("password");
	
	
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "gestionEmploye", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	var Utilisateur = new Object();
	var ParametresUtilisateur = new Object();
	var roleObj= new Object();
	var etabObj= new Object();
	roleObj.id=role.value;
	etabObj.id=etab.value;
	console.log(Utilisateur);
	
	Utilisateur.nom = nom.value;
	Utilisateur.prenom = prenom.value;
	Utilisateur.etablissement = etabObj;
	Utilisateur.role = roleObj;
	Utilisateur.userName = login.value;
	Utilisateur.password = pass.value;
	Utilisateur.isVisible = "1";
	Utilisateur.tokenIdentification = "1";
	Utilisateur.tokenInscription = "1";
	
	console.log(Utilisateur);
	
	var user = JSON.stringify(Utilisateur);
	
	ParametresUtilisateur.url = "addUser";
	ParametresUtilisateur.userJsonType = Utilisateur;
	
	
	var param = JSON.stringify(ParametresUtilisateur);
	
	console.log(param);


	
	
	xhr.send(param);
	//xhr.send({"url":"addUser","userJsonType":"{\"nom\":\"Rubio\",\"prenom\":\"Antonio\",\"etablissement\":\"1\",\"role\":\"1\",\"userName\":\"r\",\"password\":\"r\",\"isVisible\":\"1\",\"tokenIdentification\":\"1\",\"tokenInscription\":\"1\"}"});
	
	
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
				console.log("erreur");
			} else {

				document.location.href = "/mamie_clafoutis_Projet_final/gestionEmploye?action=display"
			}

		}
	}
	 
	
}

	

	