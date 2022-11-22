package com.liaudanskyte.baigiamasis.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CompanyJpa extends JpaRepository<Company, Long> {
//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE companies SET total_projects = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id), ongoing_project_count = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id AND projects.if_finished = false), finished_project_count = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id AND projects.if_finished = true), average_salary = (SELECT AVG(salary) FROM employees WHERE companies.id = employees.company_id), employee_count = (SELECT COUNT(*) FROM employees WHERE companies.id = employees.company_id AND employees.if_still_working = true);",
//            nativeQuery = true)
//    void updateMyStupidTable();
}
