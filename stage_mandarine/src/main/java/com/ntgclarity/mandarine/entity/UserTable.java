/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.entity;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
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
@Table(name = "USER_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTable.findAll", query = "SELECT u FROM UserTable u")
    , @NamedQuery(name = "UserTable.findById", query = "SELECT u FROM UserTable u WHERE u.id = :id")
    , @NamedQuery(name = "UserTable.findByColumn1", query = "SELECT u FROM UserTable u WHERE u.column1 = :column1")
    , @NamedQuery(name = "UserTable.findByAddress", query = "SELECT u FROM UserTable u WHERE u.address = :address")})
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class UserTable extends BaseEntity {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   
    @Basic(optional = false)
    @Column(name = "COLUMN1")
    private String column1;
    @Column(name = "ADDRESS")
    private String address;

    public UserTable() {
    }

   


    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        if (!(object instanceof UserTable)) {
            return false;
        }
        UserTable other = (UserTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.UserTable[ id=" + id + " ]";
    }

	@Override
	public IdValueDTO returnIDValueDTO() {
		// TODO Auto-generated method stub
		return null;
	}

}
