package com.arat.security.hystrix.beans;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arat.security.hystrix.utils.CompareObjects;

public class EnterpriseBean implements Serializable {
	private static final long serialVersionUID = -7188982251043240059L;
    private static final Logger logger = LoggerFactory.getLogger(EnterpriseBean.class);

    // **************************************************************************
    // *************************** Data Members *********************************
    // **************************************************************************

    // Bean database attributes (loaded from CSM database)
    private String enterpriseName;         // ENTERPRISE_NAME
    private String contactName;            // CONTACT_NAME
    private String contactEmail;           // CONTACT_EMAIL
    private String telephone;              // TELEPHONE
    private String fax;                    // FAX
    private String address;                // ADDRESS
    private String city;                   // CITY
    private String locality;               // LOCALITY
    private String zipCode;                // ZIP_CODE
    private String country;                // COUNTRY
    private String description;            // DESCRIPTION
    private long enterpriseId;            // ENTERPRISE_ID
    private long parentId;                // PARENT_ID
    private long enterpriseLevel;         // ENTERPRISE_LEVEL
    private String heritage;               // HERITAGE

    // Derived attributes
    private String parentEnterpriseName;   //

    // **************************************************************************
    // **************************** Creators ************************************
    // **************************************************************************

    /**
     * Default constructor - sets new flag = true
     */
    public EnterpriseBean() {
        super();
    }

    /**
     * Constructor with required attributes.
     *
     * @param iEnterpriseName Enterprise Name for this Enterprise bean.
     * @throws IllegalArgumentException <code>iEnterpriseName</code> cannot be null or empty
     */
    public EnterpriseBean(String iEnterpriseName)
            throws IllegalArgumentException {
        notNullOrEmpty(iEnterpriseName, "iEnterpriseName");
        this.enterpriseName = iEnterpriseName;
    }

    /**
     * Constructor with ResultSet - set all attributes from associated
     * database row. Identifies an existing object.
     *
     * @param rs Database result set containing attributes for this bean.
     * @throws SQLException 
     * @throws IllegalArgumentException <code>rs</code> cannot be null
     * @throws DBException              mismatch between attributes in ResultSet and bean attributes or a
     *                                  mismatch in data types.
     */
    public EnterpriseBean(ResultSet rs) throws SQLException
    {
    	// Set attributes on EnterpriseBean

    	this.enterpriseName = rs.getString("ENTERPRISE_NAME");
    	this.contactName = rs.getString("CONTACT_NAME");
    	this.contactEmail = rs.getString("CONTACT_EMAIL");
    	this.telephone = rs.getString("TELEPHONE");
    	this.fax = rs.getString("FAX");
    	this.address = rs.getString("ADDRESS");
    	this.city = rs.getString("CITY");
    	this.locality = rs.getString("LOCALITY");
    	this.zipCode = rs.getString("ZIP_CODE");
    	this.country = rs.getString("COUNTRY");
    	this.description = rs.getString("DESCRIPTION");
    	this.enterpriseId = rs.getLong("ENTERPRISE_ID");
    	this.parentId = rs.getLong("PARENT_ID");
    	this.heritage = rs.getString("HERITAGE");
    	this.enterpriseLevel = rs.getLong("ENTERPRISE_LEVEL");       
    }

    // *************************************************************************
    // **************************** Manipulators *******************************
    // *************************************************************************

    /**
     * Set csm attribute - CONTACT_NAME. Sets appropriate Modifiable state.
     *
     * @param iContactName Contact name for this enterprise (optional)
     */
    public void setContactName(String iContactName) {     
      this.contactName = iContactName;
    }

    /**
     * Set csm attribute - CONTACT_EMAIL. Sets appropriate Modifiable state.
     *
     * @param iContactEmail Contact email for this enterprise (optional)
     */
    public void setContactEmail(String iContactEmail) {
        this.contactEmail = iContactEmail;
    }

    /**
     * Set csm attribute - TELEPHONE. Sets appropriate Modifiable state.
     *
     * @param iTelephone Primary telephone for this enterprise (optional)
     */
    public void setTelephone(String iTelephone) {
        this.telephone = iTelephone;
    }

    /**
     * Set csm attribute - FAX. Sets appropriate Modifiable state.
     *
     * @param iFax Fax number for this enterprise (optional)
     */
    public void setFax(String iFax) {     
        this.fax = iFax;
    }

    /**
     * Set csm attribute - ADDRESS. Sets appropriate Modifiable state.
     *
     * @param iAddress Street address for this enterprise (optional)
     */
    public void setAddress(String iAddress) {       
        this.address = iAddress;
    }

    /**
     * Set csm attribute - CITY. Sets appropriate Modifiable state.
     *
     * @param iCity City for this enterprise (optional)
     */
    public void setCity(String iCity) {      
        this.city = iCity;
    }

    /**
     * Set csm attribute - LOCALITY. Sets appropriate Modifiable state.
     *
     * @param iLocality Locality for this enterprise (optional)
     */
    public void setLocality(String iLocality) {       
        this.locality = iLocality;
    }

    /**
     * Set csm attribute - ZIP_CODE. Sets appropriate Modifiable state.
     *
     * @param iZipCode Zip Code of this enterprise (optional)
     */
    public void setZipCode(String iZipCode) {       
        this.zipCode = iZipCode;
    }

    /**
     * Set csm attribute - COUNTRY. Sets appropriate Modifiable state.
     *
     * @param iCountry Country for this enterprise (optional)
     */
    public void setCountry(String iCountry) {      
        this.country = iCountry;
    }

    /**
     * Set csm attribute - DESCRIPTION. Sets appropriate Modifiable state.
     *
     * @param iDescription Description of this enterprise (optional)
     */
    public void setDescription(String iDescription) {     
        this.description = iDescription;
    }

    /**
     * Set derived attribute - ParentEnterpriseName. Used internally and by Java/Xml binding layer.
     * <b>Should not be called by application teams.</b>
     *
     * @param iParentEnterpriseName Parent enterprise for this enterprise.
     */
    public void setParentEnterpriseName(String iParentEnterpiseName) {
        this.parentEnterpriseName = iParentEnterpiseName;
    }

    /**
     * Set derived attribute - enterpriseId. Used internally and by Java/Xml binding layer.
     * <b>Should not be called by application teams.</b>
     *
     * @param iEnterpriseId The enterpriseId for this enterprise
     */
    public void setEnterpriseId(long iEnterpriseId) {
        this.enterpriseId = iEnterpriseId;
    }

    /**
     * Set derived attribute - parentId. Used internally and by Java/Xml binding layer.
     * <b>Should not be called by application teams.</b>
     *
     * @param iParentId The enterpriseId of the parent enterprise.
     */
    public void setParentId(long iParentId) {
        this.parentId = iParentId;
    }

    /**
     * Set derived attribute - enterpriseLevel. Used internally and by Java/Xml binding layer.
     * <b>Should not be called by application teams.</b>
     *
     * @param iEnterpriseLevel The enterprise level of the enterprise.
     */
    public void setEnterpriseLevel(long iEnterpriseLevel) {
        this.enterpriseLevel = iEnterpriseLevel;
    }

    /**
     * Set derived attribute - parentId. Used internally and by Java/Xml binding layer.
     * <b>Should not be called by application teams.</b>
     *
     * @param iHeritage The heritage of the enterprise.
     */
    public void setHeritage(String iHeritage) {
        this.heritage = iHeritage;
    }

    /**
     * Required by JavaBeans spec.
     * <b>These methods should ONLY be used by Xml/Java Binding Layer.</b>
     */
    public void setEnterpriseName(String iEnterpriseName) {
        this.enterpriseName = iEnterpriseName;
    }

    // *************************************************************************
    // ****************************** Accessors ********************************
    // *************************************************************************

    /**
     * Get CSM attribute - enterprise name.
     *
     * @return enterprise name
     */
    public String getEnterpriseName() {
        return this.enterpriseName;
    }

    /**
     * Get CSM attribute - contact name.
     *
     * @return contact name (optional)
     */
    public String getContactName() {
        return this.contactName;
    }

    /**
     * Get CSM attribute - contact email.
     *
     * @return contact email (optional)
     */
    public String getContactEmail() {
        return this.contactEmail;
    }

    /**
     * Get CSM attribute - telephone.
     *
     * @return telephone (optional)
     */
    public String getTelephone() {
        return this.telephone;
    }

    /**
     * Get csm attribute - FAX.
     *
     * @return Fax number for this enterprise (optional)
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * Get csm attribute - ADDRESS.
     *
     * @return Street address for this enterprise (optional)
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Get csm attribute - CITY.
     *
     * @return City for this enterprise (optional)
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Get csm attribute - LOCALITY.
     *
     * @return Locality for this enterprise (optional)
     */
    public String getLocality() {
        return this.locality;
    }

    /**
     * Get derived attribute - ParentEnterpriseName.
     *
     * @return Parent enterprise for this enterprise.
     */
    public String getParentEnterpriseName() {
        return this.parentEnterpriseName;
    }

    /**
     * Get csm attribute - ZIP_CODE.
     *
     * @return Zip Code of this enterprise (optional)
     */
    public String getZipCode() {
        return this.zipCode;
    }

    /**
     * Get csm attribute - COUNTRY.
     *
     * @return Country for this enterprise (optional)
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Get CSM attribute - enterprise description.
     *
     * @return parent enterprise description (optional)
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get the enterprise_id for this enterprise
     *
     * @return the enterprise_id.
     */
    public long getEnterpriseId() {
        return this.enterpriseId;
    }

    /**
     * Get the parent_id of this enterprise.
     *
     * @return the parent_id
     */
    public long getParentId() {
        return this.parentId;
    }

    /**
     * Get the enterprise_level of this enterprise.
     *
     */
    public long getEnterpriseLevel() {
        return this.enterpriseLevel;
    }

    /**
     * Get the heritage of this enterprise.
     *
     */
    public String getHeritage() {
        if (this.heritage != null)
            return this.heritage.trim();
        else
            return null;
    }

   
    /**
     * Compares this EnterpriseBean to the specified object.
     * The result is <code>true</code> if and only if the argument is not
     * <code>null</code> and is an <code>EnterpriseBean</code> object that
     * represents the attribute values as this object.
     *
     * @param iObject the object to compare this <code>EnterpriseBean</code> against.
     * @return <code>true</code> if the <code>EnterpriseBean </code>are equal;
     *         <code>false</code> otherwise.
     */
    public boolean equals(Object iObject) {
        // Check class typoe
        if ((iObject instanceof EnterpriseBean) == false) return false;

        // Check object attributes
        //!! missing attributes to compare
        EnterpriseBean other = (EnterpriseBean) iObject;
        return this.enterpriseName.equals(other.enterpriseName) &&
                CompareObjects.compare(this.contactName, other.contactName) &&
                CompareObjects.compare(this.contactEmail, other.contactEmail) &&
                CompareObjects.compare(this.telephone, other.telephone) &&
                CompareObjects.compare(this.fax, other.fax) &&
                CompareObjects.compare(this.address, other.address) &&
                CompareObjects.compare(this.city, other.city) &&
                CompareObjects.compare(this.locality, other.locality) &&
                CompareObjects.compare(this.zipCode, other.zipCode) &&
                CompareObjects.compare(this.country, other.country) &&
                CompareObjects.compare(this.description, other.description);
    }

    /**
     * Creates a copy of the object. Resets state of copy to initial state.
     *
     * @return copy of object
     * @see java.lang.Object
     */
    @Override
    public Object clone() {
        EnterpriseBean copy = (EnterpriseBean) clone();       
        return copy;
    }

   
    
    public static void notNullOrEmpty(String iArg, String iArgName)
    {
       if (iArg == null)
       {
          String msg = "The " + iArgName + " argument must not be null";
           logger.error( msg);
          throw new IllegalArgumentException(msg);
       }
       else if (iArg.trim().length() == 0 == true)
       {
          String msg = "The " + iArgName + " argument must not be empty";
           logger.error(msg);
          throw new IllegalArgumentException(msg);
       }
    }
}
