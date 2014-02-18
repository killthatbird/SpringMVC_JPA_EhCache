/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Component;


import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rs69421
 */
@Component("daoInj")
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager em;

    @Override    
    @Transactional(value ="txMgr")
    public List<Customer> getCustomers() throws Exception {
        CriteriaBuilder criteriaBuilder = getEm().getCriteriaBuilder();
        CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        CriteriaQuery<Customer> criteriaQuery = query.select(root);
        TypedQuery<Customer> typedQuery = getEm().createQuery(criteriaQuery);
        typedQuery.setHint("org.hibernate.cacheable", Boolean.TRUE);
        return typedQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) throws Exception {
        getEm().persist(getEm());
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public Customer getCustomer(Integer customerId) throws Exception {
        return em.find(Customer.class, customerId);
    }
}
