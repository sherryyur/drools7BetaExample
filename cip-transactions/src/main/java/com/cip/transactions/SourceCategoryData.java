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
@XmlType(name="SourceCategoryData")
public class SourceCategoryData implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    @XmlElement
    private String Name;
    @XmlElement
    private Integer SourceCategoryID;
    @XmlElement
    private Integer Status;

    public SourceCategoryData() {
    }
    
    public SourceCategoryData(Integer Status, Integer SourceCategoryID, String Name) {
        this.Status = Status;
        this.SourceCategoryID = SourceCategoryID;
        this.Name = Name;
    }
    
    public SourceCategoryData(String Name, Integer Status, Integer SourceCategoryID) {
        this.Name = Name;
        this.Status = Status;
        this.SourceCategoryID = SourceCategoryID;
    }

    public String getName() {
        return this.Name;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getSourceCategoryID() {
        return this.SourceCategoryID;
    }
    
    public void setSourceCategoryID(Integer SourceCategoryID) {
        this.SourceCategoryID = SourceCategoryID;
    }

    public Integer getStatus() {
        return this.Status;
    }
    
    public void setStatus(Integer Status) {
        this.Status = Status;
    }

}