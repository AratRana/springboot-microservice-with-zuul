package com.arat.webworks.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.arat.webworks.security.beans.RolesBean;

public class RolesMapper implements RowMapper<RolesBean>{

	@Override
	public RolesBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		RolesBean role = new RolesBean();
		role.setRoleId(rs.getLong("ROLE_ID"));
		role.setRoleName(rs.getString("ROLE_NAME"));
		role.setDescription(rs.getString("DESCRIPTION"));
		role.setEnterpriseName(rs.getString("ENTERPRISE_NAME"));
		role.setInheritable(rs.getInt("INHERITABLE"));
		
		return role;
	}

}
