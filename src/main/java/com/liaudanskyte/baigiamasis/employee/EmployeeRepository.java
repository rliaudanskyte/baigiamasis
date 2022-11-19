package com.liaudanskyte.baigiamasis.employee;

import com.liaudanskyte.baigiamasis.ElementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    @Modifying
    @Query("""
            UPDATE companies SET total_projects = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id);
            UPDATE companies SET ongoing_project_count = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id AND if_finished = false);
            UPDATE companies SET finished_project_count = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id AND if_finished = true);
            UPDATE companies SET employee_count = (SELECT COUNT(*) FROM employees WHERE companies.id = employees.company_id AND if_still_working = true);""")
    void updateCompanyTableEmployeeFields() {
        System.out.println("updated company fields");
    }
}