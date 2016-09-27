/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.CoopFinanceTimeDepositType;
import service.CoopFinanceTimeDepositRateFacadeREST;
import service.CoopFinanceTimeDepositTypeFacadeREST;

/**
 *
 * @author vic
 */
@ManagedBean
@RequestScoped
public class timeDepositPersist implements Serializable {

    @EJB
    private CoopFinanceTimeDepositTypeFacadeREST coopFinanceTimeDepositTypeFacadeREST;
    @EJB
    private CoopFinanceTimeDepositRateFacadeREST coopFinanceTimeDepositRateFacadeREST;

    private CoopFinanceTimeDepositType typeValue;

    public timeDepositPersist() {

    }

    public void saveTimeDeposit(timeDepositType tdType, timeDepositRate tdRate) {
        getTypeValue().setName(tdType.getName());
        getTypeValue().setEffectivityDate(tdType.getEffectivityDate());
        coopFinanceTimeDepositTypeFacadeREST.create(getTypeValue());

        for (int i = 0; i != tdRate.getDepoRateValue().size(); i++) {
            tdRate.getDepoRateValue().get(i).setTdTypeId(getTypeValue());
            coopFinanceTimeDepositRateFacadeREST.create(tdRate.getDepoRateValue().get(i));
        }

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completed", "New Time Deposit has been created");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void updateTimeDeposit(timeDepositType tdType, timeDepositRate tdRate, removedItem items) {

        getTypeValue().setTdTypeId(tdType.getTdTypeId());
        getTypeValue().setName(tdType.getName());
        getTypeValue().setEffectivityDate(tdType.getEffectivityDate());
        coopFinanceTimeDepositTypeFacadeREST.edit(getTypeValue());

        for (int i = 0; i != items.getItemValue().size(); i++) {
            System.out.println("hey: " + items.getItemValue().get(i));
            try {
                coopFinanceTimeDepositRateFacadeREST.remove(items.getItemValue().get(i));
            } catch (Exception e) {
            }
        }

        for (int i = 0; i != tdRate.getDepoRateValue().size(); i++) {
            tdRate.getDepoRateValue().get(i).setTdTypeId(getTypeValue());
            coopFinanceTimeDepositRateFacadeREST.edit(tdRate.getDepoRateValue().get(i));
        }

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Completed", "Existing Time Deposit has been updated");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public CoopFinanceTimeDepositType getTypeValue() {
        if (typeValue == null) {
            typeValue = new CoopFinanceTimeDepositType();
        }
        return typeValue;
    }

    public void setTypeValue(CoopFinanceTimeDepositType typeValue) {
        this.typeValue = typeValue;
    }

}
