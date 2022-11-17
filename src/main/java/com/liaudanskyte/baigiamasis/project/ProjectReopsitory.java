package com.liaudanskyte.baigiamasis.project;

import com.liaudanskyte.baigiamasis.ElementDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectReopsitory implements ElementDao<Project> {

    private ProjectJpa projectJpa;

    public ProjectReopsitory(ProjectJpa projectJpa) {
        this.projectJpa = projectJpa;
    }

    @Override
    public Project create(Project element) {
        return null;
    }

    @Override
    public List<Project> getAllElements() {
        return null;
    }

    @Override
    public Project getById(Long id) {
        return null;
    }

    @Override
    public Project updateElement(Project element) {
        return null;
    }

    @Override
    public void deleteElement(Long id) {

    }
}
