package com.tracker.springdemo.service;

import com.tracker.springdemo.dao.CustomerDAO;
import com.tracker.springdemo.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    CustomerDAO customerDAO;

    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    void getCustomers() {
        // given
        List<Customer> customers = List.of(new Customer(), new Customer());
        given(customerDAO.getCustomers()).willReturn(customers);

        // when
        List<Customer> returnedCustomers = customerService.getCustomers();

        // then
        then(customerDAO).should().getCustomers();
        assertThat(returnedCustomers).hasSize(2);
    }

    @Test
    void saveCustomer() {
    }

    @Test
    void getCustomer() {
        // given
        Customer customer = new Customer();
        //customer.setId(23);
        given(customerDAO.getCustomer(23)).willReturn(customer);

        // when
        Customer returnedCustomer = customerService.getCustomer(23);

        // then
        then(customerDAO).should().getCustomer(23);
        assertThat(returnedCustomer).isEqualTo(customer);
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void searchCustomers() {
    }
}