package com.liaudanskyte.baigiamasis.company;

import com.liaudanskyte.baigiamasis.ElementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyRepository implements ElementDao<Company> {

    private final CompanyJpa companyJpa;

    public CompanyRepository(@Autowired CompanyJpa companyJpa) {
        this.companyJpa = companyJpa;
    }

    @Override
    public Company create(Company element) {
        return companyJpa.save(element);
    }

    @Override
    public List<Company> getAllElements() {
        return companyJpa.findAll();
    }

    @Override
    public Optional<Company> getById(Long id) {
        return companyJpa.findById(id);
    }

    @Override
    public Company updateElement(Company element) {
        return companyJpa.save(element);
    }

    @Override
    public void deleteElement(Long id) {
        companyJpa.deleteById(id);
    }

    @Query( value = """
            UPDATE companies SET total_projects = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id);
            UPDATE companies SET ongoing_project_count = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id AND if_finished = false);
            UPDATE companies SET finished_project_count = (SELECT COUNT(*) FROM projects WHERE companies.id = projects.company_executive_id AND if_finished = true);
            UPDATE companies SET employee_count = (SELECT COUNT(*) FROM employees WHERE companies.id = employees.company_id AND if_still_working = true);""")
    void updateCompanyTableEmployeeFields() {
        System.out.println("updated company fields");
    }
}