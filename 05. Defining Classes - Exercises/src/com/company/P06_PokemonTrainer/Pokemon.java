package com.company.P06_PokemonTrainer;

public class Pokemon {
    //Pokemon have a name, an element and health, all values are mandatory
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health){
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

    public boolean decreaseHealthBy10AndCheck() {
        this.health -= 10;
        return this.health<=0;
    }
}
