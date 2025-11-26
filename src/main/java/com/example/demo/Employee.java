package com.example.demo;

import java.util.List;

public class Employee {
    private int id;
    private String name;
    private String dept;
    private Double sal;
    private List<String> skills;

    public Employee() {
    }

    public Employee(int id, String name, String department, Double sal, List<String> skills) {
        this.id = id;
        this.name = name;
        this.dept = department;
        this.sal = sal;
        this.skills = skills;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + dept + '\'' +
                ", salary=" + sal +
                ", skills=" + skills +
                '}';

    }
}