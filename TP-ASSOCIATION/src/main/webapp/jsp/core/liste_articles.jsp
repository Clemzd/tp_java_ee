<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/head.jsp" %>
<title>Articles</title>
</head>
<body>
	<%@ include file="../common/navbar.jsp"%>
	<h1>Catalogue des articles</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Code</th>
				<th>Nom</th>
				<th>Prix</th>
				<th>Stock</th>
				<th></th>
		</thead>
		
		<tbody>
			<c:forEach var="article" items="${articles}">
				<tr>
					<td>${article.code }</td>
					<td>${article.nom }</td>
					<td>${article.prix }</td>
					<td>${article.stock }</td>
					<td><a href="">Commander</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>