package com.company.P02_CompanyRoster;

public class Employee {
    private String name;        // mandatory
    private Double salary;      // mandatory
    private String position;    // mandatory
    private String department;  // mandatory
    private String email;
    private int age;

    Employee(String[] input) {
        this.name = input[0];
        this.salary = Double.parseDouble(input[1]);
        this.position = input[2];
        this.department = input[3];
        this.email = input[4];
        this.age = Integer.parseInt(input[5]);
    }
    Employee(String name, Double salary, String position, String department, String email) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = -1;
    }
    Employee(String name, Double salary, String position, String department, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = age;
    }
    Employee(String name, Double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
        //Yovcho 610.13 n/a -1
    }
}
