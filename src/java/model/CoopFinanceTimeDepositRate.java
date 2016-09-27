/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vic
 */
@Entity
@Table(name = "coop_finance_time_deposit_rate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoopFinanceTimeDepositRate.findAll", query = "SELECT c FROM CoopFinanceTimeDepositRate c"),
    @NamedQuery(name = "CoopFinanceTimeDepositRate.findByTdRateId", query = "SELECT c FROM CoopFinanceTimeDepositRate c WHERE c.tdRateId = :tdRateId"),
    @NamedQuery(name = "CoopFinanceTimeDepositRate.findByAmtFrom", query = "SELECT c FROM CoopFinanceTimeDepositRate c WHERE c.amtFrom = :amtFrom"),
    @NamedQuery(name = "CoopFinanceTimeDepositRate.findByAmtTo", query = "SELECT c FROM CoopFinanceTimeDepositRate c WHERE c.amtTo = :amtTo"),
    @NamedQuery(name = "CoopFinanceTimeDepositRate.findByIntrsRate", query = "SELECT c FROM CoopFinanceTimeDepositRate c WHERE c.intrsRate = :intrsRate")})
public class CoopFinanceTimeDepositRate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "td_rate_id")
    private Integer tdRateId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amt_from")
    private Double amtFrom;
    @Column(name = "amt_to")
    private Double amtTo;
    @Column(name = "intrs_rate")
    private Double intrsRate;
    @JoinColumn(name = "td_type_id", referencedColumnName = "td_type_id")
    @ManyToOne
    private CoopFinanceTimeDepositType tdTypeId;

    public CoopFinanceTimeDepositRate() {
    }

    public CoopFinanceTimeDepositRate(Integer tdRateId) {
        this.tdRateId = tdRateId;
    }

    public Integer getTdRateId() {
        return tdRateId;
    }

    public void setTdRateId(Integer tdRateId) {
        this.tdRateId = tdRateId;
    }

    public Double getAmtFrom() {
        return amtFrom;
    }

    public void setAmtFrom(Double amtFrom) {
        this.amtFrom = amtFrom;
    }

    public Double getAmtTo() {
        return amtTo;
    }

    public void setAmtTo(Double amtTo) {
        this.amtTo = amtTo;
    }

    public Double getIntrsRate() {
        return intrsRate;
    }

    public void setIntrsRate(Double intrsRate) {
        this.intrsRate = intrsRate;
    }

    public CoopFinanceTimeDepositType getTdTypeId() {
        return tdTypeId;
    }

    public void setTdTypeId(CoopFinanceTimeDepositType tdTypeId) {
        this.tdTypeId = tdTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdRateId != null ? tdRateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoopFinanceTimeDepositRate)) {
            return false;
        }
        CoopFinanceTimeDepositRate other = (CoopFinanceTimeDepositRate) object;
        if ((this.tdRateId == null && other.tdRateId != null) || (this.tdRateId != null && !this.tdRateId.equals(other.tdRateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CoopFinanceTimeDepositRate[ tdRateId=" + tdRateId + " ]";
    }
    
}
