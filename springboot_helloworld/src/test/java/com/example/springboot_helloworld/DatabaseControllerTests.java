package com.example.springboot_helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class DatabaseControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void foo() throws Exception {
        // assertTrue(true);
        mockMvc.perform(post("/insert").content("{ \"name\": \"Muhammed\"}")).andExpect(status().isOk());
    }
}
