/**
 * 
 */

var modal = document.getElementById('myModal');

var btn = document.getElementsByClassName("btnpass");

btn[0].addEventListener("click", modifmotpasse);

	// Get the button that opens the modal
	var btn = document.getElementById("profil");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on the button, open the modal 
	
		  btn.addEventListener('click', clickFunc2);
		

	function clickFunc2(event) {
	    modal.style.display = "block";
	    console.log(this.id)
	   event.preventDefault();
	    var Utilisateur = new Object();
	    Utilisateur.id = this.id;
	    console.log(Utilisateur.id);
	    //var nom = document.getElementById("nom"+this.id).innerText;
	    //console.log(nom);
	    
	    
	    
	}

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	    modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}
	
	
	
	function modifmotpasse(event) {
		console.log("modifmotpasse");
		event.preventDefault();
		console.log(this.id);
		
		var mdp = document.getElementById("mdp1");
		var nouveaumdp = document.getElementById("mdp2");
		var confirmmdp = document.getElementById("mdp3");
		
		
		var xhr = new XMLHttpRequest();
		xhr.open("POST", "gestionEmploye", true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
		var Utilisateur = new Object();
		var ParametresUtilisateur = new Object();
		var Parametre = new Object();
		
		Utilisateur.password = mdp.value;
		Parametre.idParam = "pwd";
		Parametre.valeurParam = nouveaumdp.value;
		
		ParametresUtilisateur.url = "updateUser";
		ParametresUtilisateur.userJsonType = Utilisateur;
		ParametresUtilisateur.param = Parametre;
		
		var param = JSON.stringify(ParametresUtilisateur);
		
		console.log(param);


		xhr.send(param);
		
		
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var jsonString = xhr.responseText;
				console.log(jsonString);
				
			}
		}
		 
		
	}

		

