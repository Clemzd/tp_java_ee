<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/head.jsp"%>
<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">

<title>Login</title>
</head>
<body>
	</tbody>
	<c:if test="${not empty error}">
		<div class="alert alert-danger">${error}</div>
	</c:if>

	<div class="container">

		<form class="form-signin" method="post">
			<h2 class="form-signin-heading">Login</h2>
			<input type="text" class="form-control" placeholder="Identifiant" autofocus id="id" name="id" > 
			<input type="password" class="form-control" placeholder="Mot de passe" id="mdp" name="mdp"> 	
			<button class="btn btn-lg btn-primary btn-block" type="submit">OK</button>
			<p> 
				Pas encore enregistré ? <a href="./CreationCompte">Créez votre compte...</a>
			</p>
		</form>

	</div>
	<!-- /container -->

	<!-- 	<h1>Login</h1> -->

	<!-- 	<form class="form-horizontal" role="form" method="post"> -->
	<!-- 		<div class="form-group"> -->
	<!-- 			<label for="intputIdentifiant" class="col-lg-2 control-label">Identifiant</label> -->
	<!-- 			<div class="col-lg-10"> -->
	<!-- 				<input type="text" class="form-control" id="id" name="id" placeholder="Identifiant"> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 		<div class="form-group"> -->
	<!-- 			<label for="inputPassword1" class="col-lg-2 control-label">Mot de passe</label> -->
	<!-- 			<div class="col-lg-10"> -->
	<!-- 				<input type="password" class="form-control" id="mdp" name="mdp" placeholder="Mot de passe"> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 		<div class="form-group"> -->
	<!-- 			<div class="col-lg-offset-2 col-lg-10"> -->
	<!-- 				<button type="submit" class="btn btn-default">OK</button> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 		<p> -->
	<!-- 			Pas encore enregistrez ? <a href="./CreationCompte">Creez votre compte...</a> -->
	<!-- 		</p> -->
	<!-- 	</form> -->
</body>
</html>