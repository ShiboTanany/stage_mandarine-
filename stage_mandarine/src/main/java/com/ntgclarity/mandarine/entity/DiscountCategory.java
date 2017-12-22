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
@Table(name = "DISCOUNT_CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiscountCategory.findAll", query = "SELECT d FROM DiscountCategory d")
    , @NamedQuery(name = "DiscountCategory.findById", query = "SELECT d FROM DiscountCategory d WHERE d.id = :id")
    , @NamedQuery(name = "DiscountCategory.findByName", query = "SELECT d FROM DiscountCategory d WHERE d.name = :name")})
@Where(clause = "deleted <> 1")
@TableGenerator(table = "ID_TABLE", name = "AppGeneratorTable", allocationSize = 1, initialValue = 100, pkColumnName = "pk", valueColumnName = "value", pkColumnValue = "VO_SUBSCRIBER_DETAILS")
@Audited
public class DiscountCategory extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Size(max = 30)
    @Column(name = "NAME")
    private String name;

    public DiscountCategory() {
    }

    public DiscountCategory(Long id) {
        this.id = id;
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
        if (!(object instanceof DiscountCategory)) {
            return false;
        }
        DiscountCategory other = (DiscountCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.DiscountCategory[ id=" + id + " ]";
    }

    @Override
    public IdValueDTO returnIDValueDTO() {
        return null;
    }

}
