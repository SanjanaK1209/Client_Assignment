package com.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import controller.CustomerController;
import service.CustomerService;

@WebMvcTest(CustomerController.class)

class CustomerControllerTest {
	
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void testRegisterCustomer() throws Exception {
        mockMvc.perform(post("/api/customers/register")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{ \"name\": \"John Doe\", \"email\": \"john@example.com\", \"password\": \"password\" }"))
            .andExpect(status().isOk());
    }
}
