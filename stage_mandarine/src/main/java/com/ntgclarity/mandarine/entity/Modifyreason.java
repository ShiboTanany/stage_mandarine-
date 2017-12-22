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
 * @author shibo
 */
@Entity
@Table(name = "MODIFYREASON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modifyreason.findAll", query = "SELECT m FROM Modifyreason m")
      , @NamedQuery(name = "Modifyreason.findByModifyreason", query = "SELECT m FROM Modifyreason m WHERE m.modifyreason = :modifyreason")})
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class Modifyreason extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Basic(optional = false)
    @Column(name = "RECID")
    private BigDecimal recid;
    @Basic(optional = false)
    @Column(name = "MODIFYREASON")
    private String modifyreason;

    public Modifyreason() {
    }

    

    public Modifyreason(Long recid, String modifyreason) {
        this.setId(recid);
        this.modifyreason = modifyreason;
    }

    
    public String getModifyreason() {
        return modifyreason;
    }

    public void setModifyreason(String modifyreason) {
        this.modifyreason = modifyreason;
    }

    

   
	public BigDecimal getRecid() {
		return recid;
	}



	public void setRecid(BigDecimal recid) {
		this.recid = recid;
	}



	@Override
	public IdValueDTO returnIDValueDTO() {
		// TODO Auto-generated method stub
		return null;
	}
    
}