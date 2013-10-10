<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../head/head.jsp" %>
<title>Accueil</title>
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
		<h1>Bienvenue sur le site des adhérents de l'association.</h1>
	</div>
	<div class="nav nav-pills nav-stacked">
		<ul>
			<li>
				<a href="Catalogue">
				Consulter les articles disponibles.
				</a>
			</li>
			<li>
				<a href="Commande">
				Consulter votre commande.
				</a>
			</li>
		</ul>
	</div>
</body>
</html>
