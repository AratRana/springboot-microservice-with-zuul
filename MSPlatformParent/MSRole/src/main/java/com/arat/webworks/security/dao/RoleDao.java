package com.arat.webworks.security.dao;

import java.util.List;

import com.arat.webworks.security.beans.RolesBean;

public interface RoleDao {

	public RolesBean getRolesById(long id);
	
	public void deleteRole(long id);
	
	public List<RolesBean> getAllRoles();
}
