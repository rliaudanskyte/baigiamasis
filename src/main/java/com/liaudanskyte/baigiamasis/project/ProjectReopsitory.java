package com.liaudanskyte.baigiamasis.project;

import com.liaudanskyte.baigiamasis.ElementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProjectReopsitory implements ElementDao<Project> {

    private ProjectJpa projectJpa;

    public ProjectReopsitory(@Autowired ProjectJpa projectJpa) {
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
}