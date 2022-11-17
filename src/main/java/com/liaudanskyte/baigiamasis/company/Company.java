package com.liaudanskyte.baigiamasis.company;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    private long id;
    private String companyName;
    private String address;
    @GeneratedValue
    private int employeeCount;
    @GeneratedValue
    private double averageSalary;

    private int totalProjects;
    @GeneratedValue
    private int ongoingProjectCount;

    private int finishedProjectCount;

    public Company() {}

    public Company(long id, String companyName, String address, int employeeCount, double averageSalary, int totalProjects, int finishedProjectCount) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.employeeCount = employeeCount;
        this.averageSalary = averageSalary;
        this.totalProjects = totalProjects;
        this.ongoingProjectCount = totalProjects - finishedProjectCount;
        this.finishedProjectCount = finishedProjectCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public int getTotalProjects() {
        return totalProjects;
    }

    public void setTotalProjects(int totalProjects) {
        this.totalProjects = totalProjects;
    }

    public int getOngoingProjectCount() {
        return ongoingProjectCount;
    }

    public void setOngoingProjectCount(int ongoingProjectCount) {
        this.ongoingProjectCount = ongoingProjectCount;
    }

    public int getFinishedProjectCount() {
        return finishedProjectCount;
    }

    public void setFinishedProjectCount(int finishedProjectCount) {
        this.finishedProjectCount = finishedProjectCount;
    }

    @Override
    public String toString() {
        return "Company[" +
                "id = " + id +
                ", companyName = '" + companyName + '\'' +
                ", address = '" + address + '\'' +
                ", employeeCount = " + employeeCount +
                ", averageSalary = " + averageSalary +
                ", totalProjects = " + totalProjects +
                ", ongoingProjectCount = " + ongoingProjectCount +
                ", finishedProjectCount = " + finishedProjectCount +
                ']';
    }
}
