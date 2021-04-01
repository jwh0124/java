package com.cubox.server.biz.identity.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.cubox.server.biz.identity.model.EmployeeDTO;
import com.cubox.server.biz.identity.service.EmployeeService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService _employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<EmployeeDTO> getEmployeeList() throws Exception {
        
        return _employeeService.retrieveEmployeeList()
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public EmployeeDTO getEmployee(@PathVariable UUID id) throws Exception {
        return modelMapper.map(_employeeService.retrieveEmployee(id), EmployeeDTO.class);
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this._employeeService = employeeService;
    }
}
