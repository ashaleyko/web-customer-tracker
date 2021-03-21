package com.example.springdemo.dao;

import java.util.List;

import com.example.springdemo.entity.Customer;
import com.example.springdemo.util.SortUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers(int sortField) {

        Session session = sessionFactory.getCurrentSession();

        String fieldName = null;

        switch (sortField) {
            case SortUtils.FIRST_NAME:
                fieldName = "firstName";
                break;
            case SortUtils.LAST_NAME:
                fieldName = "lastName";
                break;
            case SortUtils.EMAIL:
                fieldName = "email";
                break;
            default:
                fieldName = "lastName";
        }

        Query<Customer> query = session.createQuery("from Customer order by " + fieldName, Customer.class);

        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {

        Session session = sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class, id);

        return customer;
    }

    @Override
    public void deleteCustomer(int id) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);

        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query query = null;

        if (searchName != null && searchName.trim().length() > 0) {
            query = currentSession.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name", Customer.class);
            query.setParameter("name", "%" + searchName.toLowerCase() + "%");
        } else {
            query = currentSession.createQuery("from Customer", Customer.class);
        }

        List<Customer> customers = query.getResultList();

        return customers;
    }
}
