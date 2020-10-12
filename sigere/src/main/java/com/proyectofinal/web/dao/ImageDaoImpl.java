package com.proyectofinal.web.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

import com.proyectofinal.web.model.Image;

/**
 * Project:Sigere
 * Developers:Tania Obando
 * Contact emails: taniaobando1998@gmail.com
 * Creation date: 02/06/2019
 * Last modification: 02/06/2019
 */
public class ImageDaoImpl implements ImageDao{
	/**
	 * DataSource an JbdcTemplate are classes and interfaces from sql to generate querys.
	 */
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	//Implementation of the inserRecords function definite in ImageDao.java
	@Override
	public int inserRecords(String name, MultipartFile image, int projectId) {

		byte[] photoBytes = null;
		try {
			photoBytes = image.getBytes();
			String sql = "INSERT INTO image(idP,nameIm,image) VALUES (?,?,?)";
			return jdbcTemplate.update(sql, new Object[] { projectId, name ,photoBytes });

		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}
	//Implementation of the infoImageList function definite in ImageDao.java
	@Override
	public List<Image> infoImageList(int idP) {
		String sql="SELECT * FROM image WHERE idP= '"+ idP + "'";
		List<Image> list = jdbcTemplate.query(sql, new ImageMapper());
		return list;
	}
	
	
	//Implementation of the getPhotoById function definite in ImageDao.java
	@Override
	public byte[] getPhotoById(int id) {
		String query = "SELECT image FROM image WHERE idIm='"+ id + "'";
		List<byte[]> list = jdbcTemplate.query(query, new ImageLoadMapper());
		return list.get(0);
	}
	//Implementation of the getPhotoByNameAndProject function definite in ImageDao.java
	public List<byte[]> getPhotoByNameAndProject(String name, int projectId) {
		String query = "SELECT image FROM image WHERE nameIm='"+name+"' AND idP='"+projectId+"'";
		List<byte[]> list = jdbcTemplate.query(query, new ImageLoadMapper());
		return list;
	}

}
//The mapper is to create a new object of the class.

class ImageLoadMapper implements RowMapper <byte[]>{
	
	@Override
	public byte[] mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getBytes("image");
	}

}


class ImageMapper implements RowMapper <Image>{
	
	@Override
	public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
	Image image = new Image();
	image.setIdIm(rs.getInt("idIm"));
	image.setIdP(rs.getInt("idP"));
	image.setNameIm(rs.getString("nameIm"));

	return image;
	}

}




