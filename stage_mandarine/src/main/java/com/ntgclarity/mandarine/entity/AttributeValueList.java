/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "ATTRIBUTE_VALUE_LIST")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "AttributeValueList.findAll", query = "SELECT a FROM AttributeValueList a"),
		@NamedQuery(name = "AttributeValueList.findByCreatedAt", query = "SELECT a FROM AttributeValueList a WHERE a.createdAt = :createdAt"),
		@NamedQuery(name = "AttributeValueList.findByCreatedBy", query = "SELECT a FROM AttributeValueList a WHERE a.createdBy = :createdBy"),
		@NamedQuery(name = "AttributeValueList.findByDeleted", query = "SELECT a FROM AttributeValueList a WHERE a.deleted = :deleted"),
		@NamedQuery(name = "AttributeValueList.findByUpdatedAt", query = "SELECT a FROM AttributeValueList a WHERE a.updatedAt = :updatedAt"),
		@NamedQuery(name = "AttributeValueList.findByUpdatedBy", query = "SELECT a FROM AttributeValueList a WHERE a.updatedBy = :updatedBy"),
		@NamedQuery(name = "AttributeValueList.findByValue", query = "SELECT a FROM AttributeValueList a WHERE a.value = :value"),
		@NamedQuery(name = "AttributeValueList.findById", query = "SELECT a FROM AttributeValueList a WHERE a.id = :id") })
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class AttributeValueList extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "VALUE")
	private String value;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation

	@JoinColumn(name = "ATTRIBUTE_ID", referencedColumnName = "ID")
	@ManyToOne
	private Attribute attributeId;
	@JoinColumn(name = "SERVICEID", referencedColumnName = "ID", nullable = false, updatable = false)
	@ManyToOne
	private Service serviceid;

	public AttributeValueList() {
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

	public Service getServiceid() {
		return serviceid;
	}

	public void setServiceid(Service serviceid) {
		this.serviceid = serviceid;
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
		if (!(object instanceof AttributeValueList)) {
			return false;
		}
		AttributeValueList other = (AttributeValueList) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entities.AttributeValueList[ id=" + id + " ]";
	}

	@Override
	public IdValueDTO returnIDValueDTO() {
		// TODO Auto-generated method stub
		return null;
	}

}
