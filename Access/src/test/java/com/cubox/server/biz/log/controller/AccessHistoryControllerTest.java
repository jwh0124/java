package com.cubox.server.biz.log.controller;

import java.util.UUID;

import com.cubox.server.biz.log.service.AccessHistoryService;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(AccessHistoryController.class)
public class AccessHistoryControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccessHistoryService _service;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    public void getAccessHistoryList() throws Exception{
        
        // given        
        // when
        // then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/access-histories"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getAccessHistory() throws Exception{
        
        // given        
        // when
        // then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/access-histories/{id}",UUID.randomUUID()))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
