
'use strict';

$("#btnAjoutEtablissement").click(function(event){
	event.preventDefault();
	var form_est_valide = true;
	
	/*-----------validation nom de letablissement----------*/
	// min 1 caractere non blanc
	var input_nom =$("#nomEtablissemnt");
	
	if (!$(input_nom).val().match(/^[A-Za-z]+$/)) {
		form_est_valide = false;
		input_nom.addClass("error");
		if (!input_nom.next().is("p.error_msg")) {
			input_nom.after("<p class='error_msg'>Veuillez entrer un nom valide</p>");
		}
	} else {
		input_nom.removeClass("error");
		if (input_nom.next().is("p.error_msg")) {
			input_nom.next().remove();
		}
	}
	
	

	/*-----------validation telephone-----*/
	
	// min 1 caractere non blanc
	var input_telephone =$("#telephoneEtablissement");
	if (!$(input_telephone).val().match(/\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/)) {
		form_est_valide = false;
		input_telephone.addClass("error");
		if (!input_telephone.next().is("p.error_msg")) {
			input_telephone.after("<p class='error_msg'>Veuillez entrer un telephone valide (123) 123 1234</p>");
		}
	} else {
		input_telephone.removeClass("error");
		if (input_telephone.next().is("p.error_msg")) {
			input_telephone.next().remove();
		}
	}
	
   	/*--------validation numero de rue-------------*/
	// min 1 caractere non blanc
	var input_numRue =$("#numRueEtablissement");
	  
	
	if (!$(input_numRue).val().match(/^[0-9]{1,10}$/)){
		form_est_valide = false;
		input_numRue.addClass("error");
		if (!input_numRue.next().is("p.error_msg")) {
			input_numRue.after("<p class='error_msg'>Veuillez entrer un numero de rue valide</p>");
		}
	} else {
		input_numRue.removeClass("error");
		if (input_numRue.next().is("p.error_msg")) {
			input_numRue.next().remove();
		}
	}
	
	/*---------validation nom de rue etablissement-------*/
	// min 1 caractere non blanc
	var input_nomRue =$("#nomDeRueEtablissement");

	if (!$(input_nomRue).val().match(/[^a-z0-9]/)) {
		form_est_valide = false;
		input_nomRue.addClass("error");
		if (!input_nomRue.next().is("p.error_msg")) {
			input_nomRue.after("<p class='error_msg'>Veuillez entrer un nom de rue valide</p>");
		}
	} else {
		input_nomRue.removeClass("error");
		if (input_nomRue.next().is("p.error_msg")) {
			input_nomRue.next().remove();
		}
	}
	
	
	/*---------- validation ville------------------*/
	// min 1 caractere non blanc
	var input_nomVille =$("#villeEtablissemnt");
	
	if (!$(input_nomVille).val().match(/^[A-Za-z]+$/)) {
		form_est_valide = false;
		input_nomVille.addClass("error");
		if (!input_nomVille.next().is("p.error_msg")) {
			input_nomVille.after("<p class='error_msg'>Veuillez entrer un nom de ville valide</p>");
		}
	} else {
		input_nomVille.removeClass("error");
		if (input_nomVille.next().is("p.error_msg")) {
			input_nomVille.next().remove();
		}
	}
	
	/*------------ validation province------------*/
	// min 1 caractere non blanc
	var input_nomProvince =$("#provinceEtablissement");
	//var lettre = /^[A-Za-z]+$/;  

	if (!$(input_nomProvince).val().match(/^[A-Za-z]+$/)) {
		form_est_valide = false;
		input_nomProvince.addClass("error");
		if (!input_nomProvince.next().is("p.error_msg")) {
			input_nomProvince.after("<p class='error_msg'>Veuillez entrer un nom de province valide</p>");
		}
	} else {
		input_nomProvince.removeClass("error");
		if (input_nomProvince.next().is("p.error_msg")) {
			input_nomProvince.next().remove();
		}
	}
	
	
	/*------validation code postal canada--------*/
	var input_nom =$("#codePostal");
	
	if (!$(input_nom).val().match(/^[A-Za-z]\d[A-Za-z][ -]?\d[A-Za-z]\d$/)) {
		form_est_valide = false;
		input_nom.addClass("error");
		if (!input_nom.next().is("p.error_msg")) {
			input_nom.after("<p class='error_msg'>Veuillez entrer un code postal valide (A1A1A1)</p>");
		}
	} else {
		input_nom.removeClass("error");
		if (input_nom.next().is("p.error_msg")) {
			input_nom.next().remove();
		}
	}
	
	/*-------- validation liste derroulante type etablissemnt*/
	// ne pas laisser le select box vide 
    var select_etablissment= $("#listeTypeEtablissement");
  
    if (select_etablissment.val()=="-1") {
        form_est_valide = false;
        select_etablissment.addClass("error");
        if (!select_etablissment.next().is("p.error_msg")) {
        	select_etablissment.after("<p class='error_msg'>Veuillez choisir une des options</p>");
        }
    } else {
    	select_etablissment.removeClass("error");
        if (select_etablissment.next().is("p.error_msg")) {
        	select_etablissment.next().remove();
        }
    }
    
/*methode validation numeros*/
    function isNumber(n) {
    	  return !isNaN(parseInt(n)) && isFinite(n);
    	}
    
});




