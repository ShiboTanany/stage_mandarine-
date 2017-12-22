package com.ntgclarity.mandarine.entity;

import com.ntgclarity.mandarine.dto.IdValueDTO;
import com.ntgclarity.mandarine.service.base.BaseEntity;
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

/**
 *
 * @author Sheko
 */
@Entity
@Table(name = "PRICE_BASIS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "PriceBasis.findAll", query = "SELECT p FROM PriceBasis p"),
		@NamedQuery(name = "PriceBasis.findById", query = "SELECT p FROM PriceBasis p WHERE p.id = :id"),
		@NamedQuery(name = "PriceBasis.findByDescribtion", query = "SELECT p FROM PriceBasis p WHERE p.describtion = :describtion"),
		@NamedQuery(name = "PriceBasis.findByNumberofmonths", query = "SELECT p FROM PriceBasis p WHERE p.numberofmonths = :numberofmonths"),
		@NamedQuery(name = "PriceBasis.findByFreedaysonce", query = "SELECT p FROM PriceBasis p WHERE p.freedaysonce = :freedaysonce"),
		@NamedQuery(name = "PriceBasis.findByFreedaysservicebill", query = "SELECT p FROM PriceBasis p WHERE p.freedaysservicebill = :freedaysservicebill") })
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class PriceBasis extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation

	@Size(max = 50)
	@Column(name = "DESCRIBTION")
	private String describtion;
	@Column(name = "NUMBEROFMONTHS")
	private Short numberofmonths;
	@Column(name = "FREEDAYSONCE")
	private Short freedaysonce;
	@Size(max = 20)
	@Column(name = "FREEDAYSSERVICEBILL")
	private String freedaysservicebill;
	@Column(name = "NAME")
	@Size(max = 50)
	private String name;

	public PriceBasis() {
	}

	public PriceBasis(Long id) {
		this.id = id;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public Short getNumberofmonths() {
		return numberofmonths;
	}

	public void setNumberofmonths(Short numberofmonths) {
		this.numberofmonths = numberofmonths;
	}

	public Short getFreedaysonce() {
		return freedaysonce;
	}

	public void setFreedaysonce(Short freedaysonce) {
		this.freedaysonce = freedaysonce;
	}

	public String getFreedaysservicebill() {
		return freedaysservicebill;
	}

	public void setFreedaysservicebill(String freedaysservicebill) {
		this.freedaysservicebill = freedaysservicebill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		if (!(object instanceof PriceBasis)) {
			return false;
		}
		PriceBasis other = (PriceBasis) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.mavenproject3.PriceBasis[ id=" + id + " ]";
	}

	@Override
	public IdValueDTO returnIDValueDTO() {
		return null;
	}

}