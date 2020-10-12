package com.proyectofinal.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.proyectofinal.web.model.Member;
/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email: lauarangom@gmail.com
 * Creation date: 09/05/2019
 * Last modification: 23/05/2019
 */
public class MemberDaoImpl implements MemberDao {
	/**
	 * DataSource an JbdcTemplate are classes and interfaces from sql to generate querys.
	 */
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	//Implementation of the getUsersByProjectId function definite in MemberDao.java  
	@Override
	public List<Member> getUsersByProjectId(int id){
		String sql = "SELECT * FROM projectsxuser INNER JOIN users ON(projectsxuser.userId = users.id) WHERE projectId = '" + id + "'";
		return jdbcTemplate.query(sql, new MemberMapper());
	}
	//Implementation of the linkProjectWithUser function definite in MemberDao.java  
	@Override
	public void linkProjectWithUser(int projectId, String role, int userId) {
		String sql = "INSERT INTO projectsxuser(userId, role,projectId) VALUES (?,?, ?)";
	    jdbcTemplate.update(sql, new Object[] { userId, role,projectId});
	}
	//Implementation of the getMemberByUpId function definite in MemberDao.java
	@Override
  	public Member getMemberByUpId(int userId,int projectId) {
		String sql = "SELECT * FROM projectsxuser INNER JOIN users ON(projectsxuser.userId = users.id) WHERE projectId = '" + projectId + "' AND userId = '" + userId + "'" ;
		List<Member> memberList = jdbcTemplate.query(sql, new MemberMapper());
		if (memberList.isEmpty()) {
			return null;
		}
		return memberList.get(0);

	}
}
//The mapper is to create a new object of the class.
class MemberMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Member(rs.getInt("id"), rs.getInt("userId"),rs.getString("role"),rs.getInt("projectId"));
	}
	
}
