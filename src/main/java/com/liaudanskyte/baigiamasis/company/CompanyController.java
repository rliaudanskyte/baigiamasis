package com.liaudanskyte.baigiamasis.company;

import com.liaudanskyte.baigiamasis.employee.EmployeeRepository;
import com.liaudanskyte.baigiamasis.project.ProjectReopsitory;
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

    @PostMapping("/companies")
    public Optional<Company> createCompany(@RequestBody Company company) {
//        var company = new Company(
//                123123123L,
//                "The Lightsaber company",
//                "Tatuine",
//                12,
//                5000,
//                10,
//                5,
//                5
//        );
        System.out.println(companyRepository.create(company));
        return companyRepository.getById(company.getId());
    }

    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return companyRepository.getAllElements();
    }

}
