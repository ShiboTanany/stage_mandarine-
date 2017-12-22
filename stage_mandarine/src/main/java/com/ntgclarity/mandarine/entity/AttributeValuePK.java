/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Sheko
 */
@Embeddable
public class AttributeValuePK  implements Serializable {

    @Basic(optional = false)
    @Column(name = "SERVICE_ID")
    private BigInteger serviceId;
    @Basic(optional = false)
    @Column(name = "ATTRIBUTE_ID")
    private BigInteger attributeId;
    @Basic(optional = false)
    @Column(name = "ORDER_ID")
    private BigInteger orderId;


    public AttributeValuePK() {
    }

    public AttributeValuePK(BigInteger serviceId, BigInteger attributeId, BigInteger orderId) {
        this.serviceId = serviceId;
        this.attributeId = attributeId;
        this.orderId = orderId;
    }

    public BigInteger getServiceId() {
        return serviceId;
    }

    public void setServiceId(BigInteger serviceId) {
        this.serviceId = serviceId;
    }

    public BigInteger getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(BigInteger attributeId) {
        this.attributeId = attributeId;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        hash += (attributeId != null ? attributeId.hashCode() : 0);
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttributeValuePK)) {
            return false;
        }
        AttributeValuePK other = (AttributeValuePK) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        if ((this.attributeId == null && other.attributeId != null) || (this.attributeId != null && !this.attributeId.equals(other.attributeId))) {
            return false;
        }
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.AttributeValuePK[ serviceId=" + serviceId + ", attributeId=" + attributeId + ", orderId=" + orderId + " ]";
    }


    
    
}
