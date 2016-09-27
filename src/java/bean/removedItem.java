/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author vic
 */
@ManagedBean
@SessionScoped
public class removedItem {
    
    private List<Integer> itemValue;
    
    public removedItem() {
        
    }
    
    public void removedItemList(Integer id) {
        if (id > 0) {
            getItemValue().add(id);
        }
    }
    
    public List<Integer> getItemValue() {
        if (itemValue == null) {
            itemValue = new ArrayList<>();
        }
        return itemValue;
    }
    
    public void setItemValue(List<Integer> itemValue) {
        this.itemValue = itemValue;
    }
    
}
