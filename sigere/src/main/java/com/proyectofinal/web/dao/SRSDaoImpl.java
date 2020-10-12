package com.proyectofinal.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.proyectofinal.web.model.Project;
import com.proyectofinal.web.model.ProjectCreate;
import com.proyectofinal.web.model.SRS;
import com.proyectofinal.web.model.SRSEditDescrGlobal;
import com.proyectofinal.web.model.SRSEditIntro;
import com.proyectofinal.web.model.SRSEditReqs;
import com.proyectofinal.web.model.VersionSRS;

public class SRSDaoImpl implements SRSDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource datasource;
	//Implementation of the createSRS function definite in ProjectDao.java
	@Override
	public void createSRS(ProjectCreate project) {
		String sql = "SELECT * FROM projects WHERE name = '" + project.getName() + "'";
		final Project pro = jdbcTemplate.query(sql, new ProjectSRSMapper()).get(0);
		sql = "INSERT INTO srs(systemProspect,scope,objectives,definitions,referencs,globalAppraisal,"
				+ "productPerspective,interfaces,userCharacteristics,productFunctions,domainModel,"
				+ "restrictions,suppositions,dbRequirements,designRestrictions,ruleAcceptance,projectId,version) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,pro.getId(),"0.0"});
	}
	
	//Implementation of the editSRSIntro function definite in ProjectDao.java
	@Override
	public void editSRSIntro(SRSEditIntro srs, String version) {
		String sql = "update srs SET systemprospect='"+srs.getSystemProspect()+"', scope='"+srs.getScope()+"', objectives='"+srs.getObjectives()+"', definitions='"+srs.getDefinitions()+"',referencs='"+srs.getReferencs()+"',"
				+ "globalAppraisal='"+srs.getGlobalAppraisal()+"',version='"+version +"' WHERE projectId='"+srs.getProjectId()+"'";
	    jdbcTemplate.update(sql);
	}
	
	//Implementation of the editSRSDescrGlobal function definite in ProjectDao.java
	@Override
	public void editSRSDescrGlobal(SRSEditDescrGlobal srs, String version) {
		String sql = "update srs SET productPerspective='"+srs.getProductPerspective()+"', interfaces='"+srs.getInterfaces()+"', userCharacteristics='"+srs.getUserCharacteristics()+"',"
				+ "productFunctions='"+srs.getProductFunctions()+"', domainModel='"+srs.getDomainModel()+"', restrictions='"+srs.getRestrictions()+"', suppositions='"+srs.getSuppositions()+"',version='"+version +"' WHERE projectId='"+srs.getProjectId()+"'";
	    jdbcTemplate.update(sql);
	}
	//Implementation of the editSRSReqs function definite in ProjectDao.java
	@Override
	public void editSRSReqs(SRSEditReqs srs, String version) {
		String sql = "update srs SET dbRequirements='"+srs.getDbRequirements()+"', designRestrictions='"+srs.getDesignRestrictions()+"', ruleAcceptance='"+srs.getRuleAcceptance()+"',version='"+version +"' WHERE projectId='"+srs.getProjectId()+"'";
	    jdbcTemplate.update(sql);
		
	}
		
	//Implementation of the getSRSByProjectId function definite in ProjectDao.java
	@Override
	public SRS getSRSByProjectId(int id) {
		String sql = "SELECT * FROM srs WHERE projectId='"+ id +"'";
		return jdbcTemplate.query(sql, new SRSMapper()).get(0);
		
	}

	@Override
	public void saveVersionSRS(SRS srs) {
		String sql = "INSERT INTO srsxversion(systemProspect,scope,objectives,definitions,referencs,globalAppraisal,"
				+ "productPerspective,interfaces,userCharacteristics,productFunctions,domainModel,"
				+ "restrictions,suppositions,dbRequirements,designRestrictions,ruleAcceptance,projectId,version) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { srs.getSystemProspect(),srs.getScope(),srs.getObjectives(),srs.getDefinitions(),
	    		srs.getReferencs(),srs.getGlobalAppraisal(),srs.getProductPerspective(),srs.getInterfaces(),
	    		srs.getUserCharacteristics(),srs.getProductFunctions(),srs.getDomainModel(),srs.getRestrictions(),
	    		srs.getSuppositions(),srs.getDBRequirements(),srs.getDesignRestrictions(),srs.getRuleAcceptance(),
	    		srs.getProjectId(),srs.getVersion()});
	}

}

//The mapper is to create a new object of the class.
class ProjectSRSMapper implements RowMapper<Project> {
	@Override
	public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Project(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getBlob("contextDiagram"));
	}	
}


class SRSMapper implements RowMapper<SRS>{
	
	@Override
	public SRS mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new SRS(rs.getInt("id"), rs.getString("systemProspect"), rs.getString("scope"), rs.getString("objectives"), rs.getString("definitions"),rs.getString("referencs"), rs.getString("globalAppraisal"), rs.getString("productPerspective"), rs.getString("interfaces"), rs.getString("userCharacteristics"),rs.getString("productFunctions"), rs.getString("domainModel"), rs.getString("restrictions"), rs.getString("suppositions"),rs.getString("dbRequirements"),rs.getString("designRestrictions"), rs.getString("ruleAcceptance"),rs.getInt("projectId"), rs.getString("version"));
	}
}


class VersionSRSMapper implements RowMapper<VersionSRS>{
	
	@Override
	public VersionSRS mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new VersionSRS(rs.getInt("SRSId"),rs.getInt("id"), rs.getString("systemProspect"), rs.getString("scope"), rs.getString("objectives"), rs.getString("definitions"),rs.getString("referencs"), rs.getString("globalAppraisal"), rs.getString("productPerspective"), rs.getString("interfaces"), rs.getString("userCharacteristics"),rs.getString("productFunctions"), rs.getString("domainModel"), rs.getString("restrictions"), rs.getString("suppositions"),rs.getString("dbRequirements"),rs.getString("designRestrictions"), rs.getString("ruleAcceptance"),rs.getInt("projectId"), rs.getString("version"));
	}
}
