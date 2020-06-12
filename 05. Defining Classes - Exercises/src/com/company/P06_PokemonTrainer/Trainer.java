package com.company.P06_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void increaseBadgesBy1() {
        this.badges++;
    }
    //"<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>
    //Trainer have a name, number of badges and a collection of pokemon
}
