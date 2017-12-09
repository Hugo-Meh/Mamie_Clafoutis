'use strict';

/**/
/*------------Ajout Utilisateur-----------*/
/**/
$("#btnAjoutUser").click(function(event){
    event.preventDefault();
	console.log("Ta reussi");
    var form_est_valide = true;

	// min 1 caractere non blanc
 	var input_nom =$("#nom");
	
	if (!$(input_nom).val().match(/^[A-Za-z]+$/)) {
		form_est_valide = false;
		input_nom.addClass("error");
		if (!input_nom.next().is("p.error_msg")) {
			input_nom.after("<p class='error_msg'>Veuillez entrer un nom d'utilisateur valide</p>");
		}
	} else {
		input_nom.removeClass("error");
		if (input_nom.next().is("p.error_msg")) {
			input_nom.next().remove();
		}
	}
	
	//min 1 caractere non blanc
	var input_prenom =$("#prenom");
	
	if (!$(input_prenom).val().match(/^[A-Za-z]+$/)) {
		form_est_valide = false;
		input_prenom.addClass("error");
		if (!input_prenom.next().is("p.error_msg")) {
			input_prenom.after("<p class='error_msg'>Veuillez entrer un prenom d'utilisateur valide</p>");
		}
	} else {
		input_prenom.removeClass("error");
		if (input_prenom.next().is("p.error_msg")) {
			input_prenom.next().remove();
		}
	}
    
	// ne pas laisser le select box vide 
    var select_etabl= $("#addetab");
    if (select_etabl.val()=="-1") {
        form_est_valide = false;
        select_etabl.addClass("error");
        if (!select_etabl.next().is("p.error_msg")) {
        	select_etabl.after("<p class='error_msg'>Veuillez choisir une des options</p>");
        }
    } else {
    	select_etabl.removeClass("error");
        if (select_etabl.next().is("p.error_msg")) {
        	select_etabl.next().remove();
        }
    }
    
	// ne pas laisser le select box vide 
    var select_role= $("#addrole");
    if (select_role.val()=="-1") {
        form_est_valide = false;
        select_role.addClass("error");
        if (!select_role.next().is("p.error_msg")) {
        	select_role.after("<p class='error_msg'>Veuillez choisir une des options</p>");
        }
    } else {
    	select_role.removeClass("error");
        if (select_role.next().is("p.error_msg")) {
        	select_role.next().remove();
        }
    }
    
	// nom: min 1 caractere non blanc
	var input_username =$("#username");
	//var lettre = /^[A-Za-z]+$/;  
	var username_valide = input_username.val().trim().length >= 1;
	if (!$(input_username).val().match(/^[A-Za-z]+$/))  {
		form_est_valide = false;
		input_username.addClass("error");
		if (!input_username.next().is("p.error_msg")) {
			input_username.after("<p class='error_msg'>Veuillez entrer un username valide</p>");
		}
	} else {
		input_username.removeClass("error");
		if (input_username.next().is("p.error_msg")) {
			input_username.next().remove();
		}
	}
    
	// nom: min 1 caractere non blanc
	var input_password =$("#password");
	
	if (!$(input_password).val().match(/^[A-Za-z]+$/)) {
		form_est_valide = false;
		input_password.addClass("error");
		if (!input_password.next().is("p.error_msg")) {
			input_password.after("<p class='error_msg'>Veuillez avoir au moins un caratère</p>");
		}
	} else {
		input_password.removeClass("error");
		if (input_password.next().is("p.error_msg")) {
			input_password.next().remove();
		}
	}
});

/*------------------------------------*/
/*------------Ajout produit-----------*/
/*------------------------------------*/


$("#btn-ajout-prod").click(function(event){
    event.preventDefault();
	console.log("Ta reussi");
    var form_est_valide = true;

	// min 1 caractere non blanc
	var input_nomProd =$("#nom-prod");
	//var lettre = /^[A-Za-z]+$/;  
	var nomProd_valide = input_nomProd.val().trim().length >= 1;
	if (!nomProd_valide) {
		form_est_valide = false;
		input_nomProd.addClass("error");
		if (!input_nomProd.next().is("p.error_msg")) {
			input_nomProd.after("<p class='error_msg'>Veuillez avoir au moins un caratère</p>");
		}
	} else {
		input_nomProd.removeClass("error");
		if (input_nomProd.next().is("p.error_msg")) {
			input_nomProd.next().remove();
		}
	}
	
	// min 1 caractere non blanc
	var input_descProd =$("#desc-prod");
	//var lettre = /^[A-Za-z]+$/;  
	var descProd_valide = input_descProd.val().trim().length >= 1;
	if (!descProd_valide) {
		form_est_valide = false;
		input_descProd.addClass("error");
		if (!input_descProd.next().is("p.error_msg")) {
			input_descProd.after("<p class='error_msg'>Veuillez avoir au moins un caratère</p>");
		}
	} else {
		input_descProd.removeClass("error");
		if (input_descProd.next().is("p.error_msg")) {
			input_descProd.next().remove();
		}
	}
	
	// ne pas laisser le select box vide 
    var select_cat= $("#categ-select");
    if (select_cat.val()=="-1") {
        form_est_valide = false;
        select_cat.addClass("error");
        if (!select_cat.next().is("p.error_msg")) {
        	select_cat.after("<p class='error_msg'>Veuillez choisir une des options</p>");
        }
    } else {
    	select_cat.removeClass("error");
        if (select_cat.next().is("p.error_msg")) {
        	select_cat.next().remove();
        }
    }
    
	// ne pas laisser le select box vide 
    var select_pate= $("#pate-select");
    if (select_pate.val()=="-1") {
        form_est_valide = false;
        select_pate.addClass("error");
        if (!select_pate.next().is("p.error_msg")) {
        	select_pate.after("<p class='error_msg'>Veuillez choisir une des options</p>");
        }
    } else {
    	select_pate.removeClass("error");
        if (select_pate.next().is("p.error_msg")) {
        	select_pate.next().remove();
        }
    }
    
	// min 1 caractere non blanc
	var inputQtyProd =$("#qte-prod");
	//var lettre = /^[A-Za-z]+$/;  
	var qtyProd_valide = inputQtyProd.val().trim().length >= 1;
	if (!qtyProd_valide) {
		form_est_valide = false;
		inputQtyProd.addClass("error");
		if (!inputQtyProd.next().is("p.error_msg")) {
			inputQtyProd.after("<p class='error_msg'>Veuillez avoir au moins un caratère</p>");
		}
	} else {
		inputQtyProd.removeClass("error");
		if (inputQtyProd.next().is("p.error_msg")) {
			inputQtyProd.next().remove();
		}
	}
    
	// ne pas laisser le select box vide 
    var select_unite= $("#unite-select");
    if (select_unite.val()=="-1") {
        form_est_valide = false;
        select_unite.addClass("error");
        if (!select_unite.next().is("p.error_msg")) {
        	select_unite.after("<p class='error_msg'>Veuillez choisir une des options</p>");
        }
    } else {
    	select_unite.removeClass("error");
        if (select_unite.next().is("p.error_msg")) {
        	select_unite.next().remove();
        }
    }
    
    
    
	// ne pas laisser le select box vide 
    var select_ing= $("#ingred-select");
    if (select_ing.val()=="-1") {
        form_est_valide = false;
        select_ing.addClass("error");
        if (!select_ing.next().is("p.error_msg")) {
        	select_ing.after("<p class='error_msg'>Veuillez choisir une des options</p>");
        }
    } else {
    	select_ing.removeClass("error");
        if (select_ing.next().is("p.error_msg")) {
        	select_ing.next().remove();
        }
    }
    
	// min 1 caractere non blanc
	var inputQtyProd2 =$("#qte-prod2");
	//var lettre = /^[A-Za-z]+$/;  
	var qtyProd_valide2 = inputQtyProd2.val().trim().length >= 1;
	if (!qtyProd_valide2) {
		form_est_valide = false;
		inputQtyProd2.addClass("error");
		if (!inputQtyProd2.next().is("p.error_msg")) {
			inputQtyProd2.after("<p class='error_msg'>Veuillez avoir au moins un caratère</p>");
		}
	} else {
		inputQtyProd2.removeClass("error");
		if (inputQtyProd2.next().is("p.error_msg")) {
			inputQtyProd2.next().remove();
		}
	}
    
	// ne pas laisser le select box vide 
    var select_unite2= $("#unite-select2");
    if (select_unite2.val()=="-1") {
        form_est_valide = false;
        select_unite2.addClass("error");
        if (!select_unite2.next().is("p.error_msg")) {
        	select_unite2.after("<p class='error_msg'>Veuillez choisir une des options</p>");
        }
    } else {
    	select_unite2.removeClass("error");
        if (select_unite2.next().is("p.error_msg")) {
        	select_unite2.next().remove();
        }
    }
});





























