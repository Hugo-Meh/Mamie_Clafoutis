/**
 * 
 */
document.addEventListener('DOMContentLoaded', function () {
	console.log('DOM contruit');
	console.log('user');

	
	var buttons = document.getElementsByClassName('btn_detele_user');
	var buttonsm = document.getElementsByClassName('btn_modif_user');

	for (var i=0; i<buttons.length; ++i) {
	  buttons[i].addEventListener('click', clickFunc);
	}

	function clickFunc() {
	 //alert(this.id); 
	 
	 
	 var xhr = new XMLHttpRequest();
		xhr.open("POST", "gestionEmploye", true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
		var Utilisateur = new Object();
		var ParametresUtilisateur = new Object();
		
		
		Utilisateur.id = this.id;
		
		console.log(Utilisateur);
		
		var user = JSON.stringify(Utilisateur);
		
		ParametresUtilisateur.url = "delete";
		ParametresUtilisateur.userJsonType = Utilisateur;
		
		
		var param = JSON.stringify(ParametresUtilisateur);
		
		console.log(param);


		
		
		xhr.send(param);
	 
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
	
	
	for (var i=0; i<buttonsm.length; ++i) {
		  buttons[i].addEventListener('click', clickFunc2);
		}

		function clickFunc2() {
		 //alert(this.id); 
		 
		 
		 var xhr = new XMLHttpRequest();
			xhr.open("POST", "gestionEmploye", true);
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			
			var Utilisateur = new Object();
			var ParametresUtilisateur = new Object();
			
			
			Utilisateur.id = this.id;
			
			console.log(Utilisateur);
			
			var user = JSON.stringify(Utilisateur);
			
			ParametresUtilisateur.url = "updateUser";
			ParametresUtilisateur.userJsonType = Utilisateur;
			
			
			var param = JSON.stringify(ParametresUtilisateur);
			
			console.log(param);


			
			
			xhr.send(param);
		 
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
	
	
	
	
	
	
});