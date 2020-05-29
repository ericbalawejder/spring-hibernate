package com.tracker.springdemo.dao;

import com.tracker.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();
}
