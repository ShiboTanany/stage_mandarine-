/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ntgclarity.mandarine.dto.IdValueDTO;
import com.ntgclarity.mandarine.service.base.BaseEntity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

/**
 *
 * @author Sheko
 */
@Entity
@Table(name = "ATTRIBUTE_VALUE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "AttributeValue.findAll", query = "SELECT a FROM AttributeValue a"),
		@NamedQuery(name = "AttributeValue.findByCreatedAt", query = "SELECT a FROM AttributeValue a WHERE a.createdAt = :createdAt"),
		@NamedQuery(name = "AttributeValue.findByCreatedBy", query = "SELECT a FROM AttributeValue a WHERE a.createdBy = :createdBy"),
		@NamedQuery(name = "AttributeValue.findByDeleted", query = "SELECT a FROM AttributeValue a WHERE a.deleted = :deleted"),
		@NamedQuery(name = "AttributeValue.findByUpdatedAt", query = "SELECT a FROM AttributeValue a WHERE a.updatedAt = :updatedAt"),
		@NamedQuery(name = "AttributeValue.findByUpdatedBy", query = "SELECT a FROM AttributeValue a WHERE a.updatedBy = :updatedBy"),
		@NamedQuery(name = "AttributeValue.findByValue", query = "SELECT a FROM AttributeValue a WHERE a.value = :value"),
		@NamedQuery(name = "AttributeValue.findById", query = "SELECT a FROM AttributeValue a WHERE a.id = :id") })
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class AttributeValue extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "VALUE")
	private String value;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@JsonIgnore
	@JoinColumn(name = "ATTRIBUTE_ID", referencedColumnName = "ID")
	@ManyToOne(optional = false)
	private Attribute attributeId;
	@JsonIgnore
	@JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
	@ManyToOne(optional = false)
	private Orders orderId;
	@JsonIgnore
	@JoinColumn(name = "SERVICE_ID", referencedColumnName = "ID")
	@ManyToOne(optional = false)
	private Service serviceId;

	public AttributeValue() {
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Attribute getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Attribute attributeId) {
		this.attributeId = attributeId;
	}

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public Service getServiceId() {
		return serviceId;
	}

	public void setServiceId(Service serviceId) {
		this.serviceId = serviceId;
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
		if (!(object instanceof AttributeValue)) {
			return false;
		}
		AttributeValue other = (AttributeValue) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.mavenproject3.AttributeValue[ id=" + id + " ]";
	}

	@Override
	public IdValueDTO returnIDValueDTO() {
		return null;
	}

}
