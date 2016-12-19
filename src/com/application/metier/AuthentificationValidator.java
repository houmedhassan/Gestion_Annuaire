package com.application.metier;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.application.beans.Person;
import com.application.business.DaoException;
import com.application.business.PersonDao;

@Component
public class AuthentificationValidator implements Validator{
	
	@Autowired
	PersonDao personDao;
	
	@Autowired
	private MailSender mailSender;
	@Autowired
	private SimpleMailMessage templateMessage;
	
	
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
	
	/**
	 * 
	 * @param mail
	 * @param password
	 * @param target
	 * @param error
	 * @return
	 */
	public Person login(String mail, String password, Object target, Errors error){
		Person pers = (Person) target;
		
		Person person=null;
		try{
		person= personDao.loginPerson(mail, password);
		}catch(Exception ex){
			error.rejectValue("password", "person.password", "veuillez resaisir votre email et/ou votre mot de passe");
		}
		
		return person;
	}

	/**
	 * 
	 * @param mail
	 * @param target
	 * @param error
	 * @throws DaoException
	 */
	public Person sendMailPasswordRecovery( String mail, Object target, Errors error) {
		
		Person person =(Person) target;
		try{	
		person= personDao.findPersons(mail);	
			SimpleMailMessage message = new SimpleMailMessage(this.templateMessage);
				message.setTo(person.getLastName());
				message.setText("Monsieur ou Madame votre Mot de passe est : "+person.getPassword());
				try {
					this.mailSender.send(message);
				} catch (MailException ex) {
					error.rejectValue("mail", "person.mail", "desole il y a eu une erreur");
				}
		}catch(Exception e){
			error.rejectValue("mail", "person.mail", "desole votre mail n'est pas correcte, il est inconnu de nous");
			
		}
		return person;
	}
	
	
	
}
