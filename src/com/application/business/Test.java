package com.application.business;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.application.beans.Group;
import com.application.beans.Person;
/**
 * 
 * @author HOUMED, ABDOULRAHIM
 * 
 * This class allows to test the operation and to display in the console the result.
 * it contains the main function
 *
 */
public class Test {

	public static void main(String[] args) throws DaoException {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("file:WebContent/WEB-INF/springDataSource.xml");
		PersonImpDao persondao = (PersonImpDao) ctx.getBean("PersonDAO");
		//PersonDao persondao = new PersonImpDao();
		//PersonImpDao persondao = new PersonImpDao();
		//creation of group
		/*Group g = new Group();
		g.setIdGroup(3L);
		g.setName("gth");
		*/
		//creation of person
		Person p = new Person();
		//p.setIdPerson(13);
		p.setIdPerson(5L);
		p.setLastName("Bob");
		p.setFirstName("Alice");
		p.setMail("azerty@amu-mrs.fr");
		p.setWebSite("AliceBob.com");
		p.setBirthDay("2016-12-31");
		p.setPassword("Password123");
		p.setIdGroup(1L);
		

		try{
		
			//persondao.saveGroup(g);
			//persondao.savePerson(p);
			
			// test of running of the method findAllGRoups
		Collection<Group> groups =persondao.searchGroupByName("houmed");
		int i=0;
		for(Group grps : groups){
			if(i==0){
			System.out.println("*****************Liste des groupes"+grps.getIdGroup() +"***********************");
			}
            System.out.println(grps.getIdGroup() + "\t" + grps.getName());	
            i++;
		}
			// test of running of the method findAllPersons
		Collection<Person> persons = persondao.searchPersonByName("hamoud", "hamoud");
		int j=0;
		for(Person pers : persons){
			if(j==0){
			System.out.println("******************Liste des Personnes du groupe"+pers.getIdGroup() +"***************************");
			}
            System.out.println(pers.getIdPerson() + "\t" + pers.getLastName()+"\t" + pers.getFirstName());
            j++;
        }
			
		
		//test of the method findPerson
		System.out.println("********************** La personne à rechercher *****************************");
		Person findperson = persondao.findPersons("houmedhassan@outlook.com");
		System.out.println(findperson.getIdPerson() +" \t "+findperson.getFirstName()+"\t " +findperson.getLastName());
		
		//test of the method findPerson
		System.out.println("********************** Groupe à rechercher *****************************");
		Group findgrp = persondao.findGroup(1);
		System.out.println(findgrp.getIdGroup() +" \t "+findgrp.getName()+"\t " );
				
		//test of running of the method editPerson
		
		System.out.println("*********************Modification de la personne **********************");
		p.setFirstName("Abdoulrahim");
		int editperson = persondao.editPerson(2, p);
		System.out.println(p.getIdPerson() +" \t "+p.getFirstName()+"\t " +p.getLastName()+"\t : modification reussi");
		
		/**
		 * 
			
		*/
		
		System.out.println("**********Toutes est okkkkkkkkk********");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}

}
