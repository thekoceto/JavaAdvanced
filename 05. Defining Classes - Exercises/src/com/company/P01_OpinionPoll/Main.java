package com.company.P01_OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        List<Person> persons = new ArrayList<>();
        int n = Integer.parseInt(console.readLine());
        while (n-- >0)
            persons.add(new Person(console.readLine().split("\\s+")));

        persons
                .stream()
                .filter(Person::isOlderThan30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
