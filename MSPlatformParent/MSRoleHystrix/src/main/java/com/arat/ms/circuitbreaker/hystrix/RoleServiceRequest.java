package com.arat.ms.circuitbreaker.hystrix;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.arat.ms.circuitbreaker.hystrix.model.RolesBean;

@FeignClient(name= "roleservice",fallback = RoleServiceRequestFallback.class)
public interface RoleServiceRequest {
	
	@GetMapping("/rest/api/roles/all")
	List<RolesBean> getAllRoles();
	

}
