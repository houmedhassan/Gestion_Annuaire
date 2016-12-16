package com.application.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author Houmed, Abdoulrahim
 *
 */
public class Person {
	
	//@NotNull(message="le numero est obligatoire")
	private Long idPerson;
	
	//@NotEmpty(message="le nom est obligatoire")
	//@Size(min=2, max=50, message=" la taille des données doit etre superieur à 2 et inferieur à 50")
	private String lastName;
	
	//@NotEmpty(message="le prénom est obligatoire")
	//@Size(min=2, max=50)
	private String firstName;
	
	//@NotEmpty(message="l'email est obligatoire")
	//@Pattern(regexp="([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message="votre email n'est pas correcte")
	private String mail;
	private String webSite;
	
	//@NotEmpty(message="la date de naissance est obligatoire")
	private String birthDay;
	
	//@NotEmpty(message="la donnée est obligatoire")
	private String password;
	
	//@NotEmpty(message="veuillez confirmer votre mot de passe")
	private String passwordConfirmation;
	
	private Long idGroup;
	
	/**
	 * Constructor
	 */
	public Person(){
		
	}
	
	/**
	 * @return idPerson of Person
	 */
	public Long getIdPerson() {
		return idPerson;
	}
	/**
	 * @param idPerson this is  represents the idPerson of the Person
	 */
	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}
	/**
	 * @return lastName of Person
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * 
	 * @param lastName this is represents the lastPerson of the  Person
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return firstName of Person
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName this is represents the firstName of the  Person
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return mail of Person
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * @param mail this is represents the mail of the person
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * @return webSite of Person
	 */
	public String getWebSite() {
		return webSite;
	}
	
	/**
	 * @param webSite  this is represents the webSite of the person
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	
	/**
	 * @return  birthDay of person
	 */
	public String getBirthDay() {
		return birthDay;
	}
	
	/**
	 * @param birthDay  this is represents the birthDay of the person
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	/**
	 * @return password of Person
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password this is represents the password of the person
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return passwordConfirmation
	 */
	public String getPasswordConfirmation(){
		return passwordConfirmation;
	}
	
	/**
	 * @param passwordConfirmation
	 * passwordConfirmation represents the confirmation of password value
	 * 
	 */
	public void setPasswordConfirmation(String passwordConfirmation){
		this.passwordConfirmation=passwordConfirmation;
	}
	
	
	/**
	 * @return idGroup of Person
	 */
	public Long getIdGroup() {
		return idGroup;
	}
	
	/**
	 * @param idGroup 
	 */
	public void setIdGroup(Long idGroup) {
		this.idGroup = idGroup;
	}	
	
}
