package com.tracker.springdemo.dao;

import com.tracker.springdemo.entity.Customer;

import java.util.List;

// https://www.baeldung.com/hibernate-date-time
public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

    public void deleteCustomer(int id);

    public List<Customer> searchCustomers(String name);
}
