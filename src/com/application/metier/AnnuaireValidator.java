package com.application.metier;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;
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

	/**
	 *  this fonction verif if the data of model is true.
	 */
	@Override
	public void validate(Object target, Errors error) {
		 Person person = (Person) target;
		 ValidationUtils.rejectIfEmptyOrWhitespace(error, "lastName", "person.lastName" ,"la donnée est obligatoire");
		 ValidationUtils.rejectIfEmptyOrWhitespace(error, "firstName", "person.firstName" ,"la donnée est obligatoire");
		 ValidationUtils.rejectIfEmptyOrWhitespace(error, "mail", "person.mail" ,"la donnée est obligatoire");
		 ValidationUtils.rejectIfEmptyOrWhitespace(error, "birthDay", "person.birthDay" ,"la donnée est obligatoire");
		 ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "person.password" ,"la donnée est obligatoire");
		 ValidationUtils.rejectIfEmptyOrWhitespace(error, "passwordConfirmation", "person.passwordConfirmation" ,"la confirmation est obligatoire");
		 
		 
		 if(person.getLastName().length()<2 || person.getLastName().length()>50){
			 error.rejectValue("lastName", "person.lastName", "le nom que vous avez fourni n'est pas correcte");
		 }
		 
		 if(person.getFirstName().length()<2 || person.getFirstName().length()>50){
			 error.rejectValue("firstName", "person.firstName", "le prénom que vous avez fourni n'est pas correcte");
		 }
		 
		 if( !person.getMail().matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )){
			 error.rejectValue("mail", "person.mail", "veuillez saisir un email valide");
		 }
		
		 if( !person.getPassword().matches( "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})" )){
			 error.rejectValue("password", "person.password", "veuillez saisir un mot de passe avec un caractere Majuscule, miniscule, chiffre et un caractere parmi @#$%");
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
	
	private static String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        } 
        return buf.toString();
    } 
	
	/**
	 * 
	 * @param pass
	 * @return the result after the pass is encrypted
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public String encrypterPasswordPerson(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		java.security.MessageDigest d = null;
	    d = java.security.MessageDigest.getInstance("SHA-1");
	    d.reset();
	    d.update(pass.getBytes("iso-8859-1"), 0, pass.length());
	    return convertToHex(d.digest());
	}
}
