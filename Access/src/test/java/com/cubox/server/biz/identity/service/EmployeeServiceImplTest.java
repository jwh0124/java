package com.cubox.server.biz.identity.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.cubox.server.biz.identity.entity.Employee;
import com.cubox.server.biz.identity.repository.EmployeeRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class EmployeeServiceImplTest {
    
    @Autowired
    private EmployeeService _service;

    @Autowired
    private EmployeeRepository _repository;

    private UUID id = UUID.randomUUID(); 

    @BeforeEach
    public void setUp(){
        _repository.save(new Employee(id, "12345", "Jung", UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "email", "phone", LocalDateTime.now(), LocalDateTime.now()));
    }

    @AfterEach
    public void tearDown() {
        _repository.deleteAll();
    }

    @Test
    public void retrieveEmployeeList() throws Exception{
        // given
        
        // when
        List<Employee> employeeList = _service.retrieveEmployeeList();
        // then
        
        assertEquals(1, employeeList.size());
    }

    @Test
    @Disabled("TODO : Fixed Test Case")
    public void retrieveEmployee() throws Exception{
        // given

        // when
        Employee employee = _service.retrieveEmployee(id); 
        // then
        assertNotNull(employee);
    }
}
