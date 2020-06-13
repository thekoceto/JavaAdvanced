package com.company.P08_FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        LocalDate date;

        List<Person> parents = new ArrayList<>();
        List <Person> children = new ArrayList<>();
        Person person;
        String line = console.readLine();
        if (line.contains("/")){
            person = new Person (LocalDate.parse(line));
        }else{
            person = new Person (LocalDate.parse(line));
        }

        while (!"End".equals(line = console.readLine())) {
            if (!line.contains("-")){
                String[] token = line.split("\\s+");
                Person currentPerson = new Person (token[0] + " " + token[1], LocalDate.parse(token[2]));
            }
        }
    }
}
