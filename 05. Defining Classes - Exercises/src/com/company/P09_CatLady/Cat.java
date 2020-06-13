package com.company.P09_CatLady;

public class Cat {
    private String name;
    private String breed;
    private double field;

    public Cat(String name, String breed, double field) {
        this.name = name;
        this.breed = breed;
        this.field = field;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.breed, this.name, this.field);
    }
    // StreetExtraordinaire Maca 100.00
}

