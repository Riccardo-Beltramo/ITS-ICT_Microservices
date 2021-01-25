package org.example.customer.controllers;

import org.example.customer.models.Customer;
import org.example.customer.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(value = "/v2/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    //get
    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long customerId){
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if(customerOpt.isPresent()){
            log.info("Get customer");
            return customerOpt.get();
        }else{
            log.warn("Customer not found");
            return null;
        }
    }

    //set customer
    @RequestMapping(method = RequestMethod.PUT)
    public void setCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);//save
        System.out.println(customer);
        log.info("Save customer");
    }

    //edit customer
    @RequestMapping(value = "/{customerId}", method = RequestMethod.POST)
    public Customer editCustomer(@RequestBody Customer customer, @PathVariable Long customerId){
        log.info("Edit customer");
        return customerRepository.save(customer);
    }
}