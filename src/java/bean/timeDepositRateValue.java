/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author vic
 */
@ManagedBean
@SessionScoped
public class timeDepositRateValue {

    private double amtFrom;
    private double amtTo;
    private double intrsRate;
    
    
    public timeDepositRateValue() {
    }

    public double getAmtFrom() {
        return amtFrom;
    }

    public void setAmtFrom(double amtFrom) {
        this.amtFrom = amtFrom;
    }

    public double getAmtTo() {
        return amtTo;
    }

    public void setAmtTo(double amtTo) {
        this.amtTo = amtTo;
    }

    public double getIntrsRate() {
        return intrsRate;
    }

    public void setIntrsRate(double intrsRate) {
        this.intrsRate = intrsRate;
    }
}
