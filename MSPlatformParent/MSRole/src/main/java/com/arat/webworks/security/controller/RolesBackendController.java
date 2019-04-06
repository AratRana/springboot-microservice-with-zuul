package com.arat.webworks.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arat.webworks.security.beans.RolesBean;
import com.arat.webworks.security.dao.RoleDao;

@RestController
@RequestMapping(value = "/rest/api/roles")
public class RolesBackendController {

	@Autowired
	RoleDao roleDao;
	
	@RequestMapping("/all")
	public List<RolesBean> getAllRolesJson() {
		List<RolesBean> rolesList = roleDao.getAllRoles();
		return rolesList;
	}
}
