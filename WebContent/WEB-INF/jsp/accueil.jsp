<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value="/ressources/css/style.css" />" >
	<title>Liste des personnes </title>
</head>
<body>
	<div class="container">
		
		
		<div id="bienvenue">Bienvenue sur la page d'accueil du gestion d'annuaire.</div>	
		<hr>
		<div class="container-form">
		 <div class="modal-dialog">
  
	      <div class="modal-body">
		<form:form action="log" modelAttribute="loginPers" method="POST" class="form-horizontal">
			<div class="imgcontainer">
		    	<img src="<c:url value="/ressources/images/profil-image.png"/>" alt="profil-image"  class="loginAvatar" width="200" heigth="150"/>
		  	</div>
			<form:errors path="mail" cssClass="error"/>  <br/>
			<form:errors path="password" cssClass="error"/>	<br/>
				
				
			    <div class="form-group">
	              <input type="text" name="mail" class="form-control input-lg" placeholder="saisir votre EMAIL">
	            </div>
	            
	            <div class="form-group">
	              <input type="password"  name="password"  class="form-control input-lg"placeholder="Saisir votre Password">
	            </div>
	          	        
			        
			    <div class="form-group" id="button">
	              <span class="pull-right"><a href="#">mot de passe Perdu !!!</a></span><br/>
	              <button type="submit" class="btn btn-success btn-lg">se connecter</button>
			 	  <a href="ajoutform"> <button type="button" class="btn btn-primary btn-lg">s'inscrire</button></a>
	              
	            </div>
  		</form:form>
  		
  		</div>
  	</div>
		
	      
	  	
	  	
	  	
	  <!-- 	
	  <div class="modal-dialog">
  
	      <div class="modal-body">
	          <form class="form col-md-12 center-block"action="log" modelAttribute="loginPers" method="POST">
	          	
				<div class="imgcontainer">
		    		<img src="<c:url value="/ressources/images/profil-image.png"/>" alt="profil-image"  class="loginAvatar" width="200" heigth="150"/>
				</div>
				<div>
				<form:errors path="mail" cssClass="error"/>  <br/>
				<form:errors path="password" cssClass="error"/>	<br/>
	           </div>
	            <div class="form-group">
	              <input type="text" name="mail" class="form-control input-lg" placeholder="saisir votre EMAIL">
	            </div>
	            
	            <div class="form-group">
	              <input type="password"  name="password"  class="form-control input-lg"placeholder="Saisir votre Password">
	            </div>
	          	          
	            <div class="form-group" id="button">
	              <span class="pull-right"><a href="#">mot de passe Perdu !!!</a></span><br/>
	              <button type="submit" class="btn btn-success btn-lg">se connecter</button>
			 	  <a href="ajoutform"> <button type="button" class="btn btn-primary btn-lg">s'inscrire</button></a>
	              
	            </div>
         	 </form>  
	      </div>
	      
	  </div>
	  	-->
	  	
	  	
	  	
	  	
	  	
	  	
	  	</div>
	</div>	
		<!-- boostrap jquery and boostrap javaScript link -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>