package com.forum.web.controller;

import com.forum.domain.Customer;
import com.forum.service.CustomerService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {
    @Test
    public void shouldShowCustomerPage(){
        CustomerService customerService = mock(CustomerService.class);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        when(customerService.all()).thenReturn(customers);
        CustomerController customerController = new CustomerController(customerService);
        ModelAndView activityModelAndView = customerController.customerView();
        assertThat(activityModelAndView.getViewName(), is("customers"));
        assertThat((ArrayList<Customer>) activityModelAndView.getModel().get("customerList"), is(customers));
    }
}
