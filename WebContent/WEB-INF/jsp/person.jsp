<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value="/ressources/css/style.css" />" >
	<title>Description d'une personne</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty user.idPerson}">
			<c:redirect url="/annuaires/annuaire/home"/>
		</c:when>
	</c:choose>
	
	<div class="container">
		
		<div id="menu">
			<nav class="navbar navbar-inverse">
				 <div class="container-fluid">
					 <ul class="nav navbar-nav">
						 <li><a href="person?idPerson=${user.idPerson }">Profil</a></li>
					     <li><a href="listofGroup">Liste de groupe </a></li>
					     <li><a href="listofPerson?idGroup=${pers.idGroup }">Liste de personne</a></li>
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
		
			<fieldset>
				<legend> Votre Description </legend>
				<c:if test="${user.idPerson ==pers.idPerson }">
				<div id="lien_update"> <a href="editPersonForm?idPerson=${pers.idPerson }"> Mise à jour </a></div>
				</c:if>
				<ul id="blockImageUSERNAME">
					<li id="block_Image">
					
						<img src="<c:url value="/ressources/images/profil-image.png"/>" alt="profil-image"  width="200" heigth="150"/>
					</li>
					<li id="block_UserName"> 
						 <c:out value="${pers.firstName }"/>
						 <c:set var="lastName" value="${pers.lastName }"></c:set>
						 <c:set var="lastname" value="${fn:toUpperCase(lastName)}" />
						 <c:out value="${lastname }"></c:out>
					</li>
				</ul>
				
				<div id="info_Person">
						<label> Numero de la personne : </label><c:out value="${pers.idPerson}"/> <br/>
						<label>Nom : </label><c:out value="${pers.lastName }"/><br/>
						<label>Prénom : </label><c:out value="${pers.firstName}"/><br/>
						<label>Site web : </label><c:out value="${pers.webSite}"/><br/>
				</div>
			</fieldset>
			 		
	
	</div>
	
	<!-- boostrap jquery and boostrap javaScript link -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>