package com.liaudanskyte.baigiamasis.company;

import com.liaudanskyte.baigiamasis.InvalidRequestException;
import com.liaudanskyte.baigiamasis.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {
    private CompanyRepository companyRepository;

    public CompanyController(
            @Autowired CompanyRepository companyRepository
    ) {
        this.companyRepository = companyRepository;
    }

    @PostMapping("/api/v1/companies")
    public Optional<Company> createCompany(@RequestBody Company company) {
        companyRepository.create(company);
        return companyRepository.getById(company.getId());
    }

    @GetMapping("/api/v1/companies")
    public List<Company> getCompanies() {
        return companyRepository.getAllElements();
    }

    @GetMapping("/api/v1/companies/{company_id}")
    public Optional<Company> getCompanyById(
            @PathVariable(name = "company_id") long company_id
    ) {
        if (companyRepository.ifExists(company_id)) {
            return companyRepository.getById(company_id);
        } else {
            throw new InvalidRequestException("Company does not exist with id: " + company_id);
        }
    }

    @PutMapping("/api/v1/companies/{company_id}")
    public Optional<Company> deleteCompanyById(
            @PathVariable long company_id,
            @RequestBody Company companyDetails
    ) {
        var updateCompany = companyRepository.getById(company_id)
                .orElseThrow(() -> new InvalidRequestException("Project does not exist with id: " + company_id));

        updateCompany.setId(company_id);
        updateCompany.setCompanyName(companyDetails.getCompanyName());
        updateCompany.setAddress(companyDetails.getAddress());
        updateCompany.setEmployeeCount(1);
        updateCompany.setAverageSalary(1);
        updateCompany.setTotalProjects(1);
        updateCompany.setOngoingProjectCount(1);
        updateCompany.setFinishedProjectCount(1);

        return companyRepository.getById(company_id);
    }

    @DeleteMapping("/api/v1/companies/{company_id}")
    public void deleteCompanyById(@PathVariable(name = "company_id") long company_id) {
        companyRepository.deleteElement(company_id);
        System.out.println("deleted where id: " + company_id);
    }
}