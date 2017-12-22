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

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
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
@Table(name = "COMPONENT")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Component.findAll", query = "SELECT c FROM Component c"),
		@NamedQuery(name = "Component.findById", query = "SELECT c FROM Component c WHERE c.id = :id"),
		@NamedQuery(name = "Component.findByName", query = "SELECT c FROM Component c WHERE c.name = :name"),
		@NamedQuery(name = "Component.findByDescription", query = "SELECT c FROM Component c WHERE c.description = :description"),
		@NamedQuery(name = "Component.findByNrc", query = "SELECT c FROM Component c WHERE c.nrc = :nrc"),
		@NamedQuery(name = "Component.findByMrc", query = "SELECT c FROM Component c WHERE c.mrc = :mrc") })
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class Component extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "NRC")
	private BigInteger nrc;
	@Column(name = "MRC")
	private BigInteger mrc;
//	@JoinTable(name = "SERVICE_BUNDLE", joinColumns = {
//        @JoinColumn(name = "COMP_ID", referencedColumnName = "ID",nullable = false, updatable = false)}, inverseJoinColumns = {
//        @JoinColumn(name = "SERVICE_ID", referencedColumnName = "ID",nullable = false, updatable = false)} )
    @ManyToMany(mappedBy = "componentCollection",fetch=FetchType.LAZY)
    private Collection<Service> serviceCollection;
	@JoinColumn(name = "CATEGORYID_ID", referencedColumnName = "ID")
	@ManyToOne
	private Category categoryId;

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public Component() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigInteger getNrc() {
		return nrc;
	}

	public void setNrc(BigInteger nrc) {
		this.nrc = nrc;
	}

	public BigInteger getMrc() {
		return mrc;
	}

	public void setMrc(BigInteger mrc) {
		this.mrc = mrc;
	}

	@XmlTransient
	public Collection<Service> getServiceCollection() {
		return serviceCollection;
	}

	public void setServiceCollection(Collection<Service> serviceCollection) {
		this.serviceCollection = serviceCollection;
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
		if (!(object instanceof Component)) {
			return false;
		}
		Component other = (Component) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.mavenproject2.Component[ id=" + id + " ]";
	}

	@Override
	public IdValueDTO returnIDValueDTO() {
		// TODO Auto-generated method stub
		return null;
	}

}
