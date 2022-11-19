package com.liaudanskyte.baigiamasis.project;

import com.liaudanskyte.baigiamasis.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProjectJpa extends JpaRepository<Project, Long> {
}
