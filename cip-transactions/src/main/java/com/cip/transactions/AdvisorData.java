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
@XmlType(name="AdvisorData")
public class AdvisorData implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    @XmlElement
    private Integer AdvisorID;
    @XmlElement
    private PersonData Person;

    public AdvisorData() {
    }
    
    public AdvisorData(Integer AdvisorID, PersonData Person) {
        this.AdvisorID = AdvisorID;
        this.Person = Person;
    }

    public Integer getAdvisorID() {
        return this.AdvisorID;
    }
    
    public void setAdvisorID(Integer AdvisorID) {
        this.AdvisorID = AdvisorID;
    }

    public PersonData getPerson() {
        return this.Person;
    }
    
    public void setPerson(PersonData Person) {
        this.Person = Person;
    }

}