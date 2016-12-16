
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>ajout d'une personne</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value="/ressources/css/style.css" />" >
</head>
<body>
	<div class="container">
		<h2> Ajout d'une Personne </h2>
		
		<hr>
		<form:form  method="POST" modelAttribute="pers" action="addPerson" id="formAjout">
			 
			 <fieldset>
			 	
			 	
			 	<form:errors path="lastName" cssClass="error"/> <br/>
			 	<label> Nom : </label>
			 	<input type="text" name="lastName" class="form-control input-lg"/><br/>
			 	 <%--<!--<form:input path="lastName"/>-->--%>
			 	
			 	<form:errors path="firstName" cssClass="error"/> <br/>	
			 	<label> Prénom : </label>
			 	<!-- <input type="text" name="firstName"/>-->
			 	 <form:input path="firstName" class="form-control input-lg"/><br/>
			 	
			 	<form:errors path="mail" cssClass="error"/> <br/>
			 	<label> Adresse Mail : </label>
			 <!--	<input type="email" name="mail"/>-->		 	
			 	 <form:input path="mail" class="form-control input-lg"/><br/>
			 	
			 	<br/>
			 	<label> site Web: </label>
			 	<!--<input type="text" name="webSite"/>-->
			 	
			 	<form:input path="webSite" class="form-control input-lg"/><br/>
			 	
			 	
			 	<form:errors path="birthDay" cssClass="error"/><br/>
			 	<label> Date de Naissance : </label>
			 	<!--<input type="date" name="birthDay"/>-->
			  	<form:input path="birthDay" class="form-control input-lg"/><br/>
			 	
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
	     
			   <div class="form-group" id="button">
	              <button type="submit" class="btn btn-success btn-lg">Valider</button>
			 	  <a href="home"> <button type="button" class="btn btn-danger btn-lg">Annuler</button></a>  
	            </div>
			 </fieldset>
		</form:form>
	</div>
	<script>

	<!-- boostrap jquery and boostrap javaScript link -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</script>
</body>
</html>