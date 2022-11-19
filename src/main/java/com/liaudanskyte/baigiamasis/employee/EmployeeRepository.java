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

    @Modifying
    @Query(value = "UPDATE companies SET total_projects = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id), ongoing_project_count = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id AND projects.if_finished = false), finished_project_count = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id AND projects.if_finished = true), average_salary = (SELECT AVG(salary) FROM employees WHERE companies.id = employees.company_id), employee_count = (SELECT COUNT(*) FROM employees WHERE companies.id = employees.company_id AND employees.if_still_working = true); SELECT * FROM companies ORDER BY id ASC; ",
            nativeQuery = true)
    void updateCompanyTableEmployeeFields() {
        System.out.println("updated company fields");
    }
}