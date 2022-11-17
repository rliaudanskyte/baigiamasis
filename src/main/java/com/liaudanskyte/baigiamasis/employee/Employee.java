package com.liaudanskyte.baigiamasis.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "employess")
public class Employee {

    @Id
    private long employeeId;
    private String name;
    private String surname;
    private String jobTitle;
    private long qualificationCertificateNum;
    private LocalDate startedWorking;
    private LocalDate stoppedWorking;

    public Employee() {}

    public Employee(long employeeId, String name, String surname, String jobTitle, long qualificationCertificateNum, LocalDate startedWorking, LocalDate stoppedWorking) {
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.jobTitle = jobTitle;
        this.qualificationCertificateNum = qualificationCertificateNum;
        this.startedWorking = startedWorking;
        this.stoppedWorking = stoppedWorking;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public LocalDate getStartedWorking() {
        return startedWorking;
    }

    public void setStartedWorking(LocalDate startedWorking) {
        this.startedWorking = startedWorking;
    }

    public LocalDate getStoppedWorking() {
        return stoppedWorking;
    }

    public void setStoppedWorking(LocalDate stoppedWorking) {
        this.stoppedWorking = stoppedWorking;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", qualificationCertificateNum=" + qualificationCertificateNum +
                ", startedWorking=" + startedWorking +
                ", stoppedWorking=" + stoppedWorking +
                '}';
    }
}
