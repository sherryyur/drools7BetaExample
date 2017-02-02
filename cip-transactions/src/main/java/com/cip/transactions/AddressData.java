package com.cip.transactions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was automatically generated by the data modeler tool.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="AddressData")
public class AddressData implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    @XmlElement
    private Integer AddressID;
    
    @XmlElement
    private GLTData AddressTypeFormat;
    @XmlElement
    private Integer AuditID;
    @XmlElement
    private CountryData Country;
    @XmlElement
    private String CountryName;
    @XmlElement
    private Integer DataProviderID;
    @XmlElement
    private String ExternalID;
    @XmlElement
    private String ForeignKey;
    @XmlElement
    private String FormattedAddress;
    @XmlElement
    private String FormattedAddressWithCR;
    @XmlElement
    private String LineFive;
    @XmlElement
    private String LineFour;
    @XmlElement
    private String LineOne;
    @XmlElement
    private String LineThree;
    @XmlElement
    private String LineTwo;
    @XmlElement
    private String PostCode;
    @XmlElement
    private String ULineOne;

    public AddressData() {
    }
    
    public AddressData(String CountryName, String ExternalID, String FormattedAddress, String LineThree, String LineFive, String FormattedAddressWithCR, String ForeignKey, String LineOne, String LineFour, Integer DataProviderID, Integer AuditID, CountryData Country, GLTData AddressTypeFormat, String ULineOne, String LineTwo, String PostCode, Integer AddressID) {
        this.CountryName = CountryName;
        this.ExternalID = ExternalID;
        this.FormattedAddress = FormattedAddress;
        this.LineThree = LineThree;
        this.LineFive = LineFive;
        this.FormattedAddressWithCR = FormattedAddressWithCR;
        this.ForeignKey = ForeignKey;
        this.LineOne = LineOne;
        this.LineFour = LineFour;
        this.DataProviderID = DataProviderID;
        this.AuditID = AuditID;
        this.Country = Country;
        this.AddressTypeFormat = AddressTypeFormat;
        this.ULineOne = ULineOne;
        this.LineTwo = LineTwo;
        this.PostCode = PostCode;
        this.AddressID = AddressID;
    }
    
    public AddressData(GLTData AddressTypeFormat, String LineFive, String LineTwo, String LineOne, CountryData Country, String FormattedAddress, Integer AddressID, String PostCode, String ULineOne, String LineThree, String LineFour, String ForeignKey, Integer AuditID, String ExternalID, Integer DataProviderID, String FormattedAddressWithCR, String CountryName) {
        this.AddressTypeFormat = AddressTypeFormat;
        this.LineFive = LineFive;
        this.LineTwo = LineTwo;
        this.LineOne = LineOne;
        this.Country = Country;
        this.FormattedAddress = FormattedAddress;
        this.AddressID = AddressID;
        this.PostCode = PostCode;
        this.ULineOne = ULineOne;
        this.LineThree = LineThree;
        this.LineFour = LineFour;
        this.ForeignKey = ForeignKey;
        this.AuditID = AuditID;
        this.ExternalID = ExternalID;
        this.DataProviderID = DataProviderID;
        this.FormattedAddressWithCR = FormattedAddressWithCR;
        this.CountryName = CountryName;
    }

    public Integer getAddressID() {
        return this.AddressID;
    }
    
    public void setAddressID(Integer AddressID) {
        this.AddressID = AddressID;
    }

    public GLTData getAddressTypeFormat() {
        return this.AddressTypeFormat;
    }
    
    public void setAddressTypeFormat(GLTData AddressTypeFormat) {
        this.AddressTypeFormat = AddressTypeFormat;
    }

    public Integer getAuditID() {
        return this.AuditID;
    }
    
    public void setAuditID(Integer AuditID) {
        this.AuditID = AuditID;
    }

    public CountryData getCountry() {
        return this.Country;
    }
    
    public void setCountry(CountryData Country) {
        this.Country = Country;
    }

    public String getCountryName() {
        return this.CountryName;
    }
    
    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    public Integer getDataProviderID() {
        return this.DataProviderID;
    }
    
    public void setDataProviderID(Integer DataProviderID) {
        this.DataProviderID = DataProviderID;
    }

    public String getExternalID() {
        return this.ExternalID;
    }
    
    public void setExternalID(String ExternalID) {
        this.ExternalID = ExternalID;
    }

    public String getForeignKey() {
        return this.ForeignKey;
    }
    
    public void setForeignKey(String ForeignKey) {
        this.ForeignKey = ForeignKey;
    }

    public String getFormattedAddress() {
        return this.FormattedAddress;
    }
    
    public void setFormattedAddress(String FormattedAddress) {
        this.FormattedAddress = FormattedAddress;
    }

    public String getFormattedAddressWithCR() {
        return this.FormattedAddressWithCR;
    }
    
    public void setFormattedAddressWithCR(String FormattedAddressWithCR) {
        this.FormattedAddressWithCR = FormattedAddressWithCR;
    }

    public String getLineFive() {
        return this.LineFive;
    }
    
    public void setLineFive(String LineFive) {
        this.LineFive = LineFive;
    }

    public String getLineFour() {
        return this.LineFour;
    }
    
    public void setLineFour(String LineFour) {
        this.LineFour = LineFour;
    }

    public String getLineOne() {
        return this.LineOne;
    }
    
    public void setLineOne(String LineOne) {
        this.LineOne = LineOne;
    }

    public String getLineThree() {
        return this.LineThree;
    }
    
    public void setLineThree(String LineThree) {
        this.LineThree = LineThree;
    }

    public String getLineTwo() {
        return this.LineTwo;
    }
    
    public void setLineTwo(String LineTwo) {
        this.LineTwo = LineTwo;
    }

    public String getPostCode() {
        return this.PostCode;
    }
    
    public void setPostCode(String PostCode) {
        this.PostCode = PostCode;
    }

    public String getULineOne() {
        return this.ULineOne;
    }
    
    public void setULineOne(String ULineOne) {
        this.ULineOne = ULineOne;
    }

}