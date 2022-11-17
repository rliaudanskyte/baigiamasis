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

    @PostMapping("/employees")
    public Optional<Employee> createEmployee(@RequestBody Employee employee) {
//        var employee1 = new Employee(
//                500000003L,
//                faker.superhero().name(),
//                faker.superhero().power(),
//                512665516L,
//                LocalDate.of(1955,1,25),
//                true,
//                123123124L
//        );

        employeeRepository.create(employee);
//        System.out.println(employeeRepository.create(employee1));
        return employeeRepository.getById(employee.getEmployeeId());
    }

    @GetMapping("/employees")
    public List<Employee> getCompanyEmployees() {
        return employeeRepository.getAllElements();
    }


}
