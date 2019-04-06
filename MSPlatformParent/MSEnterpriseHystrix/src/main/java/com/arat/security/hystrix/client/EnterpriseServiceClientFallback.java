package com.arat.security.hystrix.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.arat.security.hystrix.beans.EnterpriseBean;

@Component
public class EnterpriseServiceClientFallback implements EnterpriseServiceClient {

	@Override
	public List<EnterpriseBean> getAllEnterprises() {
		List<EnterpriseBean> enterpriseBeanList = new ArrayList<>();
		return enterpriseBeanList;
	}

	@Override
	public void deleteEnterprise(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<Long, String> getParentEnterprise() {
		return new HashMap<Long,String>();
	}

}
