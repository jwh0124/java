package edu.circle.prototype.sse.controller;

import edu.circle.prototype.sse.domain.Employee;
import edu.circle.prototype.sse.dto.EmployeeDto;
import edu.circle.prototype.sse.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {

        return employeeService.getAllEmployees()
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    // 단일 조회
    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        return modelMapper.map(employeeService.getEmployeeById(id), EmployeeDto.class);
    }

    // 추가
    @PostMapping
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        var employee = modelMapper.map(employeeDto, Employee.class);
        return modelMapper.map(employeeService.createEmployee(employee), EmployeeDto.class);
    }

    // 수정
    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        var employee = modelMapper.map(employeeDto, Employee.class);
        return modelMapper.map(employeeService.updateEmployee(id, employee), EmployeeDto.class);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    // 프로필 이미지 업로드/수정
    @PostMapping("/{id}/image")
    public void uploadImage(@PathVariable Long id,
                                              @RequestParam("file") MultipartFile file) throws Exception {
        employeeService.uploadEmployeeImage(id, file);
    }

    // 프로필 이미지 조회
    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        var image = employeeService.getEmployeeImage(id);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(image.getContentType()))
                .body(image.getData());
    }

    // 프로필 이미지 삭제
    @DeleteMapping("/{id}/image")
    public void deleteImage(@PathVariable Long id) {
        employeeService.deleteEmployeeImage(id);
    }
}
