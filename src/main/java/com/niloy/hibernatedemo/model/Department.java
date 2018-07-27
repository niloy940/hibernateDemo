package com.niloy.hibernatedemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    private String departmentName;
    @OneToMany
    private List<Employee> employeeList;

    public Department() {
        employeeList = new ArrayList<>();
    }

    public Department(String departmentName) {

        this.departmentName = departmentName;
    }

    public Department(String departmentName, List<Employee> employeeList) {
        this.departmentName = departmentName;
        this.employeeList = employeeList;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
