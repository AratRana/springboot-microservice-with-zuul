package com.arat.security.service;

import java.util.List;
import java.util.Map;

import com.arat.security.beans.EnterpriseBean;
import com.arat.security.beans.EnterpriseDisplayBean;

public interface EnterpriseService {
	public List<EnterpriseDisplayBean> getAllEnterprises();

	public EnterpriseBean getEnterPriseByName(String name);

	public EnterpriseBean getEnterPriseByID(long ID);
	
	public void SaveEnterprise( EnterpriseBean bean);
	
	public void updateEnterprise( EnterpriseBean bean);
	
	public void deleteEnterprise(String enterpriseName);
	
	public long getNextSequnence();

	public Map<Long, String> getParentEnterprise();

}