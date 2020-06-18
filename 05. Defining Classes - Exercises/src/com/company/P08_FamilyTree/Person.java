package com.company.P08_FamilyTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private final String name;
    private final String birthDate;
    private final List<Person> parents = new ArrayList<>();
    private final List<Person> children = new ArrayList<>();

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name + " " + birthDate;
    }

    public String getName() {
        return name;
    }

    public void addChild(Person child) {
        children.add(child);
        child.parents.add(this);
    }

    public String getBirthDate() {
        return birthDate;
    }

    public List<Person> getParents() {
        return Collections.unmodifiableList(parents);
    }

    public List<Person> getChildren() {
        return Collections.unmodifiableList(children);
    }
}
