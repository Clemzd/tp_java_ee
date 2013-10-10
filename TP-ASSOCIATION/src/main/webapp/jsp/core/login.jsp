<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/head.jsp"%>

<title>Login</title>
</head>
<body>
	</tbody>
	<c:if test="${not empty error}">
		<div class="alert alert-danger">${error}</div>
	</c:if>

	<h1>Login</h1>

	<form class="form-horizontal" role="form" method="post">
		<div class="form-group">
			<label for="inputEmail1" class="col-lg-2 control-label">Identifiant</label>
			<div class="col-lg-10">
				<input type="email" class="form-control" id="id" name="id" placeholder="Email">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword1" class="col-lg-2 control-label">Mot de passe</label>
			<div class="col-lg-10">
				<input type="password" class="form-control" id="mdp" name="mdp" placeholder="Password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<button type="submit" class="btn btn-default">OK</button>
			</div>
		</div>
		<p>
			Pas encore enregistrez ? <a href="./CreationCompte">Creez votre compte...</a>
		</p>
	</form>
</body>
</html>