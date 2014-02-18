/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.CustomerDao;
import com.entities.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/cus")
public class CustomerController {
    
    @Autowired
    @Qualifier("daoInj")
    private CustomerDao dao;

    /**
     * @return the dao
     */
    public CustomerDao getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<Customer> getCustomer(){
        List<Customer> list = null;
        try{
            list = dao.getCustomers();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public @ResponseBody Customer getCustomer(@RequestParam("cid") String customerId){
        Customer customer = null;
        try{
            customer = dao.getCustomer(Integer.parseInt(customerId));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return customer;
    }
    
}
