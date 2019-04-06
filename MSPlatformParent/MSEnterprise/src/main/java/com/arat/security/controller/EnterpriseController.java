package com.arat.security.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arat.security.beans.EnterpriseBean;
import com.arat.security.beans.EnterpriseDisplayBean;
import com.arat.security.service.EnterpriseService;

@RestController
@RequestMapping(value = "/rest/api/security/enterprises")
public class EnterpriseController {

	@Autowired
	EnterpriseService service;

	@RequestMapping("/all")
	public List<EnterpriseDisplayBean> getAll() {
		return service.getAllEnterprises();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/enterprise/{name}")
	public EnterpriseBean getByName(@PathVariable("name") String name) {
		return service.getEnterPriseByName(name);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/enterprise/parententerprises")
	public Map<Long,String> getParentEnterprise() {
		return service.getParentEnterprise();
	}

	@DeleteMapping(value = "/enterprise/delete/{name}")
	public void deleteEnterprise(@PathVariable("name") String name) {
		service.deleteEnterprise(name);

	}

	@RequestMapping(value = "/enterprise/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveEnterprise(@RequestBody EnterpriseBean enterpriseBean) {
		long enterprise_id = service.getNextSequnence();
		EnterpriseBean parentBean = service.getEnterPriseByName(enterpriseBean.getParentEnterpriseName());
		String heritage = parentBean.getHeritage() + enterprise_id + '.';
		long enterprise_level = parentBean.getEnterpriseLevel() + 1;
		long parentId = parentBean.getParentId();
		enterpriseBean.setEnterpriseId(enterprise_id);
		enterpriseBean.setHeritage(heritage);
		enterpriseBean.setEnterpriseLevel(enterprise_level);
		enterpriseBean.setParentId(parentId);
		service.SaveEnterprise(enterpriseBean);
		System.out.println(" Added Enterprise = " + enterpriseBean.getEnterpriseName());

	}

	@RequestMapping(value = "/enterprise/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateEnterprise(@RequestBody EnterpriseBean enterpriseBean) {
		service.updateEnterprise(enterpriseBean);
		System.out.println(" updated Enterprise = " + enterpriseBean.getEnterpriseName());
	}

}
