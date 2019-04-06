package com.arat.webworks.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arat.webworks.security.RolesUIProxy;
import com.arat.webworks.security.beans.RolesBean;

@RestController
@RequestMapping("/api/rolehystrix")
public class RolesUIRestController {
	
	@Autowired
	RolesUIProxy proxy;
	
	@RequestMapping("/allRoles/json")
	@ResponseBody
	public List<RolesBean> getAllRolesJson(){
		List<RolesBean> beans = proxy.getAllRolesJson();
		return beans;
	}

}
