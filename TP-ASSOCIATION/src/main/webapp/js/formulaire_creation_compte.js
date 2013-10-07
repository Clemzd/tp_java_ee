function verifierFormulaire(){
	var erreurMessage = getErreursFormulaire();
	if(erreurMessage != ""){
		alert(erreurMessage);
		return false;
	}else{
		return true;
	}
}

function getErreursFormulaire(){
	var message = new String("");
	var champObligatoire = new String("Un des champ obligatoires n'a pas été saisi");
	if($("#identifiant") == ""){
		message = champObligatoire;
	}else if($("#mot_de_passe") == ""){
		message = champObligatoire;
	}else if($("#mot_de_passe_confirmation") == ""){
		message = champObligatoire;
	}else if($("#nom_famille") == ""){
		message = champObligatoire;
	}else if($("#prenom") == ""){
		message = champObligatoire;
	}
	else if (!($("#mot_de_passe").val() == $("#mot_de_passe_confirmation").val())) {
		message = "Les mots de passes ne sont pas identiques";
	}
	return message;
}

// MERCREDI SOIR 18H30 
