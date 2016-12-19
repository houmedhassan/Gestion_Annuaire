package com.application.Test.daoModelTest;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.application.beans.Group;
import com.application.beans.Person;
import com.application.business.DaoException;
import com.application.business.PersonImpDao;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:WebContent/WEB-INF/springDataSource.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@ActiveProfiles(profiles="PersonDAO")
@DatabaseSetup(value= {"Groups.xml", "Person.xml"})
@DatabaseTearDown(value = { "cleanGroups.xml", "cleanPerson.xml" })

public class PersonImplDaoTest {
	
	@Autowired
	private PersonImpDao persDao;
	
	@Autowired
	DataSource dataSource;
	
	
	
	@Before
	public void setUp() throws SQLException, DatabaseUnitException{
		this.persDao.setDataSource(dataSource);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void findAllPersonsTest() throws DaoException {
		Collection<Person> allPersons = persDao.findAllPersons(1);
		assertEquals(3, allPersons.size());
	}
	
	@Ignore
	public void findAllGroupsTest()throws DaoException{
		Collection<Group> allGroups = persDao.findAllGroups();
		assertEquals(2, allGroups.size());
	}
	
	@Test
	public void findPersonTest()throws DaoException{
		Person per = persDao.findPerson(2);
		assertEquals("Rébecca", per.getLastName());
		assertEquals("Armand", per.getFirstName());
		assertEquals("SaintBois@gmail.com", per.getMail());
		assertEquals("ara.com", per.getWebSite());
		assertEquals("1929-02-03", per.getBirthDay());
		assertEquals("lsKss4;", per.getPassword());
		//assertEquals(1L, per.getIdGroup());
	}
	
	@Test
	public void findGroupTest()throws DaoException{
		Group gr = persDao.findGroup(1);
		assertEquals("isl", gr.getName());
	}
	
	@Test
	@ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT, value ="personAfterCreation.xml")
	public void savePersonTest() throws DaoException{
		//creation of person
		Person p = new Person();
		p.setIdPerson(5L);
		p.setLastName("Bob");
		p.setFirstName("Alice");
		p.setMail("azerty@amu-mrs.fr");
		p.setWebSite("AliceBob.com");
		p.setBirthDay("2016-12-31");
		p.setPassword("Password123!");
		p.setIdGroup(1L);
		persDao.savePerson(p);
	}
	
	@Test
	@ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT, value="groupsAfterCreation.xml")
	public void saveGroupTest() throws DaoException{
		Group g = new Group();
		g.setIdGroup(3);
		g.setName("gth");
		persDao.saveGroup(g);
	}
	
	@Test
	@ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT, value="personAfterModif.xml")
	public void editPersonTest() throws DaoException{
		//creation of person
		Person p = new Person();
		p.setIdPerson(3L);
		p.setLastName("Bob");
		p.setFirstName("Alice");
		p.setMail("azerty@amu-mrs.fr");
		p.setWebSite("AliceBob.com");
		p.setBirthDay("2016-12-31");
		p.setPassword("Password123!");
		p.setIdGroup(1L);
		persDao.editPerson(3, p);
	}
	
	@Test
	public void findPersonsTest()throws DaoException{
		
		Person per = persDao.findPersons("haha@hotmail.fr");
		assertEquals("Rébecca", per.getLastName());
		assertEquals("Armand", per.getFirstName());
		assertEquals("Saint-Didier-des-Bois", per.getMail());
		assertEquals("ara.com", per.getWebSite());
		assertEquals("1929-02-03", per.getBirthDay());
		assertEquals("lskss", per.getPassword());
		//assertEquals(1L, per.getIdGroup());
	}
	
	
}
