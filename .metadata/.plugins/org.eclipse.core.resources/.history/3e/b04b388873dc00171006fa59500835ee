/**
 * 
 */
document.addEventListener('DOMContentLoaded', function () {
	console.log('DOM contruit');
	

	
	var menu = document.getElementById('menucats');
	var btn = document.getElementsByClassName("btn_supp_prod");
	
	menu.addEventListener("change", selectcats);
	
	
	
	
	for (var i=0; i<btn.length; ++i) {
		  btn[i].addEventListener('click', deleteprod);
		}


	
	
}
);
function deleteprod(event) {
	 // alert(this.id);
	event.preventDefault();
	console.log("this");
	 
	var tr = this.parentElement.parentElement;
	var menu = document.getElementById('menucats');
	 
	 
	var xhr = new XMLHttpRequest();
		xhr.open("POST", "gestionP", true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
		var Produit = new Object();
		var ParametresProduit = new Object();
		var ParamList = new Object();
		
		Produit.id = this.id;
		
		ParamList.idParam = "switch";
		
		if(menu.value != "-1"){
			ParamList.valeurParam = "0";
		}
		else{
			ParamList.valeurParam = "1";
		}
		
		
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
				var prod = document.getElementById('tbodyprod');
				
				
				var div = document.getElementById('msgvide');
				
				tr.remove();
				console.log(prod);
				console.log(prod.childElementCount);
				if(prod.childElementCount == 0){
				prod.innerHTML = "";
				div.innerHTML = "section vide";
				}
				else{
					div.innerHTML = "";
				}

			}
		
	 
	 
	}
	
	}

	function selectcats() {
		var menu = document.getElementById('menucats');
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

			 if(menu.value != "-1"){
				var prod = document.getElementById('tbodyprod');
				var div = document.getElementById('msgvide');
				div.innerHTML = "section vide";
				var html = "";
				if(objectProduit != null){
				for(var produit of objectProduit){
					html+="<tr>"+
					"<td>"+ produit.categorie.denomination +"</td>"+
					"<td>"+ produit.nom +"</td>";
					if(produit.imageList!==undefined){
						html+="<td><img src=images/photo/"+produit.imageList[0].src_img_norm+" class='img_prod'/></td>";
					}
					else{
						html+="<td><img src='images/mamieclafoutis_logo.png' class='img_prod'/></td>";
					}
					html+="<td><button class='bouton btn_supp_prod' id="+produit.id+">Rendre indisponible</button></td>"+
					"</tr>";
			 }
				prod.innerHTML = html;
				div.innerHTML = "";
				}else{
					 prod.innerHTML = ""
						 div.innerHTML = "section vide";
				 }
				
			}
			 else{
				 
				 var prod = document.getElementById('tbodyprod');
				 var div = document.getElementById('msgvide');
					div.innerHTML = "section vide";
					var html = "";
					if(objectProduit != null){
					for(var produit of objectProduit){
				
						html+="<tr>"+
						"<td>"+ produit.categorie.denomination +"</td>"+
						"<td>"+ produit.nom +"</td>";
						if(produit.imageList!==undefined){
							html+="<td><img src=images/photo/"+produit.imageList[0].src_img_norm+" class='img_prod'/></td>";
						}
						else{
							html+="<td><img src='images/mamieclafoutis_logo.png' class='img_prod'/></td>";
						}
						html+="<td><button class='bouton btn_supp_prod' id="+produit.id+">Rendre disponible</button></td>"+
						"</tr>";
				
						}//for
					prod.innerHTML = html;
					div.innerHTML = "";
				 }else{
					 prod.innerHTML = ""
						 div.innerHTML = "section vide";
				 }
					
					
			 }
			
			 }//fonction
					
				var btn = document.getElementsByClassName("btn_supp_prod");
				console.log(btn);
				
				for (var i=0; i<btn.length; ++i) {
					  btn[i].addEventListener('click', deleteprod);
					}	

			}
		
	 
	}