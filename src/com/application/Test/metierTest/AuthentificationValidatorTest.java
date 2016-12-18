package com.application.Test.metierTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

import com.application.beans.Person;
import com.application.metier.AnnuaireValidator;
import com.application.metier.AuthentificationValidator;

public class AuthentificationValidatorTest {

	AuthentificationValidator authentificationValidator ;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void validateDataAuthentification(){
		authentificationValidator = new AuthentificationValidator();
		Person person = new Person();
		person.setMail("houmedhassa@outlook.com");
		person.setPassword("12345");
		
		BindException errors = new BindException(person, "person");
		authentificationValidator.validate(person, errors);
	    assertFalse(errors.hasErrors());
	}
	
	@Test(expected =AssertionError.class)
	public void inValidateDataAuthentification(){
		authentificationValidator = new AuthentificationValidator();
		Person person = new Person();
		person.setMail("");
		person.setPassword("12345");
		
		BindException errors = new BindException(person, "person");
		authentificationValidator.validate(person, errors);
	    assertFalse(errors.hasErrors());
	}
	
	@Test(expected = AssertionError.class)
	public void invalidatelogin(){
		authentificationValidator = new AuthentificationValidator();

		Person person = new Person();
		person.setMail("houmedhassan@outlook.com");
		person.setPassword("jk");
		
		
		BindException errors = new BindException(person, "person");
		authentificationValidator.login(person.getMail(), person.getPassword(), person, errors);
	    assertFalse(errors.hasErrors());
	}
	
	/*@Test
	public void validatelogin(){
		authentificationValidator = new AuthentificationValidator();

		Person person = new Person();
		String a="houmedhassan@outlook.com";
		String b = "1245";
		
		
		BindException errors = new BindException(person, "person");
		authentificationValidator.login(a, b, person, errors);
	    assertFalse(errors.hasErrors());
	}
	 */
    
	
	

}
