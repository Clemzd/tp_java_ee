<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/head.jsp"%>
<title>Accueil</title>
</head>
<body>
	<%@ include file="../common/navbar.jsp"%>
	<script>
		$("li").attr("class", "");
		$("#accueil").attr("class", "active");
	</script>
	<h1>Bienvenue sur le site des adh�rents de l'association.</h1>
	<div class="jumbotron">
			<a href="Catalogue">Consulter les articles disponibles. </a><br /> 
			<a href="Commande">Consulter votre commande. </a>
	</div>
</body>
</html>
