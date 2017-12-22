/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ntgclarity.mandarine.dto.IdValueDTO;
import com.ntgclarity.mandarine.service.base.BaseEntity;
import java.util.Collection;
import javax.persistence.OneToMany;

/**
 *
 * @author Sheko
 */
@Entity
@Table(name = "CATEGORY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
		@NamedQuery(name = "Category.findById", query = "SELECT c FROM Category c WHERE c.id = :id"),
		@NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name = :name"),
		@NamedQuery(name = "Category.findByType", query = "SELECT c FROM Category c WHERE c.type = :type") })
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class Category extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation

	@Column(name = "NAME")
	private String name;
	@Column(name = "TYPE")
	private String type;
	@JoinColumn(name = "SERVICE_ID", referencedColumnName = "ID")
	@ManyToOne
	@JsonIgnore
	private Service serviceId;

	@OneToMany(mappedBy = "categoryId")
	private Collection<Component> componentCollection;

	public Service getServiceId() {
		return serviceId;
	}

	public void setServiceId(Service serviceId) {
		this.serviceId = serviceId;
	}

	public Collection<Component> getComponentCollection() {
		return componentCollection;
	}

	public void setComponentCollection(Collection<Component> componentCollection) {
		this.componentCollection = componentCollection;
	}

	public Category() {
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

	// public Service getServiceId() {
	// return serviceId;
	// }
	//
	// public void setServiceId(Service serviceId) {
	// this.serviceId = serviceId;
	// }

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
		if (!(object instanceof Category)) {
			return false;
		}
		Category other = (Category) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.mavenproject2.Category[ id=" + id + " ]";
	}

	@Override
	public IdValueDTO returnIDValueDTO() {
		return null;
	}

}