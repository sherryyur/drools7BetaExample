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
@XmlType(name="PageContext")
public class PageContext implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    @XmlElement
    private String ID;

    public PageContext() {
    }
    
    public PageContext(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return this.ID;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }

}