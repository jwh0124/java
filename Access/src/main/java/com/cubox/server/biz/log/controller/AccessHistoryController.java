package com.cubox.server.biz.log.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.cubox.server.biz.log.model.AccessHistoryDTO;
import com.cubox.server.biz.log.service.AccessHistoryService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access-histories")
public class AccessHistoryController {
    
    private AccessHistoryService _accessHistoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<AccessHistoryDTO> getAccessHistoryList() throws Exception { 

        return _accessHistoryService.retrieveAccessHistoryList()
                .stream()
                .map(accessHistory -> modelMapper.map(accessHistory, AccessHistoryDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public AccessHistoryDTO getAccessHistory(@PathVariable UUID id) throws Exception {
        return modelMapper.map(_accessHistoryService.retrieveAccessHistory(id), AccessHistoryDTO.class);
    }

    @Autowired
    public void setAccessHistoryService(AccessHistoryService accessHistoryService) {
        this._accessHistoryService = accessHistoryService;
    }
}
