package com.liaudanskyte.baigiamasis.employee;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    private Faker faker;

    public EmployeeController(@Autowired EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.faker = new Faker();
    }

    @PostMapping("/api/v1/employees")
    public Optional<Employee> createEmployee(@RequestBody Employee employee) {
        employeeRepository.create(employee);
        return employeeRepository.getById(employee.getEmployeeId());
    }

    @GetMapping("/api/v1/employees")
    public List<Employee> getCompanyEmployees() {
        return employeeRepository.getAllElements();
    }



}
