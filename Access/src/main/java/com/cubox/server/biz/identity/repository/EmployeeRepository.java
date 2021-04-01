package com.cubox.server.biz.identity.repository;

import java.util.UUID;

import com.cubox.server.biz.identity.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, UUID>{

}