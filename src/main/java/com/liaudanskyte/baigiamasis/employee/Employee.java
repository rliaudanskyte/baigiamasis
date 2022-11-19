package com.liaudanskyte.baigiamasis.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private long employeeId;
    private String name;
    private String jobTitle;
    private long qualificationCertificateNum;
    private int salary;
    private LocalDate startedWorking;
    private Boolean ifStillWorking;
    private long companyId;

    public Employee() {}

    public Employee(long employeeId, String name, String jobTitle, long qualificationCertificateNum, int salary, LocalDate startedWorking, Boolean ifStillWorking, long companyId) {
        this.employeeId = employeeId;
        this.name = name;
        this.jobTitle = jobTitle;
        this.qualificationCertificateNum = qualificationCertificateNum;
        this.salary = salary;
        this.startedWorking = startedWorking;
        this.ifStillWorking = ifStillWorking;
        this.companyId = companyId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public long getQualificationCertificateNum() {
        return qualificationCertificateNum;
    }

    public void setQualificationCertificateNum(long qualificationCertificateNum) {
        this.qualificationCertificateNum = qualificationCertificateNum;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getStartedWorking() {
        return startedWorking;
    }

    public void setStartedWorking(LocalDate startedWorking) {
        this.startedWorking = startedWorking;
    }

    public boolean getStoppedWorking() {
        return ifStillWorking;
    }

    public void setStoppedWorking(boolean stoppedWorking) {
        this.ifStillWorking = ifStillWorking;
    }

    public Boolean getIfStillWorking() {
        return ifStillWorking;
    }

    public void setIfStillWorking(Boolean ifStillWorking) {
        this.ifStillWorking = ifStillWorking;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", qualificationCertificateNum=" + qualificationCertificateNum +
                ", salary=" + salary +
                ", startedWorking=" + startedWorking +
                ", stoppedWorking=" + ifStillWorking +
                '}';
    }
}
