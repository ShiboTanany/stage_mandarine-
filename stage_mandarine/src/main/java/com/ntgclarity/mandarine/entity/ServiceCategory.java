/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import com.ntgclarity.mandarine.dto.IdValueDTO;
import com.ntgclarity.mandarine.service.base.BaseEntity;

/**
 *
 * @author MustafaM
 */
@Entity
@Table(name = "SERVICE_CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceCategory.findAll", query = "SELECT s FROM ServiceCategory s")
    , @NamedQuery(name = "ServiceCategory.findById", query = "SELECT s FROM ServiceCategory s WHERE s.id = :id")
    , @NamedQuery(name = "ServiceCategory.findByName", query = "SELECT s FROM ServiceCategory s WHERE s.name = :name")
    , @NamedQuery(name = "ServiceCategory.findByBandwidthCoverageApplicable", query = "SELECT s FROM ServiceCategory s WHERE s.bandwidthCoverageApplicable = :bandwidthCoverageApplicable")
    , @NamedQuery(name = "ServiceCategory.findByFupApllicable", query = "SELECT s FROM ServiceCategory s WHERE s.fupApllicable = :fupApllicable")
    , @NamedQuery(name = "ServiceCategory.findByServiceAcivationGlCode", query = "SELECT s FROM ServiceCategory s WHERE s.serviceAcivationGlCode = :serviceAcivationGlCode")})
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
@Where(clause = "deleted <> 1")
public class ServiceCategory extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Column(name = "NAME")
    private String name;
    @Column(name = "BANDWIDTH_COVERAGE_APPLICABLE")
    private BigInteger bandwidthCoverageApplicable;
    @Column(name = "FUP_APLLICABLE")
    private BigInteger fupApllicable;
    @Column(name = "SERVICE_ACIVATION_GL_CODE")
    private String serviceAcivationGlCode;

    public ServiceCategory() {
    }

    public ServiceCategory(Long id) {
        this.id = id;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getBandwidthCoverageApplicable() {
        return bandwidthCoverageApplicable;
    }

    public void setBandwidthCoverageApplicable(BigInteger bandwidthCoverageApplicable) {
        this.bandwidthCoverageApplicable = bandwidthCoverageApplicable;
    }

    public BigInteger getFupApllicable() {
        return fupApllicable;
    }

    public void setFupApllicable(BigInteger fupApllicable) {
        this.fupApllicable = fupApllicable;
    }

    public String getServiceAcivationGlCode() {
        return serviceAcivationGlCode;
    }

    public void setServiceAcivationGlCode(String serviceAcivationGlCode) {
        this.serviceAcivationGlCode = serviceAcivationGlCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceCategory)) {
            return false;
        }
        ServiceCategory other = (ServiceCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.ServiceCategory[ id=" + id + " ]";
    }

	@Override
	public IdValueDTO returnIDValueDTO() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
