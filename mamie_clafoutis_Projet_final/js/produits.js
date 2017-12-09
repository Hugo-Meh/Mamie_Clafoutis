
/**
 * 
 */
document.addEventListener('DOMContentLoaded', function () {
	console.log('DOM contruit');


	
	var menu = document.getElementById('menucats-prod');
	var btn = document.getElementsByClassName("btn_ajout_prod");
	
	menu.addEventListener("change", selectcats);
	
	
	
	
	for (var i=0; i<btn.length; ++i) {
		  btn[i].addEventListener('click', ajoutproduit);
		}


	
	
}
);
function ajoutproduit(event) {
	 // alert(this.id);
	event.preventDefault();
	 
	 
	 var xhr = new XMLHttpRequest();
		xhr.open("POST", "gestionP", true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
		var Produit = new Object();
		var ParametresProduit = new Object();
		var ParamList = new Object();
		
		Produit.id = this.id;
	
		ParamList.idParam = "switch";
		ParamList.valeurParam = "0";
		
		console.log(Produit);
		console.log(ParamList);
		
		
		
		ParametresProduit.url = "urlUpdateProduit";
		ParametresProduit.produitJsonType = Produit;
		ParametresProduit.parametreList = ParamList;
		
		console.log(ParametresProduit);

		
		
		var param = JSON.stringify(ParametresProduit);
		
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

				
				
				// document.location.href =
				// "/mamie_clafoutis_Projet_final/gestionP?action=displayproduit"

			}
		
	 
	 
	}
	
	}

	function selectcats() {
		var menu = document.getElementById('menucats-prod');
	 console.log("cats");
	 console.log(menu.value);
	 
	 
	 var xhr = new XMLHttpRequest();
		xhr.open("POST", "gestionP", true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
		var ParametresProduits = new Object();
		
		if(menu.value != "allcats"){
			var Produit = new Object();
			Produit.idParam="categorie";
			Produit.valeurParam = menu.value;
			console.log(Produit);
			ParametresProduits.parametreList = Produit;
		}
	
		
		ParametresProduits.url = "displayproduit";
		
		
		
		var param = JSON.stringify(ParametresProduits);
		
		console.log(param);


		
		
		xhr.send(param);
	
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var jsonString = xhr.responseText;
				console.log(jsonString);
				var objectProduit = JSON.parse(jsonString);
				console.dir(jsonString);

				var prod = document.getElementById('wrapper_produit');
				var html = "";
				for(var produit of objectProduit){
					html+="<div class='produit_unit'>"+
					"<h3 class='prod-details'>"+ produit.nom +"</h3>";
					if(produit.imageList!==undefined){
						html+="<img src=images/photo/"+produit.imageList[0].src_img_norm+" class='img_prod2'/>";
					}
					else{
						html+="<img src='images/mamieclafoutis_logo.png' class='img_prod'/>";
					}
					html+="<h3 class='prod-details'>"+ produit.categorie.denomination +"</h3>"+
					"<div class='div-qty-produit'>"+
					"<label>Quantitée</label>"+
					"<input class='input-form valid-caract input-qty-panier' type='text' name='qtyPanier'>"+
					"</div>"+
					"<div>"+
					"<button class='bouton btn_ajout_prod' id='produit.id'>Ajouter au panier</button>"+
					"<button class='bouton btn_desc_prod detail-prod-class' value='"+produit.id+"'>Description</button>"+
					"</div>" +
					"</div>";
//					"<div id='myModal-prod' class='modal-prod'></div>";
				prod.innerHTML = html;
				
				
				
				var btn = document.getElementsByClassName("detail-prod-class");
				console.log(btn);
				for (var i = 0; i < btn.length; ++i) {
					btn[i].addEventListener('click', clickFunc3);

				}
				
			}
					
				var btn = document.getElementsByClassName("btn_ajout_prod");
				console.log(btn);
				
				for (var i=0; i<btn.length; ++i) {
					  btn[i].addEventListener('click', ajoutproduit);
					}	

			}
		}
	 
	}