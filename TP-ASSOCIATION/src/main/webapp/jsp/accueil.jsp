<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<title>Accueil</title>
</head>
<body>
	<div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Accueil</a></li>
            <li><a href="liste_catalogue.jsp">Articles</a></li>
            <li><a href="liste_commande.jsp">Commande</a></li>
          </ul>
        </div>
	<div>
		<h1>Bienvenue sur le site des adhérents de l'association.</h1>
	</div>
	<div class="nav nav-pills nav-stacked">
		<ul>
			<li>
				<a href="liste_catalogue.jsp">
				Consulter les articles disponibles.
				</a>
			</li>
			<li>
				<a href="liste_commande.jsp">
				Consulter votre commande.
				</a>
			</li>
		</ul>
	</div>
</body>
</html>