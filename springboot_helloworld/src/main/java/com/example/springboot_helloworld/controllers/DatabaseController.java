package com.example.springboot_helloworld.controllers;

import com.example.springboot_helloworld.models.Name;
import com.example.springboot_helloworld.repositories.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {
    @Autowired
    public Customers customers;

    @PostMapping("/insert")
    public Name insert(@RequestBody Name name) {
        customers.save(name);
        return name;
    }

    @GetMapping("/getMuhammed")
    public Name getMuhammed() {
        return customers.getMuhammedFromDatabase();
    }
}