package com.arat.security.dao;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arat.security.beans.EnterpriseBean;
import com.arat.security.beans.EnterpriseDisplayBean;


@Repository
public class EnterpriseDAO {	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  
    
	private static final String SQL_WHERE_PK = " WHERE ENTERPRISE_NAME = ?";
	private static final String SELECT_ENTERPRISE_SQL = "select ENTERPRISE_ID,ENTERPRISE_NAME from csm_enterprise"; 
	
	private static final String SELECT_SQL = "SELECT e.*, p.enterprise_name AS parent_enterprise_name FROM csm_enterprise e " + 
			" LEFT OUTER JOIN csm_enterprise p ON e.parent_id=p.enterprise_id";
	private static final String SELECT_SQL_BY_NAME = "select * from csm_enterprise where enterprise_name = ? "; 
	private static final String SELECT_SQL_BY_ID = "select * from csm_enterprise where enterprise_id = ? "; 
	//Insert String
	private static final String INSERT_SQL =
		      "INSERT INTO CSM_ENTERPRISE" +
		      " (ENTERPRISE_NAME, CONTACT_NAME, CONTACT_EMAIL, TELEPHONE, FAX, ADDRESS," +
		      " CITY, LOCALITY, ZIP_CODE, COUNTRY, DESCRIPTION, ENTERPRISE_ID, PARENT_ID," +
		      " HERITAGE, ENTERPRISE_LEVEL)" +
		      " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	// Update String
	private static final String UPDATE_SQL = 
		      "UPDATE CSM_ENTERPRISE SET" +
		      " CONTACT_NAME = ?, CONTACT_EMAIL = ?," +
		      " TELEPHONE = ?, FAX = ?, ADDRESS = ?, CITY = ?, LOCALITY = ?," +
		      " ZIP_CODE = ?, COUNTRY = ?,  DESCRIPTION = ?" + SQL_WHERE_PK;
	
	private static final String GET_PARENT_ENT_SQL =
			"SELECT PARENT_ID, HERITAGE,ENTERPRISE_LEVEL FROM CSM_ENTERPRISE WHERE ENTERPRISE_NAME= ? ";
		      
	
	// Delete String
	private static final String SQL_DELETE = "DELETE FROM CSM_ENTERPRISE " + SQL_WHERE_PK;
	
	private static final String SQL_NEXT_SEQ = "SELECT CSM_ENTERPRISE_SEQ.nextval FROM dual";
	
	public List<EnterpriseDisplayBean> getAllEnterprises() {

		List<EnterpriseDisplayBean> enterprises = new ArrayList<EnterpriseDisplayBean>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_SQL);

		for (Map<String, Object> row : rows) {
			EnterpriseDisplayBean enterprise = getEnterPrise(row);
	    	enterprises.add(enterprise);			
		}
		return enterprises;
	}
	
	public EnterpriseBean getEnterpriseByID(long id) {
		
		Long[] inputs = new Long[] {id};
		EnterpriseBean bean = (EnterpriseBean) jdbcTemplate.queryForObject(SELECT_SQL_BY_ID, inputs, new EnterpriseRowMapper());		
		return bean;
	}
	
	public EnterpriseBean getEnterpriseByName(String name) {
		Object[] inputs = new Object[] {name};
		EnterpriseBean bean = (EnterpriseBean)jdbcTemplate.queryForObject(SELECT_SQL_BY_NAME, inputs, new EnterpriseRowMapper());	
		return bean;
	}
		

	private EnterpriseDisplayBean getEnterPrise(Map<String, Object> row) {
		EnterpriseDisplayBean enterprise = new EnterpriseDisplayBean();			
		
		enterprise.setEnterpriseName(getValue(String.valueOf(row.get("ENTERPRISE_NAME"))));
		enterprise.setParentEnterpriseName(getValue(String.valueOf(row.get("parent_enterprise_name"))));
		enterprise.setContactName(getValue(String.valueOf(row.get("CONTACT_NAME"))));
		enterprise.setContactEmail(getValue(String.valueOf(row.get("CONTACT_EMAIL"))));
		enterprise.setTelephone(getValue(String.valueOf(row.get("TELEPHONE"))));
		enterprise.setDescription(getValue(String.valueOf(row.get("DESCRIPTION"))));	 
		enterprise.setFax(getValue(String.valueOf(row.get("FAX"))));
		enterprise.setAddress(getValue(String.valueOf(row.get("ADDRESS"))));
		enterprise.setCity(getValue(String.valueOf(row.get("CITY"))));
		enterprise.setLocality(getValue(String.valueOf(row.get("LOCALITY"))));
		enterprise.setZipCode(getValue(String.valueOf(row.get("ZIP_CODE"))));
		enterprise.setCountry(getValue(String.valueOf(row.get("COUNTRY"))));
		//enterprise.setParentId((BigDecimal) row.get("PARENT_ID"));
		//enterprise.setEnterpriseId((BigDecimal) row.get("ENTERPRISE_ID"));
		
		return enterprise;
	}
	
	private String getValue(String value) {
		 if (value == null || value.equals("null")) {
			 return ""; 
		 }
		  return value;
	}
	
	
	
	public void saveEnterprise(EnterpriseBean bean) {
		 		
		Object[] params = new Object[] { bean.getEnterpriseName(), bean.getContactName(),
				bean.getContactEmail(),bean.getTelephone(), bean.getFax(), bean.getAddress(),
				bean.getCity(), bean.getLocality(),
				bean.getZipCode(), bean.getCountry(), bean.getDescription(),bean.getEnterpriseId(),bean.getParentId(),
				bean.getHeritage(), bean.getEnterpriseLevel() };
		
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.LONGNVARCHAR, Types.LONGNVARCHAR, Types.VARCHAR, Types.LONGNVARCHAR};
		
			int row = jdbcTemplate.update(INSERT_SQL, params, types);
			System.out.println(row + " row inserted.");		
	}
	
	public void updateEnterprise(EnterpriseBean bean) {
		 		
		Object[] params = new Object[] { bean.getContactName(),
				bean.getContactEmail(),bean.getTelephone(), bean.getFax(),bean.getAddress(),
				bean.getCity(), bean.getLocality(),
				bean.getZipCode(), bean.getCountry(), bean.getDescription(), bean.getEnterpriseName() };
		
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR,Types.VARCHAR};
		
			int row = jdbcTemplate.update(getUpdateSql(), params, types);
			System.out.println(row + " row updated.");
		
	}
	
	public void deleteEnterprise(String enterpriseName) {
		jdbcTemplate.update(getDeleteSql(), enterpriseName);
		System.out.println("Deleted enterpriseName = " + enterpriseName );		
	}

	private String getUpdateSql() {
		return UPDATE_SQL;
	}
	
	
	private String getDeleteSql() {
		return SQL_DELETE;
	}
	
	
	public long getNextSequence()  {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_NEXT_SEQ);
		BigDecimal value = (BigDecimal) rows.get(0).get("NEXTVAL");
		return value.longValue();
	
	}

	public Map<Long, String> getParentEnterprises() {
		 @SuppressWarnings("unused")
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_ENTERPRISE_SQL);
		 System.out.println(rows.size());
		 Map<Long, String> enterprises = new HashMap<>();
		 for (Map<String, Object> row : rows) {
			 enterprises.put(Long.parseLong(row.get("ENTERPRISE_ID").toString()),row.get("ENTERPRISE_NAME").toString());
		 }
		return enterprises;
	}


}
