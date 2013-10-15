<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/head.jsp"%>
<title>Articles</title>
</head>
<body>
	<%@ include file="../common/navbar.jsp"%>
	<script>
		$("li").attr("class", "");
		$("#catalogue").attr("class", "active");
	</script>

	<h1>Catalogue des articles</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Code</th>
				<th>Nom</th>
				<th>Prix</th>
				<th>Stock</th>
				<th></th>
		</thead>

		<tbody>
			<c:forEach var="article" items="${articles}" varStatus="status">
				<tr>
					<td>${article.code }</td>
					<td>${article.nom }</td>
					<td>${article.prix }</td>
					<td>${article.stock }</td>
					<td><select name="quantite${status.index}"
						id="quantite${status.index}" class="form-control">
							<c:forEach var="compteur" begin="1" end="${article.stock }">
								<option value="${compteur }">${compteur }</option>
							</c:forEach>
					</select></td>
					<td><a id="myLink${status.index}" onclick="ChangeLink(${status.index})"
						href="Commande?article.code=${article.code }&quantite=">Commander</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>

<script type="text/javascript">
	function ChangeLink(index) {
		var url = $("a#myLink"+index).attr('href') + $("#quantite"+index).val();
		$("a#myLink"+index).attr('href', url);
	}
</script>
</html>