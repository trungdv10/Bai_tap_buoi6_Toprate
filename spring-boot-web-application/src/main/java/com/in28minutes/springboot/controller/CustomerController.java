package com.in28minutes.springboot.controller;

import com.in28minutes.springboot.model.Customer;
import com.in28minutes.springboot.model.ResponseDelete;
import com.in28minutes.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers/create", method = RequestMethod.POST)
    public Customer createCustomers(@RequestBody Customer customer) {
        return customerService.addNewCustomer(customer);
    }

    @GetMapping("/customers/list")
    public List<Customer> getCustomerList() {
        return customerService.getCustomerList();
    }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomerById(@PathVariable Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/customer/delete/{customerId}")
    public ResponseDelete deleteCustomerById(@PathVariable Integer customerId) {
        ResponseDelete responseDelete = new ResponseDelete();
        responseDelete.setSuccess(customerService.deleteCustomerById(customerId));
        return responseDelete;
    }
}
