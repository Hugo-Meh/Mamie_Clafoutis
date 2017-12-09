/**
 * 
 */
'use strict';
/*----------------validation ingredients-------------------*/

$("btnAjoutIngredient").click(function(event1){
	event1.preventDefault();
	var form_est_valide1 = true;
	
	/*---------validation nom de rue etablissement-------*/
	// min 1 caractere non blanc
	var input_nomIngredient =$("#nomIngredient");

	if (!$(input_nomIngredient).val().match(/[^a-z0-9]/)) {
		form_est_valide1 = false;
		input_nomIngredient.addClass("error");
		if (!input_nomIngredient.next().is("p.error_msg")) {
			input_nomIngredient.after("<p class='error_msg'>Veuillez entrer un nom d'ingredient valide</p>");
		}
	} else {
		input_nomIngredient.removeClass("error");
		if (input_nomIngredient.next().is("p.error_msg")) {
			input_nomIngredient.next().remove();
		}
	}
	
})