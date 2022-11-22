package com.liaudanskyte.baigiamasis.employee;

import com.github.javafaker.Faker;
import com.liaudanskyte.baigiamasis.InvalidRequestException;
import com.liaudanskyte.baigiamasis.company.Company;
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


    @PutMapping("/api/v1/employees/{employee_id}")
    public Optional<Employee> updateEmployeeById(
            @PathVariable long employee_id,
            @RequestBody Employee employeeDetails
    ) {
        var updateEmployee = employeeRepository.getById(employee_id)
                .orElseThrow(() -> new InvalidRequestException("Project does not exist with id: " + employee_id));

        updateEmployee.setEmployeeId(employee_id);
        updateEmployee.setName(employeeDetails.getName());
        updateEmployee.setJobTitle(employeeDetails.getJobTitle());
        updateEmployee.setQualificationCertificateNum(employeeDetails.getQualificationCertificateNum());
        updateEmployee.setSalary(employeeDetails.getSalary());
        updateEmployee.setStartedWorking(employeeDetails.getStartedWorking());
        updateEmployee.setIfStillWorking(employeeDetails.getIfStillWorking());
        updateEmployee.setCompanyId(employeeDetails.getCompanyId());
        updateEmployee.setStoppedWorking(employeeDetails.getStoppedWorking());

        employeeRepository.updateElement(updateEmployee);

        return employeeRepository.getById(employee_id);
    }
    

    @DeleteMapping("/api/v1/employees/{employee_id}")
    public void deleteEmployeeById(@PathVariable(name = "employee_id") long employee_id) {
        employeeRepository.deleteElement(employee_id);
        System.out.println("deleted where id: " + employee_id);
    }

}
