package com.application.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.application.beans.Group;
import com.application.beans.Person;

/**
 * 
 * @author HOUMED, ABDOULRAHIM
 *
 */


@Service("personDao")
public class PersonImpDao implements PersonDao{
	
	JdbcTemplate jdbcTemplate;
   // protected final Log logger = LogFactory.getLog(getClass());
    
   /*@PostConstruct
    public void init() {
        logger.info("Create Table");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS GROUP("+
    			"idGroup VARCHAR(10) PRIMARY KEY"+
    			"name VARCHAR(500)"+
    		")");
        
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS PERSON(" + //
                "idPerson VARCHAR(10) PRIMARY_KEY" + //
        		"lastName VARCHAR(100)"+//
                "firstName VARCHAR(100)"+//
        		"mail VARCHAR(250)"+//
                "webSite VARCHAR(250)"+//
        		"birthDay DATE"+//
                "password VARCHAR(50)" + //
        		"idGroup VARCHAR(10) FOREIGN KEY REFERENCES GROUP(idGroup) "+//
                ")");     
    }*/

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    
    final private RowMapper<Person> personMapper = new RowMapper<Person>(){
    	@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Person person =new Person();
			person.setIdPerson(rs.getLong("idPerson"));
			person.setLastName(rs.getString("lastName"));
			person.setFirstName(rs.getString("firstName"));
			person.setMail(rs.getString("mail"));
			person.setWebSite(rs.getString("webSite"));
			person.setBirthDay(rs.getString("birthDay"));
			person.setPassword(rs.getString("password"));
			person.setIdGroup(rs.getLong("idGroup"));
			return person;
    	}
    };
    
    final private RowMapper<Group> groupMapper = new RowMapper<Group>(){
		@Override
		public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Group group =new Group();
			group.setIdGroup(rs.getLong("idGroup"));
			group.setName(rs.getString("nameGroup"));
			return group;
		}
	};
    
    
	@Override
	public Collection<Group> findAllGroups(){
		// TODO Auto-generated method stub
		return this.jdbcTemplate.query("SELECT * FROM GROUPS", groupMapper);
	}

	@Override
	public Collection<Person> findAllPersons(long groupId)throws DaoException {
		// TODO Auto-generated method stub
		Collection <Person> persons=null;
		try{String sql = "SELECT * FROM PERSON WHERE idGroup=?";
		
		persons= this.jdbcTemplate.query(sql, new Object[]{groupId}, personMapper);
		}catch(Exception ex){
			/**
			 * Error message customization
			 */
			String message_error= "Incorrect result size: expected 1, actual 0";
			if(ex.getMessage().equals(message_error)){
				throw new DaoException("desole, le groupe est inconnu");
			}
			else{
				ex.printStackTrace();
			}
		}
		return persons;
	}
	
	@Override
	public Person findPerson(long idPerson)throws DaoException {
		// TODO Auto-generated method stub
		Person person = null;
		try{
		person = this.jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE IDPERSON=?",
		new Object[]{idPerson},
		personMapper
		);
		
		}catch(Exception ex){
			/**
			 * Error message customization
			 */
			String message_error= "Incorrect result size: expected 1, actual 0";
			if(ex.getMessage().equals(message_error)){
				throw new DaoException("desole, la personne que vous rechercher est inconnu");
			}
			else{
				ex.printStackTrace();
			}
		}
		return person;
		
	}

	@Override
	public Group findGroup(long groupId)throws DaoException{
		// TODO Auto-generated method stub
		Group group =null;
		try{
			group= this.jdbcTemplate.queryForObject("SELECT * FROM GROUPS WHERE IDGROUP=?",
				new Object[]{groupId},
				groupMapper);
		}catch(Exception ex){
			/**
			 * Error message customization
			 */
			String message_error= "Incorrect result size: expected 1, actual 0";
			if(ex.getMessage().equals(message_error)){
				throw new DaoException("desole, le groupe que vous rechercher est inconnu");
			}
			else{
				ex.printStackTrace();
			}
		}
		return group;
	}

	@Override
	public int savePerson(Person p) throws DaoException{
		// TODO Auto-generated method stub
		String sql="INSERT INTO PERSON VALUES("
						+"NULL"
						+",'"+p.getLastName()+"',"
						+"'"+p.getFirstName()+"',"
						+"'"+p.getMail()+"',"
						+"'"+p.getWebSite()+"',"
						+"'"+p.getBirthDay()+"',"
						+"'"+p.getPassword()+"',"
						+"'"+p.getIdGroup()+"'"
					+")";
		return this.jdbcTemplate.update(sql);
		
	}

	@Override
	public int saveGroup(Group g) throws DaoException{
		// TODO Auto-generated method stub
		String sql="INSERT INTO GROUPS VALUES(?,?)";
		return this.jdbcTemplate.update(sql, new Object[]{g.getIdGroup(), g.getName()});
	}

	@Override
	public int editPerson(long idPerson, Person p)throws DaoException{
		// TODO Auto-generated method stub
		String sql="UPDATE PERSON set lastName = ?, firstName=?, mail=?, "
					+ "webSite=?, birthDay=?, password=?, idGroup=?   where idPerson='"+idPerson+"'";
		return this.jdbcTemplate.update(sql, p.getLastName(), p.getFirstName(), p.getMail(), 
										p.getWebSite(), p.getBirthDay(),p.getPassword(), p.getIdGroup() );
	}

	@Override
	public Collection<Person> searchPersonByName(String lastName, String firstName) {
		// TODO Auto-generated method stub
		
		String sql="SELECT * FROM person WHERE lastName LIKE ? or firstName LIKE ? ";
		Collection <Person> persons=null;
		persons = this.jdbcTemplate.query(sql, new Object[]{lastName+"%", firstName+""}, personMapper);
		return persons;
	}

	@Override
	public Collection<Group> searchGroupByName(String name) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM groups WHERE nameGroup LIKE ?";
		Collection <Group> groups=null;
		groups = this.jdbcTemplate.query(sql, new Object[]{name+"%"}, groupMapper);
		return groups;
	}

	@Override
	public Person loginPerson(String mail, String password) {
		// TODO Auto-generated method stub
		Person person = null;
		String sql="SELECT * FROM person where mail=? and password=?";
		person = this.jdbcTemplate.queryForObject(sql, new Object[]{mail, password}, personMapper);
		return person;
	}

	@Override
	public Person findPersons(String mail) {
		// TODO Auto-generated method stub
		Person person = null;
		String sql="SELECT * FROM person where mail=? ";
		person = this.jdbcTemplate.queryForObject(sql, new Object[]{mail}, personMapper);
		return person;
	}

}


