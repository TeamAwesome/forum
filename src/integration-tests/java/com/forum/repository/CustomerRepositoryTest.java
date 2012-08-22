package com.forum.repository;

import com.forum.domain.Customer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomerRepositoryTest extends IntegrationTestBase {
    @Autowired
    private DataSource dataSource;

    @Test
    public void shouldFindAllCustomers() {
        CustomerRepository customerRepository = new CustomerRepository(dataSource);
        List<Customer> customers = customerRepository.all();
        assertThat(customers.size(), is(1));
        Customer customer = customers.get(0);
        assertThat(customer.getId(), is(1));
        assertThat(customer.getFirstName(), is("John"));
        assertThat(customer.getLastName(), is("Corner"));
    }
}
