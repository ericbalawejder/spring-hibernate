package com.tracker.springdemo.dao;

import com.tracker.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> theQuery =
                session.createQuery("from Customer order by lastName", Customer.class);

        List<Customer> customers = theQuery.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {

        // get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // save/update the customer
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {

        // get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        Customer customer = session.get(Customer.class, id);

        return customer;
    }

    @Override
    public void deleteCustomer(int id) {

        // get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query query = session.createQuery(
                "delete from Customer where id=:customerId");

        query.setParameter("customerId", id);

        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String name) {

        Session session = sessionFactory.getCurrentSession();
        Query query = null;

        if (name != null && name.trim().length() > 0) {
            query = session.createQuery(
                    "from Customer where lower(firstName) like :name or " +
                            "lower(lastName) like :name", Customer.class);

            query.setParameter("name", "%" + name.toLowerCase() + "%");

        } else {
            query = session.createQuery("from Customer", Customer.class);
        }
        return query.getResultList();
    }
}
