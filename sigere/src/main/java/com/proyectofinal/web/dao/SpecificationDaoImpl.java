package com.proyectofinal.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Timestamp;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.proyectofinal.web.model.Specification;
import com.proyectofinal.web.model.SpecificationCreate;
import com.proyectofinal.web.model.VersionSpecification;
/**
 * Project:Sigere
 * Developer:Laura Arango
 * Contact email: lauarangom@gmail.com
 * Creation date: 14/05/2019
 * Last modification: 30/05/2019
 */
public class SpecificationDaoImpl implements SpecificationDao {
	/**
	 * DataSource an JbdcTemplate are classes and interfaces from sql to generate querys.
	 */
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	//Implementation of the createSpecification function definite in SpecificationDao.java  
	@Override
	public void createSpecification(SpecificationCreate specification) {
		String sql = "insert into specifications(code, name, gradeofneed, description, entry, font, outt, destiny, restriction, process, colateraleffect,requirementId,version) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { specification.getCode(),specification.getName(), specification.getGradeOfNeed(),specification.getDescription(), specification.getEntry(), specification.getFont(), specification.getOutt(), specification.getDestiny(), specification.getRestriction(), specification.getProcess(), specification.getColateralEffect(), specification.getRequirementId(), specification.getVersion()});
	}
	//Implementation of the getSpecificationByRequirementId function definite in SpecificationDao.java  
	@Override
	public List <Specification> getSpecificationByRequirementId(int id) {
		String sql = "SELECT * FROM specifications WHERE requirementId = '" + id + "'";
		List<Specification> list = jdbcTemplate.query(sql, new SpecificationMapper());
		return list;
	}
	//Implementation of the getSpecificationById function definite in SpecificationDao.java  
	@Override
	public Specification getSpecificationById(int id) {
		String sql = "SELECT * FROM specifications WHERE id = '" + id + "'";
		return jdbcTemplate.query(sql, new SpecificationMapper()).get(0);
	}
	//Implementation of the createSpecificationVersion function definite in SpecificationDao.java  
	@Override 
	public void createSpecificationVersion(Specification specification) {
		String sql = "insert into specificationsxversion(id,code, name, date, gradeofneed, description, entry, font, outt, destiny, restriction, process, colateraleffect,requirementId,version) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { specification.getId(), specification.getCode(),specification.getName(), specification.getDate(), specification.getGradeOfNeed(),specification.getDescription(), specification.getEntry(), specification.getFont(), specification.getOutt(), specification.getDestiny(), specification.getRestriction(), specification.getProcess(), specification.getColateralEffect(), specification.getRequirementId(), specification.getVersion()});
	}
	//Implementation of the updateSpecificationFromReq function definite in SpecificationDao.java  
	@Override
	public void updateSpecificationFromReq(final Specification specification, Timestamp ts, String version) {
		String sql = "UPDATE specifications SET code = '" + specification.getCode() + "', name = '" + 
				specification.getName() + "', date='"+ ts + "',gradeofneed ='" + specification.getGradeOfNeed() + "', description ='" + 
				specification.getDescription() + "', entry = '" + specification.getEntry() + "', font ='" + 
				specification.getFont() + "', outt ='"+specification.getOutt()+"', destiny ='" + specification.getDestiny()
				+ "', restriction='" + specification.getRestriction() + "', process ='" + specification.getProcess() +
				"', colateraleffect='" + specification.getColateralEffect() + "', requirementId='" + specification.getRequirementId()
				+ "', version='" + version + "'WHERE id ='" + specification.getId() + "'";
		jdbcTemplate.update(sql);
				
	}
	//Implementation of the updateSpecificationFromSpec function definite in SpecificationDao.java  
	@Override
	public void updateSpecificationFromSpec(int id, SpecificationCreate specification, Timestamp ts) {
		String sql = "UPDATE specifications SET code = '" + specification.getCode() + "', name = '" + 
				specification.getName() + "', date='"+ ts + "',gradeofneed ='" + specification.getGradeOfNeed() + "', description ='" + 
				specification.getDescription() + "', entry = '" + specification.getEntry() + "', font ='" + 
				specification.getFont() + "', outt ='"+specification.getOutt()+"', destiny ='" + specification.getDestiny()
				+ "', restriction='" + specification.getRestriction() + "', process ='" + specification.getProcess() +
				"', colateraleffect='" + specification.getColateralEffect() + "', requirementId='" + specification.getRequirementId()
				+ "', version='" + specification.getVersion() + "'WHERE id ='" + id + "'";
		jdbcTemplate.update(sql);
	}

	//Implementation of the getLastVersionSpe function definite in SpecificationDao.java
	@Override
	public VersionSpecification getLastVersionSpe(int id) {
		String sql = "SELECT * FROM specificationsxversion WHERE requirementId ='" + id + "' ORDER BY sId DESC";
		List<VersionSpecification> versionSpecs = jdbcTemplate.query(sql, new VersionSpecificationMapper());
		if (versionSpecs.isEmpty()) {
			return null;
		}
		return versionSpecs.get(0);
	}
	//Implementation of the enableVersionSpec function definite in SpecificationDao.java
	@Override
	public void enableVersionSpec(VersionSpecification versionSpecification) {
		String sql = "UPDATE specifications SET code = '" + versionSpecification.getCode() + "', name = '" + 
				versionSpecification.getName() + "', date='"+ versionSpecification.getDate() + "',gradeofneed ='" + 
				versionSpecification.getGradeOfNeed() + "', description ='" + versionSpecification.getDescription() + 
				"', entry = '" + versionSpecification.getEntry() + "', font ='" + versionSpecification.getFont() + "', outt ='" +
				versionSpecification.getOutt()+"', destiny ='" + versionSpecification.getDestiny() + "', restriction='" + 
				versionSpecification.getRestriction() + "', process ='" + versionSpecification.getProcess() + "', colateraleffect='" + 
				versionSpecification.getColateralEffect() + "', requirementId='" + versionSpecification.getRequirementId()
				+ "', version='" + versionSpecification.getVersion() + "'WHERE id ='" + versionSpecification.getId() + "'";
		jdbcTemplate.update(sql);
	}
	//Implementation of the deleteVersionSpecification function definite in SpecificationDao.java  
	@Override
	public void deleteVersionSpecification(int sId) {
		String sql = "DELETE FROM specificationsxversion WHERE sId = '" + sId + "'";
	    jdbcTemplate.update(sql);
	}
	//Implementation of the deleteSpecification function definite in SpecificationDao.java  
	@Override
	public void deleteSpecification(int id) {
		String sql = "DELETE FROM specifications WHERE id = '" + id + "'";
		jdbcTemplate.update(sql);
	}
	//Implementation of the getSpecificationVersions function definite in SpecificationDao.java  
	@Override
	public List<VersionSpecification> getSpecificationVersions(int requirementId) {
		String sql = "SELECT * FROM specificationsxversion WHERE (requirementId ='" + requirementId + "')";
		return jdbcTemplate.query(sql, new VersionSpecificationMapper()) ;

	}
}
//The mapper is to create a new object of the class.
class SpecificationMapper implements RowMapper<Specification> {

	@Override
	public Specification mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Specification(rs.getInt("id"), rs.getString("code"), rs.getString("name"),rs.getDate("date"),rs.getString("gradeOfNeed") ,rs.getString("description"),rs.getString("entry"),rs.getString("font"),rs.getString("outt"),rs.getString("destiny"),rs.getString("restriction"),rs.getString("process"),rs.getString("colateralEffect"),rs.getInt("requirementId"),rs.getString("version"));
	}
	
}

class VersionSpecificationMapper implements RowMapper<VersionSpecification> {
	
	@Override
	public VersionSpecification mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new VersionSpecification(rs.getInt("sId"),rs.getInt("id"), rs.getString("code"), rs.getString("name"),rs.getDate("date"),rs.getString("gradeOfNeed") ,rs.getString("description"),rs.getString("entry"),rs.getString("font"),rs.getString("outt"),rs.getString("destiny"),rs.getString("restriction"),rs.getString("process"),rs.getString("colateralEffect"),rs.getInt("requirementId"),rs.getString("version"));
	}
}