/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.entity;

import com.ntgclarity.mandarine.dto.IdValueDTO;
import com.ntgclarity.mandarine.service.base.BaseEntity;
import java.io.Serializable;
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
@Table(name = "DOWNLOAD_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DownloadType.findAll", query = "SELECT d FROM DownloadType d")
    , @NamedQuery(name = "DownloadType.findByName", query = "SELECT d FROM DownloadType d WHERE d.name = :name")
    , @NamedQuery(name = "DownloadType.findById", query = "SELECT d FROM DownloadType d WHERE d.id = :id")})
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class DownloadType extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  

    public DownloadType() {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DownloadType)) {
            return false;
        }
        DownloadType other = (DownloadType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DownloadType[ id=" + id + " ]";
    }

    @Override
    public IdValueDTO returnIDValueDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
