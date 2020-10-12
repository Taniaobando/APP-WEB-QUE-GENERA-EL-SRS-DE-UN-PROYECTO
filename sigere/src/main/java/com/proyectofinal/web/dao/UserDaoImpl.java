package com.proyectofinal.web.dao;

/**
 * Project:Sigere
 * Developer:Verónica Tofiño
 * Contact email: veronicatofino@gmail.com
 * Creation date: 23/04/2019
 * Last modification: 15/05/2019
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.proyectofinal.web.model.Login;
import com.proyectofinal.web.model.User;

public class UserDaoImpl implements UserDao {
	/**
	 * DataSource an JbdcTemplate are classes and interfaces from sql to generate querys.
	 */
  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;
  	//Implementation of the register function definite in UserDao.java  
  	public void register(User user) {

	    String sql = "insert into users(username, password, firstname, lastname, email) values(?,?,?,?,?)";
	
	    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
	        user.getLastname(), user.getEmail() });
  	}
  	//Implementation of the validateUser function definite in UserDao.java  
  	public User validateUser(Login login) {

	    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
	        + "'";
	
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	
	    return users.size() > 0 ? users.get(0) : null;
  	}
  	//Implementation of the existsUser function definite in UserDao.java   
  	@Override
	public boolean existsUser(User user) {
		String sql = "SELECT * from users where username = '" + user.getUsername() + "'";
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() == 1;
	}
  	//Implementation of the getIdByUser function definite in UserDao.java    
  	@Override
	public int getIdByUser(User user) {
		String sql = "SELECT id from users where username = '" + user.getUsername() + "'";
		List<Integer> ans = jdbcTemplate.query(sql, new IdMapper());
		if (ans.isEmpty()) {
			return -1;
		}
		return ans.get(0);
	}
  //Implementation of the getUserById function definite in UserDao.java  
  	@Override
	public User getUserById(int id) {
	  	String sql = "select * from users where id='" + id + "'";

	  	List<User> users = jdbcTemplate.query(sql, new UserMapper());

	  	return users.size() > 0 ? users.get(0) : null;
	}
	//Implementation of the getIdByEmail function definite in UserDao.java  
  	@Override
  	public int getIdByEmail(String email) {
		String sqlString="select * from users where email='" + email + "'";
		List<Integer> idEm = jdbcTemplate.query(sqlString, new IdMapper());
		if (idEm.isEmpty()) {
			return -1;
		}
		return idEm.get(0);
  	}
  	
  	

}
//The mappers are to create a new object of the class.
class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();

    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setFirstname(rs.getString("firstname"));
    user.setLastname(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));
    user.setId(rs.getInt("id"));

    return user;
  }
}

class IdMapper implements RowMapper<Integer> {

	@Override
	public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getInt("id");
	}
	
}