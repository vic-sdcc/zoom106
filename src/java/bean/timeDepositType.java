/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import model.CoopFinanceTimeDepositType;

/**
 *
 * @author vic
 */
@ManagedBean
@SessionScoped
public class timeDepositType extends CoopFinanceTimeDepositType implements Serializable {

    @PersistenceUnit
    EntityManagerFactory emf;

    public timeDepositType() {

    }

    public void depositType(Integer id) {
        try {
            CoopFinanceTimeDepositType q = (CoopFinanceTimeDepositType) emf.createEntityManager().createQuery("SELECT c FROM CoopFinanceTimeDepositType c WHERE c.tdTypeId =" + id + "").getResultList().get(0);
            super.setName(q.getName());
            super.setTdTypeId(q.getTdTypeId());
            super.setEffectivityDate(q.getEffectivityDate());
        } catch (Exception e) {
            super.setName(null);
            super.setTdTypeId(null);
            super.setEffectivityDate(null);
        }

    }

}
