/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vic
 */
@Entity
@Table(name = "coop_finance_time_deposit_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopFinanceTimeDepositType.findAll", query = "SELECT c FROM CoopFinanceTimeDepositType c"),
    @NamedQuery(name = "CoopFinanceTimeDepositType.findByTdTypeId", query = "SELECT c FROM CoopFinanceTimeDepositType c WHERE c.tdTypeId = :tdTypeId"),
    @NamedQuery(name = "CoopFinanceTimeDepositType.findByName", query = "SELECT c FROM CoopFinanceTimeDepositType c WHERE c.name = :name"),
    @NamedQuery(name = "CoopFinanceTimeDepositType.findByEffectivityDate", query = "SELECT c FROM CoopFinanceTimeDepositType c WHERE c.effectivityDate = :effectivityDate")})
public class CoopFinanceTimeDepositType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "td_type_id")
    private Integer tdTypeId;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Column(name = "effectivity_date")
    @Temporal(TemporalType.DATE)
    private Date effectivityDate;
    @OneToMany(mappedBy = "tdTypeId")
    private Collection<CoopFinanceTimeDepositRate> coopFinanceTimeDepositRateCollection;

    public CoopFinanceTimeDepositType() {
    }

    public CoopFinanceTimeDepositType(Integer tdTypeId) {
        this.tdTypeId = tdTypeId;
    }

    public Integer getTdTypeId() {
        return tdTypeId;
    }

    public void setTdTypeId(Integer tdTypeId) {
        this.tdTypeId = tdTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEffectivityDate() {
        return effectivityDate;
    }

    public void setEffectivityDate(Date effectivityDate) {
        this.effectivityDate = effectivityDate;
    }

    @XmlTransient
    public Collection<CoopFinanceTimeDepositRate> getCoopFinanceTimeDepositRateCollection() {
        return coopFinanceTimeDepositRateCollection;
    }

    public void setCoopFinanceTimeDepositRateCollection(Collection<CoopFinanceTimeDepositRate> coopFinanceTimeDepositRateCollection) {
        this.coopFinanceTimeDepositRateCollection = coopFinanceTimeDepositRateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdTypeId != null ? tdTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopFinanceTimeDepositType)) {
            return false;
        }
        CoopFinanceTimeDepositType other = (CoopFinanceTimeDepositType) object;
        if ((this.tdTypeId == null && other.tdTypeId != null) || (this.tdTypeId != null && !this.tdTypeId.equals(other.tdTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopFinanceTimeDepositType[ tdTypeId=" + tdTypeId + " ]";
    }
    
}
