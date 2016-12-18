<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<c:if test="${empty user.idPerson}">
			<c:redirect url="/annuaires/annuaire/home"/>
		</c:if>
	<div class="container">
		
		<div id="menu">
			<nav class="navbar navbar-inverse">
				 <div class="container-fluid">
					 <ul class="nav navbar-nav">
						 <li><a href="person?idPerson=${user.idGroup}">Profil</a></li>
					     <li><a href="listofGroup">Liste de groupe </a></li>
					   <li><a href="listofPerson?idGroup=${user.idGroup}">Liste des Personnes </a></li>
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
		<c:when test="${listGroupRecherche.size() >0 }">
			<h2> Resultat dans le groupe  </h2>
				<hr>
				
				<table>
					<tr>
						<th>Numero de Groupe </th>
						<th>Nom de Groupe </th>
					</tr>
						<c:forEach items="${listGroupRecherche}" var="group">
							<tr>
								<td> <a href="listofPerson?idGroup=${group.idGroup}"> <c:out value="${group.idGroup}"/></a></td>
								<td> <a href="listofPerson?idGroup=${group.idGroup}"> <c:out value="${group.name}"></c:out></a></td>
							</tr>
						</c:forEach>
					
				</table>
			</c:when>
			<c:when test="${listPersonRecherche.size()>0 }">	
				<h2> Resultat des personnes trouvé</h2>
				
			<hr>
			
			<table>
				<tr>
					<th>Numero </th>
					<th>Nom </th>
					<th>Prénom </th>
				</tr>
				<c:forEach items="${listPersonRecherche}" var="person">
				
					<tr>
						<td> <a href="person?idPerson=${person.idPerson}"> <c:out value="${person.idPerson}"/></a></td>
						<td> <a href="person?idPerson=${person.idPerson}"> <c:out value="${person.lastName}"></c:out> </a></td>
						<td> <c:out value="${person.firstName}"/></td>
						
					</tr>
				</c:forEach>		
			</table>
		</c:when>
		<c:otherwise>
			Votre recherche n'a donné aucune resultat.
		</c:otherwise>
	</c:choose>
</body>
</html>