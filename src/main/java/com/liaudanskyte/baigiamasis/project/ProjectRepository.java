package com.liaudanskyte.baigiamasis.project;

import com.liaudanskyte.baigiamasis.ElementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProjectRepository implements ElementDao<Project> {

    private ProjectJpa projectJpa;

    public ProjectRepository(@Autowired ProjectJpa projectJpa) {
        this.projectJpa = projectJpa;
    }

    @Override
    public Project create(Project element) {
        return projectJpa.save(element);
    }

    @Override
    public List<Project> getAllElements() {
        return projectJpa.findAll();
    }

    @Override
    public Optional<Project> getById(Long id) {
        return projectJpa.findById(id);
    }

    @Override
    public Project updateElement(Project element) {
        return projectJpa.save(element);
    }

    @Override
    public void deleteElement(Long id) {
        projectJpa.deleteById(id);
    }

    public boolean ifExists(Long id) { return projectJpa.findById(id).isPresent(); }

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