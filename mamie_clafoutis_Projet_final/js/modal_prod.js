/**
 * 
 */

var modal = document.getElementById('myModal-prod');

// Get the button that opens the modal
var btn = document.getElementsByClassName("detail-prod-class");
console.log("testt" + this.id);

var span = document.getElementsByClassName("close-prod")[0];
for (var i = 0; i < btn.length; ++i) {
	btn[i].addEventListener('click', clickFunc3);

}

function clickFunc3() {
	modal.style.display = "block";
	console.log("id " + this.value);

	var Produit = new Object();
	Produit.url = "displayproduit";
	console.log(Produit.id);
	console.log("pour le nom :" + Produit.nom);
	console.log("dans la fonction")

	var param = new Object();
	param.idParam = "produitId";
	param.valeurParam = this.value;

	Produit.parametreList = param;

	var xhr = new XMLHttpRequest();
	xhr.open("POST", "gestionP", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	var produitJson = JSON.stringify(Produit);

	console.log(produitJson);

	xhr.send(produitJson);

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var jsonString = xhr.responseText;
			console.log(jsonString);
			var objectProduit = JSON.parse(jsonString);
			console.log(objectProduit);
		}
		if(objectProduit!==undefined){
			var modal = document.getElementById('myModal-prod');
			console.log(modal);
			var html='<div class="modal-content-prod">'+
			'<span id="close" class="close-prod">&times;</span><div class="info-detail-prod"><ul>'
			+'<li class="modal-desc-prod nomjs">'+objectProduit.nom+'</li>'
			+'<li class="imagejs"><img src="images/photo/'+objectProduit.imageList[0].src_img_norm+'"/></li>'+
			'<li class="desc-js"><p class="desc-modal-prod">'+objectProduit.description+'</p></li>'+
			'<li class="modal-desc-prod prixjs">Prix : '+objectProduit.prix+' $</li>'+
			'</ul></div>'
			if(objectProduit.patte!==undefined){
				html+='<div class="container-div-ingredient"><h2 class="titre-modal">Recette</h2><p>'+objectProduit.patte.nom+'</p>';
				if(objectProduit.patte.ingredientList!==undefined){
					html+='<ul>';
					for(var i of objectProduit.patte.ingredientList){
						html+='<li>'+i.denomination+'</li>';
					}
					html+='</ul></div></div>';
				}
			}
			
			$("#myModal-prod").html(html);
			
			var btnClose= document.getElementById('close');
			
			btnClose.addEventListener('click',close);
			
		}
	}
	
	function close(event){
		
		event.preventDefault();
		console.log("fermer fenetre");
		
		$("#myModal-prod").hide();

	}

	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
	
	
}
