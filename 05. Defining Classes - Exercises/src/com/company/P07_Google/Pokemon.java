package com.company.P07_Google;

public class Pokemon {
    //•	"<Name> pokemon <pokemonName> <pokemonType>"
    String pokemonName;
    String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.pokemonName, this.pokemonType);
    }
}
