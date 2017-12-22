package com.ntgclarity.mandarine.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author shibo
 */
@Entity
@Table(name = "SERVICEMIGRATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicemigration.findAll", query = "SELECT s FROM Servicemigration s")
    , @NamedQuery(name = "Servicemigration.findByRecid", query = "SELECT s FROM Servicemigration s WHERE s.recid = :recid")
    , @NamedQuery(name = "Servicemigration.findByServiceid", query = "SELECT s FROM Servicemigration s WHERE s.serviceid = :serviceid")
    , @NamedQuery(name = "Servicemigration.findByRequestid", query = "SELECT s FROM Servicemigration s WHERE s.requestid = :requestid")
    , @NamedQuery(name = "Servicemigration.findByFromserviceid", query = "SELECT s FROM Servicemigration s WHERE s.fromserviceid = :fromserviceid")
    , @NamedQuery(name = "Servicemigration.findByToserviceid", query = "SELECT s FROM Servicemigration s WHERE s.toserviceid = :toserviceid")})
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class Servicemigration extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
//    @Id
    @Basic(optional = false)
    @Column(name = "RECID")
    private BigDecimal recid;
    @Basic(optional = false)
    @Column(name = "SERVICEID")
    private BigInteger serviceid;
    @Basic(optional = false)
    @Column(name = "REQUESTID")
    private BigInteger requestid;
    @Basic(optional = false)
    @Column(name = "FROMSERVICEID")
    private BigInteger fromserviceid;
    @Basic(optional = false)
    @Column(name = "TOSERVICEID")
    private BigInteger toserviceid;

    public Servicemigration() {
    }

    public Servicemigration(BigDecimal recid) {
        this.recid = recid;
    }

    public Servicemigration(BigDecimal recid, BigInteger serviceid, BigInteger requestid, BigInteger fromserviceid, BigInteger toserviceid) {
        this.recid = recid;
        this.serviceid = serviceid;
        this.requestid = requestid;
        this.fromserviceid = fromserviceid;
        this.toserviceid = toserviceid;
    }

    public BigDecimal getRecid() {
        return recid;
    }

    public void setRecid(BigDecimal recid) {
        this.recid = recid;
    }

    public BigInteger getServiceid() {
        return serviceid;
    }

    public void setServiceid(BigInteger serviceid) {
        this.serviceid = serviceid;
    }

    public BigInteger getRequestid() {
        return requestid;
    }

    public void setRequestid(BigInteger requestid) {
        this.requestid = requestid;
    }

    public BigInteger getFromserviceid() {
        return fromserviceid;
    }

    public void setFromserviceid(BigInteger fromserviceid) {
        this.fromserviceid = fromserviceid;
    }

    public BigInteger getToserviceid() {
        return toserviceid;
    }

    public void setToserviceid(BigInteger toserviceid) {
        this.toserviceid = toserviceid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recid != null ? recid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicemigration)) {
            return false;
        }
        Servicemigration other = (Servicemigration) object;
        if ((this.recid == null && other.recid != null) || (this.recid != null && !this.recid.equals(other.recid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "a1.Servicemigration[ recid=" + recid + " ]";
    }

	@Override
	public IdValueDTO returnIDValueDTO() {
		// TODO Auto-generated method stub
		return null;
	}
    
}