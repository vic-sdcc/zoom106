/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.CoopFinanceTimeDepositType;
import service.CoopFinanceTimeDepositTypeFacadeREST;

/**
 *
 * @author vic
 */
@ManagedBean
@RequestScoped
public class timeDepositList{

    @EJB
    private CoopFinanceTimeDepositTypeFacadeREST coopFinanceTimeDepositTypeFacadeREST;
    
    public timeDepositList() {

    }

    public List<CoopFinanceTimeDepositType> getTimeDeposit() {
        return coopFinanceTimeDepositTypeFacadeREST.findAll();
    }

}
