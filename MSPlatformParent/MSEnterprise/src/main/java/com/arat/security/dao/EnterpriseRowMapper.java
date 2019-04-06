package com.arat.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arat.security.beans.EnterpriseBean;

public class EnterpriseRowMapper implements RowMapper<EnterpriseBean> {

	@Override
	public EnterpriseBean mapRow(ResultSet rs, int rowNum) throws SQLException {
        EnterpriseBean enterprise = new EnterpriseBean();			
		
		enterprise.setEnterpriseName(rs.getString("ENTERPRISE_NAME"));
		enterprise.setContactName(rs.getString("CONTACT_NAME"));
		enterprise.setContactEmail(rs.getString("CONTACT_EMAIL"));
		enterprise.setTelephone(rs.getString("TELEPHONE"));
		enterprise.setFax(rs.getString("FAX"));
		enterprise.setAddress(rs.getString("ADDRESS"));
		enterprise.setCity(rs.getString("CITY"));
		enterprise.setLocality(rs.getString("LOCALITY"));
		enterprise.setZipCode(rs.getString("ZIP_CODE"));
		enterprise.setCountry(rs.getString("COUNTRY"));
		enterprise.setDescription(rs.getString("DESCRIPTION"));	    	
		enterprise.setEnterpriseId(rs.getLong("ENTERPRISE_ID"));
		enterprise.setParentId(rs.getLong("PARENT_ID"));
		 
		enterprise.setHeritage(rs.getString("HERITAGE"));
		enterprise.setEnterpriseLevel(rs.getLong("ENTERPRISE_LEVEL"));
		return enterprise;
	}
	
}
