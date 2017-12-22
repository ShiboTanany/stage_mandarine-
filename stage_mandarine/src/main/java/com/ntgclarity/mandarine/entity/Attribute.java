/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import com.ntgclarity.mandarine.dto.IdValueDTO;
import com.ntgclarity.mandarine.service.base.BaseEntity;

/**
 *
 * @author Sheko
 */
@Entity
@Table(name = "ATTRIBUTE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Attribute.findAll", query = "SELECT a FROM Attribute a"),
		@NamedQuery(name = "Attribute.findById", query = "SELECT a FROM Attribute a WHERE a.id = :id"),
		@NamedQuery(name = "Attribute.findByName", query = "SELECT a FROM Attribute a WHERE a.name = :name"),
		@NamedQuery(name = "Attribute.findByType", query = "SELECT a FROM Attribute a WHERE a.type = :type"),
		@NamedQuery(name = "Attribute.findByMandatory", query = "SELECT a FROM Attribute a WHERE a.mandatory = :mandatory"),
		@NamedQuery(name = "Attribute.findBySort", query = "SELECT a FROM Attribute a WHERE a.sort = :sort") })
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class Attribute extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation

	@Column(name = "NAME")
	private String name;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "MANDATORY")
	private BigInteger mandatory;
	@Column(name = "SORT")
	private BigInteger sort;

	@JoinColumn(name = "SERVICE_ID", referencedColumnName = "ID")
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private Service serviceId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "attributeId",fetch=FetchType.EAGER)
    private Collection<AttributeValue> attributeValueCollection;
    @OneToMany(mappedBy = "attributeId")
    private Collection<AttributeValueList> attributeValueListCollection;
	public Attribute() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigInteger getMandatory() {
		return mandatory;
	}

	public void setMandatory(BigInteger mandatory) {
		this.mandatory = mandatory;
	}

	public BigInteger getSort() {
		return sort;
	}

	public void setSort(BigInteger sort) {
		this.sort = sort;
	}

	public Service getServiceId() {
		return serviceId;
	}

	public void setServiceId(Service serviceId) {
		this.serviceId = serviceId;
	}

	@XmlTransient
	public Collection<AttributeValue> getAttributeValueCollection() {
		return attributeValueCollection;
	}

	public void setAttributeValueCollection(Collection<AttributeValue> attributeValueCollection) {
		this.attributeValueCollection = attributeValueCollection;
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
		if (!(object instanceof Attribute)) {
			return false;
		}
		Attribute other = (Attribute) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	public Collection<AttributeValueList> getAttributeValueListCollection() {
		return attributeValueListCollection;
	}

	public void setAttributeValueListCollection(Collection<AttributeValueList> attributeValueListCollection) {
		this.attributeValueListCollection = attributeValueListCollection;
	}

	@Override
	public String toString() {
		return "com.mycompany.mavenproject2.Attribute[ id=" + id + " ]";
	}

	@Override
	public IdValueDTO returnIDValueDTO() {
		return null;
	}

}
