/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.entity;

import com.ntgclarity.mandarine.dto.IdValueDTO;
import com.ntgclarity.mandarine.service.base.BaseEntity;
import java.io.Serializable;
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

/**
 *
 * @author yasmeen
 */
@Entity
@Table(name = "CANCELATION_REASON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CancelationReason.findAll", query = "SELECT c FROM CancelationReason c")
    , @NamedQuery(name = "CancelationReason.findById", query = "SELECT c FROM CancelationReason c WHERE c.id = :id")
    , @NamedQuery(name = "CancelationReason.findByCancelreason", query = "SELECT c FROM CancelationReason c WHERE c.cancelreason = :cancelreason")
    , @NamedQuery(name = "CancelationReason.findByIscustomerrequest", query = "SELECT c FROM CancelationReason c WHERE c.iscustomerrequest = :iscustomerrequest")})
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class CancelationReason extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CANCELREASON")
    private String cancelreason;
    @Column(name = "ISCUSTOMERREQUEST")
    private Short iscustomerrequest;

    public CancelationReason() {
    }

    public String getCancelreason() {
        return cancelreason;
    }

    public void setCancelreason(String cancelreason) {
        this.cancelreason = cancelreason;
    }

    public Short getIscustomerrequest() {
        return iscustomerrequest;
    }

    public void setIscustomerrequest(Short iscustomerrequest) {
        this.iscustomerrequest = iscustomerrequest;
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
        if (!(object instanceof CancelationReason)) {
            return false;
        }
        CancelationReason other = (CancelationReason) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CancelationReason[ id=" + id + " ]";
    }

    @Override
    public IdValueDTO returnIDValueDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
