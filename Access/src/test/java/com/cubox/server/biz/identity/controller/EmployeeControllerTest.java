package com.cubox.server.biz.identity.controller;

import java.util.UUID;

import com.cubox.server.biz.identity.service.EmployeeService;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService _service;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    public void getEmployeeList() throws Exception{
        // given        
        // when
        // then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getEmployee() throws Exception{
        // given        
        // when
        // then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employees/{id}", UUID.randomUUID()))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
