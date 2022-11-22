package com.liaudanskyte.baigiamasis.employee;

import com.github.javafaker.Faker;
import com.liaudanskyte.baigiamasis.InvalidRequestException;
import com.liaudanskyte.baigiamasis.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/v1/employees/{employee_id}")
    public Optional<Employee> getEmployeeById(
            @PathVariable(name = "employee_id") long employee_id
    ) {
        if (employeeRepository.ifExists(employee_id)) {
            return employeeRepository.getById(employee_id);
        } else {
            throw new InvalidRequestException("Employee does not exist with id: " + employee_id);
        }
    }

    @GetMapping("/api/v1/employees")
    public List<Employee> getCompanyEmployees() {
        return employeeRepository.getAllElements();
    }



}
