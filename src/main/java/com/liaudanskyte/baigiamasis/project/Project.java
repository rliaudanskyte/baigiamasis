package com.liaudanskyte.baigiamasis.project;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    private long projectId;
    private String projectName;
    private String projectLocation;
    private LocalDate projectStartDate;
    private boolean ifFinished;
    private long projectManagerId;
    private long companyExecutiveId;

    public Project() {}

    public Project(long projectId, String projectName, String projectLocation, LocalDate projectStartDate, boolean ifFinished, long projectManagerId, long companyExecutiveId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectLocation = projectLocation;
        this.projectStartDate = projectStartDate;
        this.ifFinished = ifFinished;
        this.projectManagerId = projectManagerId;
        this.companyExecutiveId = companyExecutiveId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public LocalDate getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(LocalDate projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public boolean isIfFinished() {
        return ifFinished;
    }

    public void setIfFinished(boolean ifFinished) {
        this.ifFinished = ifFinished;
    }

    public long getProjectManagerId() {
        return projectManagerId;
    }

    public void setProjectManagerId(long projectManagerId) {
        this.projectManagerId = projectManagerId;
    }

    public long getCompanyExecutiveId() {
        return companyExecutiveId;
    }

    public void setCompanyExecutiveId(long companyExecuiveId) {
        this.companyExecutiveId = companyExecuiveId;
    }

    @Override
    public String toString() {
        return "Project //" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectLocation='" + projectLocation + '\'' +
                ", projectStartDate=" + projectStartDate +
                ", ifFinished=" + ifFinished +
                ", projectManagerId=" + projectManagerId +
                ", companyExecutiveId=" + companyExecutiveId +
                " //";
    }
}
