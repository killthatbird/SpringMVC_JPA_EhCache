/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "Customer")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "cache_two")
public class Customer implements Serializable{
    
    public Customer(){}
    
    public Customer(Integer customerId,String customerName){
        this.customerId = customerId;
        this.customerName = customerName;
    }
    
    @Id
    @Column(name = "CUSTOMERID")
    private Integer customerId;
    
    @Column(name = "CUSTOMERNAME")
    private String customerName;

    /**
     * @return the customerId
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    @Override
    public int hashCode(){
        return this.customerId * 27;
    }
    
    @Override
    public boolean equals(Object o){
        boolean flag = false;        
        if(o instanceof Customer){
            Customer customer = (Customer) o;
            flag = (this.customerId == customer.customerId) ? true : false;
        }
        return flag;
    }
}
