package com.proyectofinal.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.proyectofinal.web.model.NoteCreate;
import com.proyectofinal.web.model.Note;
/**
 * Project:Sigere
 * Developer:Tania Obando
 * Contact email: taniaobando1998@gmail.com
 * Creation date: 15/05/2019
 * Last modification: 23/05/2019
 */
public class NoteDaoImpl implements NoteDao {
	/**
	 * DataSource an JbdcTemplate are classes and interfaces from sql to generate querys.
	 */
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	//Implementation of the linkMessageWithUser function definite in NoteDao.java
	@Override
	public void linkMessageWithUser(NoteCreate note, String sender, int id) {
		String sql = "insert into notesxuser(receiver,nte,sender,projectId) values(?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { note.getReceiver(), note.getNte(),sender,id});
	}
	//Implementation of the getNotesByName function definite in NoteDao.java
	@Override
	public List <Note> getNotesByName (String receiver, int projectId) {
		String sql = "SELECT * FROM notesxuser WHERE (receiver = '" + receiver + "' AND projectId = '"+ projectId+"')";
		return jdbcTemplate.query(sql, new NoteMapper());
	}
	
	
}
//The mapper is to create a new object of the class.
class NoteMapper implements RowMapper<Note> {

	@Override
	public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Note(rs.getString("receiver"), rs.getString("nte"),rs.getString("sender"));
	}
	
}