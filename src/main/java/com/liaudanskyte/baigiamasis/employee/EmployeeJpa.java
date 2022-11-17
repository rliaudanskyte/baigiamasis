package com.liaudanskyte.baigiamasis.employee;

import com.liaudanskyte.baigiamasis.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpa extends JpaRepository<Employee, Long> {

}
