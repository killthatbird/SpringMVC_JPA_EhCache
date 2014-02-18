/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Customer;
import java.util.List;


public interface CustomerDao {
    
    List<Customer> getCustomers() throws Exception;
    
    void saveCustomer(Customer customer) throws Exception;
    
    Customer getCustomer(Integer customerId) throws Exception;
}
