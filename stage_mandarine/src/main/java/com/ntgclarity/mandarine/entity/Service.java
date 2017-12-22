/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import com.ntgclarity.mandarine.dto.IdValueDTO;
import com.ntgclarity.mandarine.service.base.BaseEntity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sheko
 */
@Entity
@Table(name = "SERVICE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
		@NamedQuery(name = "Service.findById", query = "SELECT s FROM Service s WHERE s.id = :id"),
		@NamedQuery(name = "Service.findByName", query = "SELECT s FROM Service s WHERE s.name = :name"),
		@NamedQuery(name = "Service.findByType", query = "SELECT s FROM Service s WHERE s.type = :type"),
		@NamedQuery(name = "Service.findByDateCreated", query = "SELECT s FROM Service s WHERE s.dateCreated = :dateCreated"),
		@NamedQuery(name = "Service.findByCreatedBy", query = "SELECT s FROM Service s WHERE s.createdBy = :createdBy"),
		@NamedQuery(name = "Service.findByIsactive", query = "SELECT s FROM Service s WHERE s.isactive = :isactive"),
		@NamedQuery(name = "Service.findByTerminationFees", query = "SELECT s FROM Service s WHERE s.terminationFees = :terminationFees"),
		@NamedQuery(name = "Service.findBySuspensionFees", query = "SELECT s FROM Service s WHERE s.suspensionFees = :suspensionFees"),
		@NamedQuery(name = "Service.findByDeliveryFees", query = "SELECT s FROM Service s WHERE s.deliveryFees = :deliveryFees"),
		@NamedQuery(name = "Service.findByDeliveryDays", query = "SELECT s FROM Service s WHERE s.deliveryDays = :deliveryDays") })
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class Service extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation

	@Column(name = "NAME")
	private String name;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "DATE_CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	@Column(name = "ISACTIVE")
	private BigInteger isactive;
	@Column(name = "TERMINATION_FEES")
	private BigInteger terminationFees;
	@Column(name = "SUSPENSION_FEES")
	private BigInteger suspensionFees;
	@Column(name = "DELIVERY_FEES")
	private BigInteger deliveryFees;
	@Column(name = "DELIVERY_DAYS")
	private BigInteger deliveryDays;
	@JoinTable(name = "SERVICE_BUNDLE", joinColumns = {
			@JoinColumn(name = "SERVICE_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "COMP_ID", referencedColumnName = "ID", nullable = false, updatable = false) })
	@ManyToMany(fetch = FetchType.LAZY)
	private Collection<Component> componentCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceId")
	private Collection<Attribute> attributeCollection;
	// @OneToMany(mappedBy = "serviceId")
	// private Collection<Category> categoryCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceId")
	private Collection<AttributeValue> attributeValueCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceid")
	private Collection<Orders> ordersCollection;
	@OneToMany(mappedBy = "serviceid")
	private Collection<AttributeValueList> attributeValueListCollection;

	public Service() {
	}

	public Collection<Component> getComponentCollection() {
		return componentCollection;
	}

	public void setComponentCollection(Collection<Component> componentCollection) {
		this.componentCollection = componentCollection;
	}

	public Collection<Orders> getOrdersCollection() {
		return ordersCollection;
	}

	public void setOrdersCollection(Collection<Orders> ordersCollection) {
		this.ordersCollection = ordersCollection;
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public BigInteger getIsactive() {
		return isactive;
	}

	public void setIsactive(BigInteger isactive) {
		this.isactive = isactive;
	}

	public BigInteger getTerminationFees() {
		return terminationFees;
	}

	public void setTerminationFees(BigInteger terminationFees) {
		this.terminationFees = terminationFees;
	}

	public BigInteger getSuspensionFees() {
		return suspensionFees;
	}

	public void setSuspensionFees(BigInteger suspensionFees) {
		this.suspensionFees = suspensionFees;
	}

	public BigInteger getDeliveryFees() {
		return deliveryFees;
	}

	public void setDeliveryFees(BigInteger deliveryFees) {
		this.deliveryFees = deliveryFees;
	}

	public BigInteger getDeliveryDays() {
		return deliveryDays;
	}

	public void setDeliveryDays(BigInteger deliveryDays) {
		this.deliveryDays = deliveryDays;
	}

	// @XmlTransient
	// public Collection<Component> getComponentCollection() {
	// return componentCollection;
	// }
	//
	// public void setComponentCollection(Collection<Component>
	// componentCollection) {
	// this.componentCollection = componentCollection;
	// }

	@XmlTransient
	public Collection<Attribute> getAttributeCollection() {
		return attributeCollection;
	}

	public void setAttributeCollection(Collection<Attribute> attributeCollection) {
		this.attributeCollection = attributeCollection;
	}

	// @XmlTransient
	// public Collection<Category> getCategoryCollection() {
	// return categoryCollection;
	// }
	//
	// public void setCategoryCollection(Collection<Category>
	// categoryCollection) {
	// this.categoryCollection = categoryCollection;
	// }

	@XmlTransient
	public Collection<AttributeValue> getAttributeValueCollection() {
		return attributeValueCollection;
	}

	public void setAttributeValueCollection(Collection<AttributeValue> attributeValueCollection) {
		this.attributeValueCollection = attributeValueCollection;
	}

	public Collection<AttributeValueList> getAttributeValueListCollection() {
		return attributeValueListCollection;
	}

	public void setAttributeValueListCollection(Collection<AttributeValueList> attributeValueListCollection) {
		this.attributeValueListCollection = attributeValueListCollection;
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
		if (!(object instanceof Service)) {
			return false;
		}
		Service other = (Service) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.mavenproject2.Service[ id=" + id + " ]";
	}

	@Override
	public IdValueDTO returnIDValueDTO() {
		// TODO Auto-generated method stub
		return null;
	}

}
