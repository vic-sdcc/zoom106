/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import model.CoopFinanceTimeDepositRate;

/**
 *
 * @author vic
 */
@ManagedBean
@SessionScoped
public class timeDepositRate extends CoopFinanceTimeDepositRate implements Serializable {

    @PersistenceUnit
    EntityManagerFactory emf;

    private List<CoopFinanceTimeDepositRate> depoRateValue;

    public timeDepositRate() {

    }

    public void depositRate(Integer id) {
        try {
            setDepoRateValue(emf.createEntityManager().createQuery("SELECT c FROM CoopFinanceTimeDepositRate c WHERE c.tdTypeId.tdTypeId =" + id + " ORDER BY c.amtFrom ASC").getResultList());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String removeRow(CoopFinanceTimeDepositRate value) {
        getDepoRateValue().remove(value);
        return null;
    }

    public void addRow(timeDepositRateValue value) {
        CoopFinanceTimeDepositRate tdrate = null;
        if (tdrate == null) {
            tdrate = new CoopFinanceTimeDepositRate();
        }
        tdrate.setAmtFrom(value.getAmtFrom());
        tdrate.setAmtTo(value.getAmtTo());
        tdrate.setIntrsRate(value.getIntrsRate());
        getDepoRateValue().add(tdrate);
    }

    public List<CoopFinanceTimeDepositRate> getDepoRateValue() {
        if (depoRateValue == null) {
            depoRateValue = new ArrayList<>();
        }
        return depoRateValue;
    }

    public void setDepoRateValue(List<CoopFinanceTimeDepositRate> depoRateValue) {
        this.depoRateValue = depoRateValue;
    }

}
