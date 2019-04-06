package com.arat.security.hystrix.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arat.security.hystrix.beans.EnterpriseBean;
import com.arat.security.hystrix.client.EnterpriseServiceClient;

@RestController
@RequestMapping("/api/enterprise/hystrix/rest/api/security/enterprises")
public class EnterpriseHystrixRestController {
	@Autowired
	private EnterpriseServiceClient client;
	
	@GetMapping("/all")
	public List<EnterpriseBean> getAllEnterPrise() {
		List<EnterpriseBean> beans = new ArrayList<EnterpriseBean>();
		beans = client.getAllEnterprises();
		return beans;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/enterprise/parententerprises")
	public Map<Long,String> getParentEnterprise() {
		return client.getParentEnterprise();
	}
	
	@DeleteMapping(value = "/enterprise/delete/{name}")
	public void deleteEnterprise(@PathVariable("name") String name) {
		client.deleteEnterprise(name);
	}
}
