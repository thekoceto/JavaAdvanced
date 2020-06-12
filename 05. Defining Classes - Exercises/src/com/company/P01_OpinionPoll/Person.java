package com.company.P01_OpinionPoll;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Person(String[] input){
        this.name = input[0];
        this.age = Integer.parseInt(input[1]);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public  boolean isOlderThan30() {
        return this.age > 30;
    }
}
