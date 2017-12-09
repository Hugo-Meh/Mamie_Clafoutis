

document.addEventListener('DOMContentLoaded', function () {
	console.log('DOM contruit');

    var validation = document.getElementById("validationCommande");
	
	
	
	var btn = document.getElementsByClassName("btnPanier");
	var soust = document.getElementsByClassName("soust");
	var qteprod = document.getElementsByClassName("qteprod");
	var prixu = document.getElementsByClassName("prixu");
	
	
	for (var i=0; i<soust.length; ++i) {
		
		  console.log(parseFloat(qteprod[i].value) * parseFloat(prixu[i].textContent));
		  soust[i].innerHTML = parseFloat(qteprod[i].value) * parseFloat(prixu[i].textContent);
		  
		}
	
	
	for (var i=0; i<btn.length; ++i) {
		  btn[i].addEventListener('click', ajoutpanier);
		}

	
	
	validation.addEventListener('click', validerpanier);
	
}
);


//function valider commande
function validerpanier(event){
	event.preventDefault();
	console.log("valider commande");
	
	 var xhr = new XMLHttpRequest();
	 xhr.open("POST", "gestioncommande", true);
	 xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	 
	 
	 var param = new Object();
	 param.url = "soumettrecommande";	 
	
	
	 var paramtosend = JSON.stringify(param);
	 console.log(paramtosend);
	 xhr.send(paramtosend);
	
		
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var jsonString = xhr.responseText;
				console.log(jsonString);
			
				
				
	

			}
		
	 
	 
	}
}


//function ajouter panier
function ajoutpanier(event) {
	// alert(this.id);
	 event.preventDefault();
	 console.log("ajout panier")
	 
	 var xhr = new XMLHttpRequest();
		xhr.open("POST", "gestioncommande", true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
		var Produit = new Object();
		var ParametresProduit = new Object();
		
		
		var qte = document.getElementById("quantite"+this.id);
		
		Produit.id = this.id;
		Produit.quantite = qte.value;
		
		console.log(qte.value);
		
	
		ParametresProduit.url = "urlAjouterAuPanier";
		ParametresProduit.produitJsonType = Produit;
	
		
		var param = JSON.stringify(ParametresProduit);
		
		console.log(param);


		
		
		xhr.send(param);
	 
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var jsonString = xhr.responseText;
				console.log(jsonString);
				//var objectUtilisateur = JSON.parse(jsonString);
				//console.log("test" + objectUtilisateur.userName);
				//console.log(objectUtilisateur.password);
				//console.dir(jsonString);

				
				
	

			}
		
	 
	 
	}
	
	}


function modifqte() {
	// alert(this.id);
	 
	 console.log("modif")
	 
	 var xhr = new XMLHttpRequest();
		xhr.open("POST", "gestioncommande", true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
		var Produit = new Object();
		var ParametresProduit = new Object();
		
		
		var qte = document.getElementById("quantite"+this.id);
		
		Produit.id = this.id;
		Produit.quantite = qte.value;
		
		console.log(qte.value);
		
	
		ParametresProduit.url = "urlAjouterAuPanier";
		ParametresProduit.produitJsonType = Produit;
	
		
		var param = JSON.stringify(ParametresProduit);
		
		console.log(param);


		
		
		xhr.send(param);
	 
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var jsonString = xhr.responseText;
				console.log(jsonString);
				//var objectUtilisateur = JSON.parse(jsonString);
				//console.log("test" + objectUtilisateur.userName);
				//console.log(objectUtilisateur.password);
				//console.dir(jsonString);

				
				
	

			}
		
	 
	 
	}
	
	}

	
	 


