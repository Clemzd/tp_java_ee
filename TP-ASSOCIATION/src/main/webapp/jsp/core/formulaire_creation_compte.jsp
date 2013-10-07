<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../head/head.jsp" %>
<title>Enregistrez-vous</title>
</head>
<body>
	Affichage de l'attribut passé en paramètre : ${test}
	<h1>Enregistrez-vous</h1>
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label for="identifiant" class="col-lg-1 control-label">Identifiant</label>
			<div class="col-lg-5">
				<input type="text" class="form-control" id="identifiant"
					placeholder="Identifiant">
			</div>
		</div>
		<div class="form-group">
			<label for="mot_de_passe" class="col-lg-1 control-label">Mot
				de passe</label>
			<div class="col-lg-5">
				<input type="password" class="form-control" id="mot_de_passe"
					placeholder="Mot de passe">
			</div>
		</div>
		<div class="form-group">
			<label for="motDePasseConfirmation" class="col-lg-1 control-label">Mot
				de passe (confirmation)</label>
			<div class="col-lg-5">
				<input type="password" class="form-control"
					id="mot_de_passe_confirmation"
					placeholder="Confirmation du mot de passe">
			</div>
		</div>
		<div class="form-group">
			<label for="nom_famille" class="col-lg-1 control-label">Nom
				de famille</label>
			<div class="col-lg-5">
				<input type="text" class="form-control" id="nom_famille"
					placeholder="Nom de famille">
			</div>
		</div>
		<div class="form-group">
			<label for="prenom" class="col-lg-1 control-label">Prenom</label>
			<div class="col-lg-5">
				<input type="prenom" class="form-control" id="prenom"
					placeholder="Prenom">
			</div>
		</div>
		<div class="form-group">
			<label for="adresse" class="col-lg-1 control-label">Adresse
				(rue)</label>
			<div class="col-lg-5">
				<input type="text" class="form-control" id="adresse"
					placeholder="Adresse">
			</div>
		</div>
		<div class="form-group">
			<label for="codePostal" class="col-lg-1 control-label">Code
				Postal</label>
			<div class="col-lg-5">
				<input type="text" class="form-control" id="code_postal"
					placeholder="Code postal">
			</div>
		</div>
		<div class="form-group">
			<label for="ville" class="col-lg-1 control-label">Ville</label>
			<div class="col-lg-5">
				<input type="text" class="form-control" id="ville"
					placeholder="Ville">
			</div>
		</div>
		<div class="form-group">
			<label for="pays" class="col-lg-1 control-label">Pays</label>
			<div class="col-lg-5">
				<input type="text" class="form-control" id="pays" placeholder="Pays">
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-2">
				<button type="submit" class="btn btn-default">Enregistrer</button>
			</div>
		</div>
	</form>
</body>
</html>