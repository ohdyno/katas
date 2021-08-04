package com.example.springboot_helloworld.controllers;

import com.example.springboot_helloworld.models.Name;
import com.example.springboot_helloworld.repositories.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DatabaseController {
    @Autowired
    public Customers customers;

    @PostMapping("/insert")
    public Name insert(@RequestBody Name name) {
        customers.save(name);
        return name;
    }

    @GetMapping("/getCustomerByName")
    public Name getCustomerByName(@RequestParam String name) {
        return customers.getCustomerFromDatabase(name);
    }
}
