<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../head/head.jsp" %>
<title>Commande</title>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="collapse navbar-collapse navbar-ex1-collapse">
	          <ul class="nav navbar-nav">
	            <li class="active"><a href="#">Accueil</a></li>
	            <li><a href="Catalogue">Articles</a></li>
	            <li><a href="Commande">Commande</a></li>
	          </ul>
	        </div>
		<div>
	</nav>
	<h1>Commande</h1>
			<table class="table">
		<thead>
			<tr>
				<th>Code</th>
				<th>Nom</th>
				<th>Prix</th>
				<th>Stock</th>
				<th>Quantité</th>
				<th></th>
			</tr>
		</thead>
			<c:forEach var="articlePanier" items="${panier}">
				<tr>
					<td>${articlePanier.article.code }</td>
					<td>${articlePanier.article.nom }</td>
					<td>${articlePanier.article.prix }</td>
					<td>${articlePanier.article.stock}</td>
					<td>${articlePanier.quantite }</td>
				</tr>
			</c:forEach>
</body>
</html>