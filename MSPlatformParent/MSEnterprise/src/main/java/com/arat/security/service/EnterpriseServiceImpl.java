package com.arat.security.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arat.security.beans.EnterpriseBean;
import com.arat.security.beans.EnterpriseDisplayBean;
import com.arat.security.dao.EnterpriseDAO;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

	
	@Autowired
	EnterpriseDAO dao;
	
	@Override
	public List<EnterpriseDisplayBean> getAllEnterprises() {
		
		return dao.getAllEnterprises();
	}

	@Override
	public EnterpriseBean getEnterPriseByName(String name) {
		return dao.getEnterpriseByName(name);
	}

	@Override
	public EnterpriseBean getEnterPriseByID(long ID) {
			return dao.getEnterpriseByID(ID);
	}

	@Override
	public void SaveEnterprise(EnterpriseBean bean) {
		dao.saveEnterprise(bean);
		
	}

	@Override
	public void updateEnterprise(EnterpriseBean bean) {
		dao.updateEnterprise(bean);
		
	}

	@Override
	public void deleteEnterprise(String  enterpriseName) {
		dao.deleteEnterprise(enterpriseName);
		
	}

	@Override
	public long getNextSequnence() {
		// TODO Auto-generated method stub
		return dao.getNextSequence();
	}

	@Override
	public Map<Long, String> getParentEnterprise() {
		return dao.getParentEnterprises();
	}	

		
	
}
