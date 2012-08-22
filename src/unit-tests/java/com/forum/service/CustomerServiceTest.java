package com.forum.service;

import com.forum.domain.Customer;
import com.forum.repository.CustomerRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {
    @Test
    public void shouldReturnAllCustomers() {
        CustomerRepository customerRepository = mock(CustomerRepository.class);
        List<Customer> customers = new ArrayList<Customer>();
        when(customerRepository.all()).thenReturn(customers);
        CustomerService customerService = new CustomerService(customerRepository);
        assertThat(customerService.all(), is(customers));
    }
}
