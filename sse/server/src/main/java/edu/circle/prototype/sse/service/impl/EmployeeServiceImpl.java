package edu.circle.prototype.sse.service.impl;

import edu.circle.prototype.sse.domain.Employee;
import edu.circle.prototype.sse.domain.EmployeeImage;
import edu.circle.prototype.sse.repository.EmployeeImageRepository;
import edu.circle.prototype.sse.repository.EmployeeRepository;
import edu.circle.prototype.sse.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeImageRepository employeeImageRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeImageRepository employeeImageRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeImageRepository = employeeImageRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        var saveEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

        saveEmployee.setName(employee.getName());

        return employeeRepository.save(saveEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).ifPresent(employeeRepository::delete);
    }

    @Override
    public void uploadEmployeeImage(Long employeeId, MultipartFile file) throws IOException {
        var employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));

        var employeeImage = employeeImageRepository.findByEmployeeId(employeeId).orElse(new EmployeeImage());
        employeeImage.setEmployee(employee);
        employeeImage.setData(file.getBytes());
        employeeImage.setContentType(file.getContentType());
        employeeImage.setSize(file.getSize());

        employeeImageRepository.save(employeeImage);
    }

    @Override
    public EmployeeImage getEmployeeImage(Long employeeId) {
        return employeeImageRepository.findByEmployeeId(employeeId).orElseThrow(()-> new RuntimeException("Employee image not found"));
    }

    @Override
    public void deleteEmployeeImage(Long employeeId) {
        employeeImageRepository.findByEmployeeId(employeeId).ifPresent(employeeImageRepository::delete);
    }
}
