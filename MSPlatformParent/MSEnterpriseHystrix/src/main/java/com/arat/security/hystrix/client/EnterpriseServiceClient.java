package com.arat.security.hystrix.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.arat.security.hystrix.beans.EnterpriseBean;

@FeignClient(name="enterpriseservice", fallback=EnterpriseServiceClientFallback.class)
public interface EnterpriseServiceClient {

	@GetMapping("/rest/api/security/enterprises/all")
	List<EnterpriseBean> getAllEnterprises();
	
	@GetMapping("/rest/api/security/enterprises/enterprise/parententerprises")
	public Map<Long,String> getParentEnterprise();
	

	@DeleteMapping("/rest/api/security/enterprises/enterprise/delete/{name}")
	void deleteEnterprise(String name);

}
