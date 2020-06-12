package com.company.P07_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new HashMap<>();
//        List<Person> people = new ArrayList<>();
        String line;
        while (!"End".equals(line = console.readLine())) {
            String[] token = line.split("\\s+");
            String name = token[0];
            people.putIfAbsent(name, new Person());
            switch (token[1]){
                case "company":
                    people.get(name).setCompany(new Company(token[2], token[3], Double.parseDouble(token[4])));
                    break;
                case "pokemon":
                    if (people.get(name).getPokemons() == null)
                        people.get(name).setPokemons(new ArrayList<>());
                    people.get(name).addPokemon(new Pokemon(token[2], token[3]));
                    break;
                case "parents":
                    if (people.get(name).getParents() == null)
                        people.get(name).setParents(new ArrayList<>());
                    people.get(name).addParents(new Parents(token[2], token[3]));
                    break;
                case "children":
                    if (people.get(name).getChildren() == null)
                        people.get(name).setChildren(new ArrayList<>());
                    people.get(name).addChildren(new Children(token[2], token[3]));
                    break;
                case "car":
                    people.get(name).setCar(new Car(token[2], Integer.parseInt(token[3])));
                    break;

                //•	"<Name> company <companyName> <department> <salary>"
                //•	"<Name> pokemon <pokemonName> <pokemonType>"
                //•	"<Name> parents <parentName> <parentBirthday>"
                //•	"<Name> children <childName> <childBirthday>"
                //•	"<Name> car <carModel> <carSpeed>"
            }
        }
        String person = console.readLine();
        System.out.println(person);
        System.out.println(people.get(person).toString());
    }
}
