package com.application.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.application.beans.Person;
import com.application.business.PersonDao;

@Component
public class AuthentificationValidator implements Validator{
	
	@Autowired
	PersonDao personDao;
	
	
	@Override
	public boolean supports(Class<?> perso) {
		// TODO Auto-generated method stub
		return Person.class.isAssignableFrom(perso);
	}

	@Override
	public void validate(Object target, Errors error) {
		// TODO Auto-generated method stub
		Person person = (Person) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "mail", "person.mail" ,"veuillez saisir votre mail");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "person.password" ,"veuillez saisir un mot de passe");
	}
	
	public Person login(String mail, String password, Object target, Errors error){
		Person pers = (Person) target;
		Person person=null;
		try{
		person= personDao.loginPerson(mail, password);
		}catch(Exception ex){
			error.rejectValue("password", "person.password", ex.getMessage());
		}
		if(person ==null){
			error.rejectValue("password", "person.password", "desole, email ou password erroné");
			
		}
		return person;
	}

}
