package com.company.P07_Google;

public class Company {
    //•	"<Name> company <companyName> <department> <salary>"
    private String companyName;
    private String department;
    private double salary;

    public Company(String companyName, String department, Double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", this.companyName, this.department, this.salary);
    }
}
