package com.liaudanskyte.baigiamasis.project;

import com.github.javafaker.Faker;
import com.liaudanskyte.baigiamasis.InvalidRequestException;
import com.liaudanskyte.baigiamasis.employee.Employee;
import com.liaudanskyte.baigiamasis.employee.EmployeeRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {
    private ProjectRepository projectRepository;

    public ProjectController(@Autowired ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @PostMapping("/api/v1/projects")
    public Optional<Project> createProject(@RequestBody Project project) {
        projectRepository.create(project);
        return projectRepository.getById(project.getProjectId());
    }

    @GetMapping("/api/v1/projects/{project_id}")
    public Optional<Project> getCompanyProjectById(
            @PathVariable(name = "project_id") long project_id
    ) {
        if (projectRepository.ifExists(project_id)) {
            return projectRepository.getById(project_id);
        } else {
            throw new InvalidRequestException("Project does not exist with id: " + project_id);
        }
    }

    @GetMapping("/api/v1/projects")
    public List<Project> getCompanyProjects() {
        return projectRepository.getAllElements();
    }

    @PutMapping("/api/v1/projects/{project_id}")
    public Optional<Project> deleteProjectsById(
            @PathVariable long project_id,
            @RequestBody Project projectDetails
    ) {
        var updateProject = projectRepository.getById(project_id)
                        .orElseThrow(() -> new InvalidRequestException("Project does not exist with id: " + project_id));

        updateProject.setProjectId(project_id);
        updateProject.setProjectName(projectDetails.getProjectName());
        updateProject.setProjectLocation(projectDetails.getProjectLocation());
        updateProject.setProjectStartDate(projectDetails.getProjectStartDate());
        updateProject.setIfFinished(projectDetails.isIfFinished());
        updateProject.setProjectManagerId(projectDetails.getProjectManagerId());
        updateProject.setCompanyExecutiveId(projectDetails.getCompanyExecutiveId());

        projectRepository.updateElement(updateProject);

        return projectRepository.getById(project_id);
    }

    @DeleteMapping("/api/v1/projects/{project_id}")
    public void deleteProjectsById(@PathVariable(name = "project_id") long project_id) {
        projectRepository.deleteElement(project_id);
        System.out.println("deleted where id: " + project_id);
    }

}