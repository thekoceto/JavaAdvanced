package com.company.P08_FamilyTree;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthday;

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Person(String name) {
        this.name = name;
        this.birthday = null;
    }

    public Person(LocalDate birthday) {
        this.name = null;
        this.birthday = birthday;
    }
}
