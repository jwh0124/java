package edu.circle.prototype.sse.service;

import edu.circle.prototype.sse.domain.Employee;
import edu.circle.prototype.sse.domain.EmployeeImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    void uploadEmployeeImage(Long employeeId, MultipartFile file) throws IOException;

    EmployeeImage getEmployeeImage(Long employeeId);

    void deleteEmployeeImage(Long employeeId);
}
