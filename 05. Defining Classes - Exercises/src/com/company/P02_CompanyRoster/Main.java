package com.company.P02_CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Employee>> employees = new LinkedHashMap<>();
        Map<String, Double[]> salaries = new LinkedHashMap<>();
        int n = Integer.parseInt(console.readLine());

        while (n-- >0){
            String[] input = console.readLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            employees.putIfAbsent(department, new ArrayList<>());

            if (input.length == 4) {
                employees.get(department).add(new Employee(name, salary, position, department));
            }else if (input.length == 5) {
                if (input[4].indexOf('@')!=-1)
                    employees.get(department).add(new Employee(name, salary, position, department, input[4]));
                else
                    employees.get(department).add(new Employee(name, salary, position, department, Integer.parseInt(input[4])));
            }else
                employees.get(department).add(new Employee(input));

            salaries.putIfAbsent(department, new Double[]{0.0, 0.0});
            salaries.get(department)[0]+=salary;
            salaries.get(department)[1]++;
        }
        String highestAverageSalaryDepartment = "";
        Double highestAverageSalary = 0.0;
        for (Map.Entry<String,Double[] > entry : salaries.entrySet()){
            Double averageSalary = entry.getValue()[0]/entry.getValue()[1];
            if (highestAverageSalary.compareTo(averageSalary)<0){
                highestAverageSalary  = averageSalary;
                highestAverageSalaryDepartment = entry.getKey();
            }
        }
        System.out.println("Highest Average Salary: " + highestAverageSalaryDepartment);
        employees.get(highestAverageSalaryDepartment)
                .stream()
                .sorted((e1, e2)-> e2.getSalary().compareTo(e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
    }
}
