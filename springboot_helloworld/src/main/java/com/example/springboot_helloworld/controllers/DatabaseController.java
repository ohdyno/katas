package com.example.springboot_helloworld.controllers;

import com.example.springboot_helloworld.models.Name;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {
    @PostMapping("/insert")
    public Name insert(@RequestBody Name name) {
        return name;
    }
}