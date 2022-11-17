package com.liaudanskyte.baigiamasis.company;

import com.liaudanskyte.baigiamasis.ElementDao;
import org.springframework.beans.factory.annotation.Autowired;
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
}