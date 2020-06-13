package com.company.P07_Google;

import java.util.List;

public class Person {
    //•	"<Name> company <companyName> <department> <salary>"    - unique
    //•	"<Name> pokemon <pokemonName> <pokemonType>"
    //•	"<Name> parents <parentName> <parentBirthday>"
    //•	"<Name> children <childName> <childBirthday>"
    //•	"<Name> car <carModel> <carSpeed>"                      - unique
    //
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parents> parents;
    private List<Children> children;
    private Car car;

    public Person() {
        this.company = null;
        this.pokemons = null;
        this.parents = null;
        this.children = null;
        this.car = null;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public void addParents(Parents parent) {
        this.parents.add(parent);
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public void addChildren(Children children) {
        this.children.add(children);
    }
    public void setCar(Car car) {
        this.car = car;
    }

    public Company getCompany() {
        return this.company;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parents> getParents() {
        return this.parents;
    }

    public List<Children> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        return  String.format("Company:%n%sCar:%n%sPokemon:%n%sParents:%n%sChildren:%n%s",
                this.company != null ? this.company.toString() : "",
                this.car != null ? this.car.toString() : "",
                this.pokemons != null ? joinPokemon(this.pokemons) : "",
                this.parents != null ? joinParents(this.parents) : "",
                this.children != null ? joinChildren(this.children) : "");
    }

    private String joinPokemon(List<Pokemon> pokemons) {
        String result = "";
        for (Pokemon pokemon : pokemons)
            result += pokemon.toString();
        return result;
    }

    private String joinParents(List<Parents> parents) {
        String result = "";
        for (Parents parent : parents)
            result += parent.toString();
        return result;
    }

    private String joinChildren(List<Children> children) {
        String result = "";
        for (Children child : children)
            result += child.toString();
        return result;
    }
    //TonchoTonchev
    //Company:
    //Car:
    //Trabant 30
    //Pokemon:
    //Electrode Electricity
    //Parents:
    //Children:
}
