package com.liaudanskyte.baigiamasis.employee;

import com.liaudanskyte.baigiamasis.ElementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepository implements ElementDao<Employee> {

    private final EmployeeJpa employeeJpa;

    public EmployeeRepository(@Autowired EmployeeJpa employeeJpa) {
        this.employeeJpa = employeeJpa;
    }

    @Override
    public Employee create(Employee element) {
        return employeeJpa.save(element);
    }

    @Override
    public List<Employee> getAllElements() {
        return employeeJpa.findAll();
    }

    @Override
    public Optional<Employee> getById(Long id) {
        return employeeJpa.findById(id);
    }

    @Override
    public Employee updateElement(Employee element) {
        return employeeJpa.save(element);
    }

    @Override
    public void deleteElement(Long id) {
        employeeJpa.deleteById(id);
    }

    public List<Employee> saveAll(List<Employee> employees) {return employeeJpa.saveAll(employees); }
}