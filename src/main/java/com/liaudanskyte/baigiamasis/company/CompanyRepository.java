package com.liaudanskyte.baigiamasis.company;

import com.liaudanskyte.baigiamasis.ElementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyRepository implements ElementDao<Company> {

    private CompanyJpa companyJpa;

    public CompanyRepository(@Autowired CompanyJpa companyJpa) {
        this.companyJpa = companyJpa;
    }

    @Override
    public Company create(Company element) {
        companyJpa.save(element);
        System.out.println(element + " \nthis was saved [WOOHOO] ");
        return element;
    }

    @Override
    public List<Company> getAllElements() {
        return companyJpa.findAll();
    }

    @Override
    public Company getById(Long id) {
        return companyJpa.getReferenceById(id);
    }

    @Override
    public Company updateElement(Company element) {
        System.out.println(companyJpa.save(element));
        System.out.println("updated");
        return element;
    }

    @Override
    public void deleteElement(Long id) {
        companyJpa.deleteById(id);
        System.out.println("company with this id: " + id + " was deleted");
    }
}
