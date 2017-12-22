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
@Table(name = "CONTRACTTERMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contractterms.findAll", query = "SELECT c FROM Contractterms c")
    , @NamedQuery(name = "Contractterms.findByContractterm", query = "SELECT c FROM Contractterms c WHERE c.contractterm = :contractterm")
    , @NamedQuery(name = "Contractterms.findByNumberofmonths", query = "SELECT c FROM Contractterms c WHERE c.numberofmonths = :numberofmonths")
    , @NamedQuery(name = "Contractterms.findByDescription", query = "SELECT c FROM Contractterms c WHERE c.description = :description")
    , @NamedQuery(name = "Contractterms.findByIswebcontent", query = "SELECT c FROM Contractterms c WHERE c.iswebcontent = :iswebcontent")
    , @NamedQuery(name = "Contractterms.findByDefaultcontract", query = "SELECT c FROM Contractterms c WHERE c.defaultcontract = :defaultcontract")})
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited

public class Contractterms extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  
    @Basic(optional = false)
    @Column(name = "RECID")
    private BigDecimal recid;
    @Basic(optional = false)
    @Column(name = "CONTRACTTERM")
    private String contractterm;
    @Basic(optional = false)
    @Column(name = "NUMBEROFMONTHS")
    private BigInteger numberofmonths;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ISWEBCONTENT")
    private BigInteger iswebcontent;
    @Column(name = "DEFAULTCONTRACT")
    private BigInteger defaultcontract;

    public Contractterms() {
    }

   
    public Contractterms(Long recid, String contractterm, BigInteger numberofmonths) {
        this.setId(recid);
        this.contractterm = contractterm;
        this.numberofmonths = numberofmonths;
    }

    
    public BigDecimal getRecid() {
		return recid;
	}


	public void setRecid(BigDecimal recid) {
		this.recid = recid;
	}


	public String getContractterm() {
        return contractterm;
    }

    public void setContractterm(String contractterm) {
        this.contractterm = contractterm;
    }

    public BigInteger getNumberofmonths() {
        return numberofmonths;
    }

    public void setNumberofmonths(BigInteger numberofmonths) {
        this.numberofmonths = numberofmonths;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getIswebcontent() {
        return iswebcontent;
    }

    public void setIswebcontent(BigInteger iswebcontent) {
        this.iswebcontent = iswebcontent;
    }

    public BigInteger getDefaultcontract() {
        return defaultcontract;
    }

    public void setDefaultcontract(BigInteger defaultcontract) {
        this.defaultcontract = defaultcontract;
    }

    
	@Override
	public IdValueDTO returnIDValueDTO() {
		// TODO Auto-generated method stub
		return null;
	}
    
}