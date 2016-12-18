package com.application.Test.metierTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.application.beans.Person;
import com.application.metier.AnnuaireValidator;

public class AnnuaireValidatorTest {

	@Autowired
	AnnuaireValidator annuaireValidator;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void validateTest(){
		Person person = new Person();
		person.setIdPerson(1234567L);
		person.setLastName("HASSAN MOHAMED");
		person.setFirstName("houmed");
		person.setMail("houmedhassan@outlook.com");
		person.setBirthDay("2016-10-31");
		person.setIdGroup(1L);
		
		BindingResult result = null;
		annuaireValidator.validate(person, result);
		
	}


}
