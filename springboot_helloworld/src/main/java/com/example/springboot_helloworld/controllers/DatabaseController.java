package com.example.springboot_helloworld.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {
    @PostMapping("/insert")
    public void insert() {

    }
}
