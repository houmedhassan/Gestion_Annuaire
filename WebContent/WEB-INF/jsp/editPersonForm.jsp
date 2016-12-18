
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>editer une personne</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value="/ressources/css/style.css" />" >

</head>
<body>
		<c:if test="${empty sessionScope.user.idPerson}">
			<c:redirect url="/annuaires/annuaire/home"/>
		</c:if>
	<div class="container">
		
		<div id="menu">
			<nav class="navbar navbar-inverse">
				 <div class="container-fluid">
					 <ul class="nav navbar-nav">
						 <li><a href="person?idPerson=${user.idPerson }">Profil</a></li>
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
		<form:form  method="POST" modelAttribute="pers" action="editPerson?idPerson=${pers.idPerson}" id="formAjout">
			 
			 <fieldset>
			<div> <span class="pull-right"><a href="person?idPerson=${pers.idPerson}">cancel</a></span><br/> </div>
			 	<form:errors path="idPerson" cssClass="error"/> <br/>
			 	<label>Id Person :</label>
			 	<form:input path="idPerson" value="${person.idPerson}" disabled="true" class="form-control input-lg"/>
			 
			 	
			 	<form:errors path="lastName" cssClass="error"/> <br/>
			 	<label> Nom : </label>
			 	<!-- <input type="text" name="lastName"/> -->
			 	 <form:input path="lastName" value="${pers.lastName}" class="form-control input-lg"/><br/>
			 	
			 	<form:errors path="firstName" cssClass="error"/> <br/>	
			 	<label> Prénom : </label>
			 	<!-- <input type="text" name="firstName"/>-->
			 	 <form:input path="firstName" value="${pers.firstName}" class="form-control input-lg"/><br/>
			 	
			 	<form:errors path="mail" cssClass="error"/> <br/>
			 	<label> Adresse Mail : </label>
			 <!--	<input type="email" name="mail"/>-->		 	
			 	 <form:input path="mail" value="${pers.mail}" class="form-control input-lg"/><br/>
			 	
			 	<br/>
			 	<label> site Web: </label>
			 	<!--<input type="text" name="webSite"/>-->
			 	
			 	<form:input path="webSite" value="${pers.webSite}" class="form-control input-lg"/><br/>
			 	
			 	
			 	<form:errors path="birthDay" cssClass="error"/><br/>
			 	<label> Date de Naissance : </label>
			 	<!--<input type="date" name="birthDay"/>-->
			  	<form:input path="birthDay" value="${pers.birthDay}" class="form-control input-lg"/><br/>
			 	
			 	<form:errors path="password" cssClass="error"/><br/>
			 	<label> Password : </label>
			 	<!--<input type="password" name="password"/>-->
			  	<form:password path="password" class="form-control input-lg"/><br/>
			 	
			 	<form:errors path="passwordConfirmation" cssClass="error"/><br/>
			 	<label> Confirmation de password : </label>
			 	<!--<input type="password" name="password"/>-->
			  	<form:password path="passwordConfirmation" class="form-control input-lg"/><br/>
			 	
			 <form:errors path="idGroup" cssClass="error"/><br/>	
			 <label> Groupe: </label>
			  <form:select path="idGroup" multiple="false" class="form-control input-lg">
		            <form:option value="" label=" " />
		            <form:options items="${listGroup}" itemValue="idGroup" itemLabel="name" />
		       </form:select> <br/>
			 </fieldset>
			 <div class="form-group" id="button">
	         	<button type="submit" class="btn btn-success btn-lg">Valider</button>
			 	<a href="person?idPerson=${pers.idPerson}"> <button type="button" class="btn btn-danger btn-lg">Annuler</button></a>  
	         </div>
			 
		</form:form>
	</div>
	
	<!-- boostrap jquery and boostrap javaScript link -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>