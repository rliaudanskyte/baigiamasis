package com.liaudanskyte.baigiamasis.employee;

import com.liaudanskyte.baigiamasis.ElementDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeRepository implements ElementDao<Employee> {

    private EmployeeJpa employeeJpa;

    public EmployeeRepository(EmployeeJpa employeeJpa) {
        this.employeeJpa = employeeJpa;
    }

    @Override
    public Employee create(Employee element) {
        return null;
    }

    @Override
    public List<Employee> getAllElements() {
        return null;
    }

    @Override
    public Employee getById(Long id) {
        return null;
    }

    @Override
    public Employee updateElement(Employee element) {
        return null;
    }

    @Override
    public void deleteElement(Long id) {

    }
}
