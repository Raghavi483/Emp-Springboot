package com.example.sys;

import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    int employeeId;
    String employeeName;
    int age;
    String address;
    int phone_number;
    int salary;
    public Employee()
    {

    }
    public Employee(int employeeId, String employeeName, int age, String address, int phone_number, int salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.address = address;
        this.phone_number = phone_number;
        this.salary = salary;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
}
