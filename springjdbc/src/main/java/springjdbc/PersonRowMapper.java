package springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<Persons>{

	public Persons mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Persons person = new Persons();
		person.setId(rs.getInt(1));
		person.setFirstName(rs.getString(2));
		person.setLastName(rs.getString(3));
		person.setAge(rs.getInt(4));
		return person;
	}

}
