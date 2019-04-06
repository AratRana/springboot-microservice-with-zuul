package com.arat.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arat.security.beans.EnterpriseBean;

public class ParentRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		EnterpriseBean enterprise = new EnterpriseBean();
		//enterprise.setParentId(rs.getLong("PARENT_ID"));
		enterprise.setHeritage(rs.getString("HERITAGE"));
		enterprise.setEnterpriseLevel(rs.getLong("ENTERPRISE_LEVEL"));
		return enterprise;
	}

}
