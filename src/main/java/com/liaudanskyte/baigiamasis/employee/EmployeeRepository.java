package com.liaudanskyte.baigiamasis.employee;

import com.liaudanskyte.baigiamasis.ElementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        employeeJpa.updateCompaniesTable();
        return employeeJpa.save(element);
    }

    @Override
    public List<Employee> getAllElements() {
        return employeeJpa.findAll();
    }
    public List<Employee> getAllByCompanyId(Long company_id) {
        return employeeJpa.getAllByCompanyId(company_id);
    }

    @Override
    public Optional<Employee> getById(Long id) {
        return employeeJpa.findById(id);
    }

    @Override
    public Employee updateElement(Employee element) {
        employeeJpa.updateCompaniesTable();
        return employeeJpa.save(element);
    }

    @Override
    public void deleteElement(Long id) {
        if (!getAllElements().isEmpty()) {
            employeeJpa.updateCompaniesTable();
        }
        employeeJpa.deleteById(id);
    }

    public List<Employee> saveAll(List<Employee> employees) {return employeeJpa.saveAll(employees); }

    public boolean ifExists(long employee_id) { return employeeJpa.findById(employee_id).isPresent(); }
}