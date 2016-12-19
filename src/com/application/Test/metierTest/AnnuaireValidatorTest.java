package com.application.Test.metierTest;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

import com.application.beans.Person;
import com.application.metier.AnnuaireValidator;

//@RunWith(MockitoJUnitRunner.class)
public class AnnuaireValidatorTest {

	//@Mock private Validator annuaireValidator;
	Validator annuaireValidator;
	
	@Before
	public void setUp() throws Exception {
	/*	Mockito.when(annuaireValidator.supports(Person.class)).thenReturn(true);
		Mockito.verify(annuaireValidator).supports(Person.class);
		
		Mockito.reset(annuaireValidator);
		*/
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void validatePersonTest(){
		annuaireValidator = new AnnuaireValidator();
		Person person = new Person();
		person.setIdPerson(1234567L);
		person.setLastName("HASSAN MOHAMED");
		person.setFirstName("houmed");
		person.setMail("houmedhassan@outlook.com");
		person.setWebSite("www.houmedhassan.com");
		person.setBirthDay("2016-10-31");
		person.setPassword("123456");
		person.setPasswordConfirmation("123456");
		person.setIdGroup(1L);
		
		BindException errors = new BindException(person, "person");
		annuaireValidator.validate(person, errors);
	    assertFalse(errors.hasErrors()); 
	}
	
	@Test (expected= AssertionError.class)
	public void inValidateConfirmationPassword(){
		annuaireValidator = new AnnuaireValidator();
		Person person = new Person();
		person.setIdPerson(1234567L);
		person.setLastName("HASSAN MOHAMED");
		person.setFirstName("houmed");
		person.setMail("houmedhassan@outlook.com");
		person.setWebSite("www.houmedhassan.com");
		person.setBirthDay("2016-10-31");
		
		person.setPassword("123456");
		person.setPasswordConfirmation("1234");
		person.setIdGroup(1L);
		
		BindException errors = new BindException(person, "person");
		annuaireValidator.validate(person, errors);
	    assertFalse(errors.hasErrors());
		
	}

	@Test (expected= AssertionError.class)
	public void inValidateEmptyLastName(){
		annuaireValidator = new AnnuaireValidator();
		Person person = new Person();
		person.setIdPerson(1234567L);
		person.setLastName("");
		person.setFirstName("houmed");
		person.setMail("houmedhassan@outlook.com");
		person.setWebSite("www.houmedhassan.com");
		person.setBirthDay("2016-10-31");
		
		person.setPassword("123456");
		person.setPasswordConfirmation("1234");
		person.setIdGroup(1L);
		
		BindException errors = new BindException(person, "person");
		annuaireValidator.validate(person, errors);
	    assertFalse(errors.hasErrors());	
	}
	
	@Test (expected= AssertionError.class)
	public void inValidateLastName(){
		annuaireValidator = new AnnuaireValidator();
		Person person = new Person();
		person.setIdPerson(1234567L);
		person.setLastName("h");
		person.setFirstName("houmed");
		person.setMail("houmedhassan@outlook.com");
		person.setWebSite("www.houmedhassan.com");
		person.setBirthDay("2016-10-31");
		
		person.setPassword("123456");
		person.setPasswordConfirmation("1234");
		person.setIdGroup(1L);
		
		BindException errors = new BindException(person, "person");
		annuaireValidator.validate(person, errors);
	    assertFalse(errors.hasErrors());	
	}
	
	@Test (expected= AssertionError.class)
	public void inValidateBirthDay(){
		annuaireValidator = new AnnuaireValidator();
		Person person = new Person();
		person.setIdPerson(1234567L);
		person.setLastName("HASSAN MOHAMED");
		person.setFirstName("houmed");
		person.setMail("houmedhassan@outlook.com");
		person.setWebSite("www.houmedhassan.com");
		person.setBirthDay("3-10-20161");
		
		person.setPassword("123456");
		person.setPasswordConfirmation("1234");
		person.setIdGroup(1L);
		
		BindException errors = new BindException(person, "person");
		annuaireValidator.validate(person, errors);
	    assertFalse(errors.hasErrors());	
	}

	@Test (expected= AssertionError.class)
	public void inValidatePatternEmail(){
		annuaireValidator = new AnnuaireValidator();
		Person person = new Person();
		person.setIdPerson(1234567L);
		person.setLastName("");
		person.setFirstName("houmed");
		person.setMail("houmedhassan@.com");
		person.setWebSite("www.houmedhassan.com");
		person.setBirthDay("2016-10-31");
		
		person.setPassword("123456");
		person.setPasswordConfirmation("1234");
		person.setIdGroup(1L);
		
		BindException errors = new BindException(person, "person");
		annuaireValidator.validate(person, errors);
	    assertFalse(errors.hasErrors());
		
	}
}
