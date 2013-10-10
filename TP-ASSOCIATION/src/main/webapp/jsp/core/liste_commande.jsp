<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/head.jsp"%>
<title>Commande</title>
</head>
<body>
	<%@ include file="../common/navbar.jsp"%>
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
		<tbody>
			<c:forEach var="articlePanier" items="${panier}">
				<tr>
					<td>${articlePanier.article.code }</td>
					<td>${articlePanier.article.nom }</td>
					<td>${articlePanier.article.prix }</td>
					<td>${articlePanier.article.stock}</td>
					<td>${articlePanier.quantite }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>