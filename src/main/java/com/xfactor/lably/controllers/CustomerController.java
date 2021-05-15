package com.xfactor.lably.controllers;


import antlr.collections.List;
import com.xfactor.lably.entity.Lab;
import com.xfactor.lably.entity.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerController
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    ArrayList<Customer> customers=new ArrayList();

    @GetMapping()
    public String customer() {
        return "You opened Customer Controller.";
    }

    @PostMapping("/addingCustomer")
    public Customer addingCustomer(@RequestBody Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        // Save admin to db
        customers.add(customer);
        return customer;
    }

    @GetMapping("/getAllCustomer")
    public ArrayList<Customer> getAllCustomer() {
      //  ArrayList<Customer> arrList=new ArrayList();
        // for(int i=0;i<5;i++)
        // {
        //     temp.add(customers.get(i));
        // }
        return customers;
    }

    @GetMapping("/getCustomerByName")
    public Customer getCustomerByName(@RequestParam String name) {
        Customer resCustomer = null;
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                resCustomer = customer;
            }
        }
        return resCustomer;
    }

}