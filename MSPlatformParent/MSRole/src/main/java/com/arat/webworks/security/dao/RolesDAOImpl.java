package com.arat.webworks.security.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.arat.webworks.security.beans.RolesBean;

@Repository
public class RolesDAOImpl implements RoleDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<RolesBean> getAllRoles() {
		String sql = "SELECT DISTINCT" + " CSM_ROLE.ROLE_ID," + " CSM_ROLE.ROLE_NAME,"
				+ " CSM_ROLE.ENTERPRISE_NAME," + " CSM_ROLE.DESCRIPTION,"
				+ " CSM_ROLE.INHERITABLE" + " FROM" + " CSM_ROLE" ;
		List<RolesBean> rolesList = jdbcTemplate.query(sql, new RolesMapper());
		return rolesList;
	}
	
	@Override
	public RolesBean getRolesById(long roleId) {
		String sql = "SELECT DISTINCT" + " CSM_ROLE.ROLE_ID," + " CSM_ROLE.ROLE_NAME,"
				+ " CSM_ROLE.ENTERPRISE_NAME," + " CSM_ROLE.DESCRIPTION,"
				+ " CSM_ROLE.INHERITABLE" + " FROM" + " CSM_ROLE" + " where CSM_ROLE.ROLE_ID = ?";
		
		RolesBean rolesBean = (RolesBean)jdbcTemplate.queryForObject(
				sql, new Object[] { roleId }, new RolesMapper());
		return rolesBean;
	}

	@Override
	public void deleteRole(long id) {
		// TODO Auto-generated method stub

	}
}
