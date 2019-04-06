package com.arat.ms.circuitbreaker.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arat.ms.circuitbreaker.hystrix.model.RolesBean;

@RestController
@RequestMapping("/api/roles/hystrix")
public class RoleServiceHystrixController {

	@Autowired
	RoleServiceRequest roleServiceRequest;

	@GetMapping("/rest/api/roles/all")
	public List<RolesBean> getAllRoles() {
		List<RolesBean> rolesBean = new ArrayList<RolesBean>();

		rolesBean = roleServiceRequest.getAllRoles();
		return rolesBean;
	}

}
