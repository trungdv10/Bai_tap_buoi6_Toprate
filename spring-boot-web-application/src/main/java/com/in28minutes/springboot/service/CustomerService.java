package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerService {

    // create List Customer
    private static List<Customer> customers = new ArrayList<>();

//    static {
//        //  Initialize new customer
//        Customer customer1 = new Customer(1, "Nguyen Van A", "a@gmail.com", 30);
//        Customer customer2 = new Customer(2, "Nguyen Van B", "b@gmail.com", 33);
//        Customer customer3 = new Customer(3, "Nguyen Van C", "c@gmail.com", 34);
//
//        // Add all customer into list customer
//        customers.add(customer1);
//        customers.add(customer2);
//        customers.add(customer3);
//    }

    // Add new customer to list by auto increase id
    public Customer addNewCustomer(Customer customer) {

        customer.setId(customers.size() + 1);
        customers.add(customer);
        return customer;
    }

    // get all customer from list customer
    public List<Customer> getCustomerList() {
        return customers;
    }

    // get customer by id from list customer
    public Customer getCustomerById(Integer customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    // delete a customer by id from list customer
    public boolean deleteCustomerById(Integer customerId) {
        boolean success = true;
        for(Customer customer : customers) {
            if(customer.getId().equals(customerId)) {
                customers.remove(customer);
                success = true;
                break;
            } else {
                success = false;
            }
        }
        return success;
    }
}
