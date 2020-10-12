package com.proyectofinal.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
/**
 * Project:Sigere
 * Developer:Tania Obando
 * Contact email: taniaobando1998@gmail.com
 * Creation date: 25/05/2019
 * Last modification: 29/05/2019
 */

public class MailDaoImpl implements MailDao {
	/**
	 * DataSource an JbdcTemplate are classes and interfaces from sql to generate querys.
	 */
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	//Implementation of the getPasswordByEmail function definite in MemberDao.java
	@Override
	public String getPasswordByEmail(String email) {
		/*String sqlString="select * from users where email='" + email + "'";
		List<User> user = jdbcTemplate.query(sqlString, new UserMapper());
		if (user.isEmpty()) {
			return "-1";
		}
		String psswrd=user.get(0).getPassword();
		return psswrd;*/
		String sqlString="select * from users where email='" + email + "'";
		List<String> Em = jdbcTemplate.query(sqlString, new MailMapper());
		if (Em.isEmpty()) {
			return "-1";
		}
		return Em.get(0);
		
  }

	//The mapper is to create a new object of the class.
	class MailMapper implements RowMapper<String> {

		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("password");
		}
		
	}
}

	

	
	





