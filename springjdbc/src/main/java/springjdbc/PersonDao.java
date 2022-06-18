package springjdbc;

import java.util.*;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDao {

	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertPerson(Persons person) {
		String SQL = "insert into Persons values (?,?, ?,?)";
		int k = jdbcTemplate.update(SQL, person.getId(),person.getFirstName(), person.getLastName(), person.getAge());
		System.out.println("Record inserted.....");
	}
	
	public void deletePerson(String name) {
		String sql = "delete from Persons where name =?";
		jdbcTemplate.update(sql,name);
		System.out.println("Record Deleted....");
	}

	public List<Persons> displayPersons() {
		String sql = "select * from Persons";
		List<Persons> persons = jdbcTemplate.query(sql, new PersonRowMapper());
		
		return persons;
	}
	
	public Persons searchPerson(String name) {
		String sql = "select * from Persons where name=?";
		Persons p = jdbcTemplate.queryForObject(sql, new Object[]{name}, new PersonRowMapper());
		return p;
	}
	

}
