/**
 * 
 */
document.addEventListener('DOMContentLoaded', function () {
	console.log('DOM contruit');
	console.log('user');

	
	var ajoutetab = document.getElementById("btnAjoutEtablissement");
	
	ajoutetab.addEventListener("click", ajout);

});


function ajout(event) {
	console.log("fonction ajout");
	event.preventDefault();
	
	var nom = document.getElementById("nomEtablissemnt");
	var tel = document.getElementById("telephoneEtablissement");
	var norue = document.getElementById("numRueEtablissement");
	var rue = document.getElementById("nomDeRueEtablissement");
	var ville = document.getElementById("villeEtablissemnt");
	var province = document.getElementById("provinceEtablissement");
	var cp = document.getElementById("codePostal");
	var listeetab = document.getElementById("listeTypeEtablissement");
	
	
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "gestionEtablissement", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	var Etablissement = new Object();
	var ParametreEtbalissement = new Object();
	var Adresse = new Object();
	var Type_Etablissement = new Object();
	
	Etablissement.name = nom.value;
	Etablissement.tel = tel.value;
	Adresse.numero_rue = norue.value;
	Adresse.nom_rue = rue.value;
	Adresse.ville = ville.value;
	Adresse.province = province.value;
	Adresse.code_postal = cp.value;
	Adresse.pays = "Canada";
	Type_Etablissement.id = listeetab.value;
	
	Etablissement.adresse = Adresse;
	Etablissement.typeEtablissement = Type_Etablissement;

	Etablissement.isVisible = "1";
	
	
	ParametreEtbalissement.url = "urlAddEtab";

	ParametreEtbalissement.etab = Etablissement;
	
	
	var param = JSON.stringify(ParametreEtbalissement);
	
	console.log(param);


	
	
	xhr.send(param);

	
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var jsonString = xhr.responseText;
			console.log(jsonString);
			var objEtab = JSON.parse(jsonString);
			console.log("test" + objEtab);
			

			
			
			//if (token == "-1") {
				// ajouter un message d'erreur a l'utilisateur
				//console.log("erreur");
			//} else {

				document.location.href = "/mamie_clafoutis_Projet_final/gestionEtablissement?action=urlDisplayEtab"
			//}

		}
	}
	 
	
}

	

	