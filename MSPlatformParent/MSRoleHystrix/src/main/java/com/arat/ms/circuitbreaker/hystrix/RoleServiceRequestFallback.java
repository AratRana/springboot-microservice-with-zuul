package com.arat.ms.circuitbreaker.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.arat.ms.circuitbreaker.hystrix.model.RolesBean;

@Component
public class RoleServiceRequestFallback implements RoleServiceRequest {

	@Override
	public List<RolesBean> getAllRoles() {
		List<RolesBean> beans = new ArrayList<RolesBean>();
		return beans;
	}

}
