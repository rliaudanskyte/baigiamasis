package com.liaudanskyte.baigiamasis.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(companyRepository.create(company));
        return companyRepository.getById(company.getId());
    }

    @GetMapping("/api/v1/companies")
    public List<Company> getCompanies() {
        return companyRepository.getAllElements();
    }
}