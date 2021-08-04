package com.example.springboot_helloworld;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class DatabaseControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void foo() throws Exception {
        JSONObject json = new JSONObject();
        json.put("name", "Muhammed");

        mockMvc.perform(post("/insert").contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(json)))
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(json)));
    }

    @Test
    public void getTestBar() throws Exception {
        JSONObject json = new JSONObject();
        json.put("name", "Zach");
        mockMvc.perform(get("/getCustomerByName?name=Zach")).andExpect(content().json(String.valueOf(json)));
    }
}
