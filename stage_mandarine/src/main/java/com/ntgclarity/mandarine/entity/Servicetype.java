/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import com.ntgclarity.mandarine.dto.IdValueDTO;
import com.ntgclarity.mandarine.service.base.BaseEntity;

/**
 *
 * @author Sheko
 */
@Entity
@Table(name = "SERVICETYPE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Servicetype.findAll", query = "SELECT s FROM Servicetype s"),
		@NamedQuery(name = "Servicetype.findById", query = "SELECT s FROM Servicetype s WHERE s.id = :id"),
		@NamedQuery(name = "Servicetype.findByServiceType", query = "SELECT s FROM Servicetype s WHERE s.serviceType = :serviceType"),
		@NamedQuery(name = "Servicetype.findByDescribtion", query = "SELECT s FROM Servicetype s WHERE s.describtion = :describtion") })
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class Servicetype extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation

	@Size(max = 50)
	@Column(name = "SERVICE_TYPE")
	private String serviceType;
	@Size(max = 50)
	@Column(name = "DESCRIBTION")
	private String describtion;

	public Servicetype() {
	}

	public Servicetype(Long id) {
		this.id = id;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Servicetype)) {
			return false;
		}
		Servicetype other = (Servicetype) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entities.Servicetype[ id=" + id + " ]";
	}

	@Override
	public IdValueDTO returnIDValueDTO() {
		// TODO Auto-generated method stub
		return null;
	}

}