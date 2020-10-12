package com.proyectofinal.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.proyectofinal.web.model.ReqCreate;
import com.proyectofinal.web.model.Requirement;
import com.proyectofinal.web.model.VersionRequirement;

/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email: lauarangom@gmail.com
 * Creation date: 30/04/2019
 * Last modification: 15/05/2019
 */
public class RequirementDaoImpl implements RequirementDao {
	/**
	 * DataSource an JbdcTemplate are classes and interfaces from sql to generate querys.
	 */
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	//Implementation of the getRequirementByProjectId function definite in RequirementDao.java  
	@Override
	public List<Requirement> getRequirementByProjectId(int id) {
		String sql = "SELECT * FROM requirements WHERE projectid = '" + id + "'";
		return jdbcTemplate.query(sql, new RequirementMapper());
	}
	//Implementation of the getRequirementById function definite in RequirementDao.java
	@Override
	public Requirement getRequirementById(int id) {
		String sql = "SELECT * FROM requirements WHERE id = '" + id + "'";
		return jdbcTemplate.query(sql, new RequirementMapper()).get(0);
	}
	//Implementation of the createRequirement function definite in RequirementDao.java
	@Override
	public void createRequirement(ReqCreate requirement) {
		String sql = "INSERT INTO requirements(reqId,type, name, description, status,version,projectId) values(?,?,?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { requirement.getReqId(),requirement.getType(), requirement.getName(), requirement.getDescription(),requirement.getStatus(), requirement.getVersion(), requirement.getProjectId()});
		
	}
	//Implementation of the deleteVersionRequirement function definite in RequirementDao.java  
	@Override
	public void deleteVersionRequirement(int rId) {
		String sql = "DELETE FROM requirementsxversion WHERE rId = '" + rId + "'";
	    jdbcTemplate.update(sql);
	}
	//Implementation of the deleteRequirement function definite in RequirementDao.java  
	@Override
	public void deleteRequirement(int id) {
		String sql = "DELETE FROM requirements WHERE id = '" + id + "'";
	    jdbcTemplate.update(sql);
	}
	//Implementation of the createRequirementVersion function definite in RequirementDao.java
	@Override
	public void createRequirementVersion(Requirement requirement) {
		String sql = "INSERT INTO requirementsxversion(id,reqId,type, name, description, status,version,projectId) values(?,?,?,?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { requirement.getId(),requirement.getReqId(),requirement.getType(), requirement.getName(), requirement.getDescription(),requirement.getStatus(), requirement.getVersion(), requirement.getProjectId()});		
	}
	//Implementation of the checkReqId function definite in RequirementDao.java
	@Override
	public int checkReqId(String reqId, int projectId) {
		 String sql = "SELECT * FROM requirements WHERE reqId='" + reqId + "' AND projectId='" + projectId + "'";
	
	    List<Requirement> requirements = jdbcTemplate.query(sql, new RequirementMapper());
	    if (requirements.size() > 0) {
	    	return 0;
	    }
	    else {
	    	return 1;
	    }
	}
	//Implementation of the getVersionsByReqId function definite in RequirementDao.java
	@Override
	public List<VersionRequirement> getVersionsByReqId(String reqId, int projectId) {
		String sql = "SELECT * FROM requirementsxversion WHERE reqId ='" + reqId + "' AND projectId ='" + projectId + "'";
		return jdbcTemplate.query(sql, new RequirementVersionMapper());
	}
	//Implementation of the updateRequirementFromReq function definite in RequirementDao.java
	@Override
	public void updateRequirementFromReq(int id, ReqCreate requirement) {
		String sql = "UPDATE requirements SET reqId = '" + requirement.getReqId() + "', type = '" + 
		requirement.getType() + "', name ='" + requirement.getName() + "', description ='" + 
		requirement.getDescription() + "', status = '" + requirement.getStatus() + "', version ='" + 
		requirement.getVersion() + "', projectId ='"+requirement.getProjectId()+"' WHERE id ='" + id + "'";
		jdbcTemplate.update(sql);
	}
	//Implementation of the updateRequirementFromSpec function definite in RequirementDao.java
	@Override
	public void updateRequirementFromSpec(int id, String version) {
		String sql = "UPDATE requirements SET version = '" + version + "' WHERE id ='" + id + "'";
				jdbcTemplate.update(sql);
	}
	//Implementation of the getLastVersionReq function definite in RequirementDao.java
	@Override
	public VersionRequirement getLastVersionReq(String reqId, int projectId) {
		String sql = "SELECT * FROM requirementsxversion WHERE reqId ='" + reqId + "' AND projectId ='" + projectId + "' ORDER BY rId DESC";
		List<VersionRequirement> versionReqs = jdbcTemplate.query(sql, new RequirementVersionMapper());
		if (versionReqs.isEmpty()) {
			return null;
		}
		return versionReqs.get(0);
	}
	//Implementation of the enableVersionReq function definite in RequirementDao.java
	@Override
	public void enableVersionReq(VersionRequirement versionRequirement) {
		String sql = "UPDATE requirements SET reqId = '" + versionRequirement.getReqId() + "', type = '" + 
				versionRequirement.getType() + "', name ='" + versionRequirement.getName() + "', description ='" + 
				versionRequirement.getDescription() + "', status = '" + versionRequirement.getStatus() + "', version ='" + 
				versionRequirement.getVersion() + "', projectId ='"+versionRequirement.getProjectId()+ "' WHERE id ='" + 
				versionRequirement.getId() + "'";
		jdbcTemplate.update(sql);

	}

}
//The mapper is to create a new object of the class.
class RequirementMapper implements RowMapper<Requirement> {

	@Override
	public Requirement mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Requirement(rs.getInt("id"), rs.getString("reqId"),rs.getString("type"), rs.getString("name"), rs.getString("version"),rs.getString("description"),rs.getString("status"),rs.getInt("projectId"));
	}
	
}

class RequirementVersionMapper implements RowMapper<VersionRequirement> {

	@Override
	public VersionRequirement mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new VersionRequirement(rs.getInt("rId"), rs.getInt("id"), rs.getString("reqId"),rs.getString("type"), rs.getString("name"), rs.getString("version"),rs.getString("description"),rs.getString("status"),rs.getInt("projectId"));
	}
	
}
