package com.application.metier;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.application.beans.Person;

/**
 * 
 * @author HOUMED, ABDOULRAHIM
 *
 */

@Component
public class AnnuaireValidator implements Validator {

	@Override
	public boolean supports(Class<?> perso) {
		// TODO Auto-generated method stub
		return Person.class.isAssignableFrom(perso);
	}

	@Override
	public void validate(Object target, Errors error) {
		 Person person = (Person) target;
		 ValidationUtils.rejectIfEmptyOrWhitespace(error, "lastName", "person.lastName" ,"la donn�e est obligatoire");
		 ValidationUtils.rejectIfEmptyOrWhitespace(error, "firstName", "person.firstName" ,"la donn�e est obligatoire");
		 ValidationUtils.rejectIfEmptyOrWhitespace(error, "mail", "person.mail" ,"la donn�e est obligatoire");
		 ValidationUtils.rejectIfEmptyOrWhitespace(error, "birthDay", "person.birthDay" ,"la donn�e est obligatoire");
		 ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "person.password" ,"la donn�e est obligatoire");
		 ValidationUtils.rejectIfEmptyOrWhitespace(error, "passwordConfirmation", "person.passwordConfirmation" ,"la confirmation est obligatoire");
		 
		 
		 if(person.getLastName().length()<2 || person.getLastName().length()>50){
			 error.rejectValue("lastName", "person.lastName", "le nom que vous avez fourni n'est pas correcte");
		 }
		 
		 if(person.getFirstName().length()<2 || person.getFirstName().length()>50){
			 error.rejectValue("firstName", "person.firstName", "le pr�nom que vous avez fourni n'est pas correcte");
		 }
		 
		 if( !person.getMail().matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )){
			 error.rejectValue("mail", "person.mail", "veuillez saisir un email valide");
		 }
		 
		 if(!person.getBirthDay().matches("\\d{4}-\\d{2}-\\d{2}")){
			 error.rejectValue("birthDay", "person.birthDay", "votre date de naissance doit etre de format yyyy-mm-dd");
		 }
		 
		 if(person.getPassword().length()<5 || person.getPassword().length()>15){
			 error.rejectValue("password", "person.password", "un password doit au moins contenir 5 caractere et au plus 15 caractere");
		 }
		 if (!person.getPassword().equals(person.getPasswordConfirmation())) {
			 error.rejectValue("passwordConfirmation","person.passwordConfirmation", "veuillez confirmer votre mot de passe ");
		 }
	}
	
	public void encrypterPasswordPerson(){
		
	}
}
