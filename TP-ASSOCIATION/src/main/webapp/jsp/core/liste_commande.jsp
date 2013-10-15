<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/head.jsp"%>
<title>Commande</title>
</head>
<body>
	<%@ include file="../common/navbar.jsp"%>
	<script>
		$("li").attr("class", "");
		$("#commande").attr("class", "active");
	</script>
	<h1>Commande</h1>

	<c:if test="${not empty commandeKO}">
		<div class="alert alert-danger">${commandeKO}</div>
	</c:if>
	
	<c:choose>

		<c:when test="${empty panier }">
			<div class="alert alert-warning">Aucun article n'a encore été commandé.</div>
		</c:when>

		<c:otherwise>
			<table class="table">
				<thead>
					<tr>
						<th>Code</th>
						<th>Nom</th>
						<th>Prix unitaire</th>
						<th>Stock</th>
						<th>Quantité</th>
						<th>Total par article</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="total" value="0" />
					<c:forEach var="articlePanier" items="${panier}">
						<tr>
							<td>${articlePanier.article.code }</td>
							<td>${articlePanier.article.nom }</td>
							<td><fmt:formatNumber type="number" maxIntegerDigits="2" value="${articlePanier.article.prix}"/></td>
							<td>${articlePanier.article.stock}</td>
							<td>${articlePanier.quantite }</td>
							<td><fmt:formatNumber type="number" maxIntegerDigits="2" value="${articlePanier.article.prix * articlePanier.quantite}"/></td>
							<c:set var="total" value="${total + articlePanier.article.prix * articlePanier.quantite}" />
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<a href="Commande?annuler=true"><button
						class="btn btn-lg btn-danger btn-default">Annuler la
						commande</button></a> <a href="Commande?valider=true"><button
						class="btn btn-lg btn-primary btn-default">Valider la
						commande</button></a> <span class="alert alert-success pull-right"
					style="margin-right: 10px">Coût de la commande : <fmt:formatNumber type='number' 
            maxFractionDigits='2' value='${total}'/></span>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>