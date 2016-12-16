<%@ include file="/WEB-INF/jsp/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value="/ressources/css/style.css" />" >
	<title>Liste des Groupes </title>
	</head>
	<body>
		<div class="container">
		
		<div id="menu">
			<nav class="navbar navbar-inverse">
				 <div class="container-fluid">
					 <ul class="nav navbar-nav">
						 <li><a href="person?idPerson=${user.idPerson }">Profil</a></li>
					     <li><a href="#">Liste de groupe </a></li>
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
		
		<table>
			<tr>
				<th>Numero de Groupe </th>
				<th>Nom de Groupe </th>
			</tr>
				<c:forEach items="${listGroup}" var="group">
					<tr>
						<td> <a href="listofPerson?idGroup=${group.idGroup}"> <c:out value="${group.idGroup}"/></a></td>
						<td> <a href="listofPerson?idGroup=${group.idGroup}"> <c:out value="${group.name}"></c:out></a></td>
					</tr>
				</c:forEach>
			
		</table>
		<!-- boostrap jquery and boostrap javaScript link -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</body>
</html>