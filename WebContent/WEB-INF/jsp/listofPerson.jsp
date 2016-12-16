<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value="/ressources/css/style.css" />" >
	<title>Liste des personnes </title>
</head>
<body>
	<div class="container">
		
		<div id="menu">
			<nav class="navbar navbar-inverse">
				 <div class="container-fluid">
					 <ul class="nav navbar-nav">
						 <li><a href="person?idPerson=${user.idPerson }">Profil</a></li>
					     <li><a href="listofGroup">Liste de groupe </a></li>
					     <li><a href="#">Liste des Personnes </a></li>
					 </ul>
					 <form class="navbar-form navbar-right" action="recherche?search=search">
					 <div class="form-group">
					        <input type="text" name="search" placeholder="le nom du groupe ou de la personne" class="form-control">
				      </div>
				      <button type="submit" class="btn btn-default">Recherche</button>
				    </form>
				 </div>
			</nav>
			<ul id="menu_h">
				<li><a href="logout" id="deconnexion"> Deconnexion </a>
			</ul>
		</div>
	<hr>
	
	<c:choose>
		<c:when test="${listPerson.size()>0 }">
			<table>
				<tr>
					<th>Numero </th>
					<th>Nom </th>
					<th>Prénom </th>
					<th>site web </th>
				</tr>
				<c:forEach items="${listPerson}" var="person">
					<tr>
						<td> <a href="person?idPerson=${person.idPerson}"> <c:out value="${person.idPerson}"/></a></td>
						<td> <a href="person?idPerson=${person.idPerson}"> <c:out value="${person.lastName}"></c:out> </a></td>
						<td> <c:out value="${person.firstName}"/></td>
						<td> <c:out value="${person.webSite}"/></td>
					</tr>
				</c:forEach>		
			</table>
		</c:when>
		<c:otherwise>
			Désole pour l'instant aucune personne n'est inscrit dans cette groupe.
		</c:otherwise>
	</c:choose>
	<!-- boostrap jquery and boostrap javaScript link -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
</body>
</html>