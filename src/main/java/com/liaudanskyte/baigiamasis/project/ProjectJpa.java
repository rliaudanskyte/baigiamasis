package com.liaudanskyte.baigiamasis.project;

import com.liaudanskyte.baigiamasis.company.Company;
import com.liaudanskyte.baigiamasis.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectJpa extends JpaRepository<Project, Long> {
    @Modifying
    @Transactional
//    @Query(value = "UPDATE companies SET total_projects = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id), ongoing_project_count = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id AND projects.if_finished = false), finished_project_count = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id AND projects.if_finished = true), average_salary = (SELECT AVG(salary) FROM employees WHERE companies.id = employees.company_id), employee_count = (SELECT COUNT(*) FROM employees WHERE companies.id = employees.company_id AND employees.if_still_working = true);",
    @Query(value = "UPDATE companies SET total_projects = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id), ongoing_project_count = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id AND projects.if_finished = false), finished_project_count = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id AND projects.if_finished = true), employee_count = (SELECT COUNT(*) FROM employees WHERE companies.id = employees.company_id AND employees.if_still_working = true);",
            nativeQuery = true)
    void updateCompaniesTable();

    @Query(value = "SELECT * FROM projects WHERE company_executive_id = ?1",
            nativeQuery = true)
    List<Project> getAllByCompanyId(Long company_id);
}
