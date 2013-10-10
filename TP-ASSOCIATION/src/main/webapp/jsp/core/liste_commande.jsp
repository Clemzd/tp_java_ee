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
			<c:forEach var="article" items="${panier}">
				<tr>
					<td>${article.code }</td>
					<td>${article.nom }</td>
					<td>${article.prix }</td>
					<td>${article.stock }</td>
				</tr>
			</c:forEach>
</body>
</html>