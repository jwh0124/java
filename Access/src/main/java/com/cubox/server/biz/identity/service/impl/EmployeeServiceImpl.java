package com.cubox.server.biz.identity.service.impl;

import java.util.List;
import java.util.UUID;

import com.cubox.server.biz.identity.entity.Employee;
import com.cubox.server.biz.identity.repository.EmployeeRepository;
import com.cubox.server.biz.identity.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository _employeeRepository;

    @Override
    public List<Employee> retrieveEmployeeList() {
        return _employeeRepository.findAll();
    }

    @Override
    public Employee retrieveEmployee(UUID id) {
        return _employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void registerEmployee(Employee employee) {
        // TODO Auto-generated method stub

    }

    @Override
    public void modifyEmployee(Employee employee) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeEmployee(UUID id) {
        // TODO Auto-generated method stub

    }

    @Autowired
    public void setRepository(final EmployeeRepository employeeRepository) {
        this._employeeRepository = employeeRepository;
    }
}
