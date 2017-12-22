/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.entity;

import com.ntgclarity.mandarine.dto.IdValueDTO;
import com.ntgclarity.mandarine.service.base.BaseEntity;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

/**
 *
 * @author yasmeen
 */
@Entity
@Table(name = "SELLING_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SellingType.findAll", query = "SELECT s FROM SellingType s")
    , @NamedQuery(name = "SellingType.findByType", query = "SELECT s FROM SellingType s WHERE s.type = :type")
    , @NamedQuery(name = "SellingType.findByHideInDropDown", query = "SELECT s FROM SellingType s WHERE s.hideInDropDown = :hideInDropDown")
    , @NamedQuery(name = "SellingType.findById", query = "SELECT s FROM SellingType s WHERE s.id = :id")
    , @NamedQuery(name = "SellingType.findByCreatedAt", query = "SELECT s FROM SellingType s WHERE s.createdAt = :createdAt")
    , @NamedQuery(name = "SellingType.findByCreatedBy", query = "SELECT s FROM SellingType s WHERE s.createdBy = :createdBy")
    , @NamedQuery(name = "SellingType.findByDeleted", query = "SELECT s FROM SellingType s WHERE s.deleted = :deleted")
    , @NamedQuery(name = "SellingType.findByUpdatedAt", query = "SELECT s FROM SellingType s WHERE s.updatedAt = :updatedAt")
    , @NamedQuery(name = "SellingType.findByUpdatedBy", query = "SELECT s FROM SellingType s WHERE s.updatedBy = :updatedBy")})
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class SellingType extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @Column(name = "HIDE_IN_DROP_DOWN")
    private BigInteger hideInDropDown;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   
    public SellingType() {
    }

   
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigInteger getHideInDropDown() {
        return hideInDropDown;
    }

    public void setHideInDropDown(BigInteger hideInDropDown) {
        this.hideInDropDown = hideInDropDown;
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
        if (!(object instanceof SellingType)) {
            return false;
        }
        SellingType other = (SellingType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SellingType[ id=" + id + " ]";
    }

    @Override
    public IdValueDTO returnIDValueDTO() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return null;
    }
    
}
