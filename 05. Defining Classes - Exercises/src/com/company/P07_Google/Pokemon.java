package com.company.P07_Google;

public class Pokemon {
    //•	"<Name> pokemon <pokemonName> <pokemonType>"
    private String pokemonName;
    private String pokemonType;

    Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.pokemonName, this.pokemonType);
    }
}
