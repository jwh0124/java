package com.cubox.server.biz.identity.service;

import java.util.List;
import java.util.UUID;

import com.cubox.server.biz.identity.entity.Employee;

public interface EmployeeService {
    List<Employee> retrieveEmployeeList();

    Employee retrieveEmployee(UUID id);

    void registerEmployee(Employee employee);

    void modifyEmployee(Employee employee);

    void removeEmployee(UUID id);
}
