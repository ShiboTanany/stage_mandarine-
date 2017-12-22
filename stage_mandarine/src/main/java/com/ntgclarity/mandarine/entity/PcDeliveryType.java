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
@Table(name = "PC_DELIVERY_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcDeliveryType.findAll", query = "SELECT p FROM PcDeliveryType p")
    , @NamedQuery(name = "PcDeliveryType.findById", query = "SELECT p FROM PcDeliveryType p WHERE p.id = :id")
    , @NamedQuery(name = "PcDeliveryType.findByName", query = "SELECT p FROM PcDeliveryType p WHERE p.name = :name")
    , @NamedQuery(name = "PcDeliveryType.findByDescription", query = "SELECT p FROM PcDeliveryType p WHERE p.description = :description")})

@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
@Where(clause = "deleted <> 1")

public class PcDeliveryType extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;

    public PcDeliveryType() {
    }

    public PcDeliveryType(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PcDeliveryType)) {
            return false;
        }
        PcDeliveryType other = (PcDeliveryType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.PcDeliveryType[ id=" + id + " ]";
    }

	@Override
	public IdValueDTO returnIDValueDTO() {
		// TODO Auto-generated method stub
		return null;
	}


    
}
