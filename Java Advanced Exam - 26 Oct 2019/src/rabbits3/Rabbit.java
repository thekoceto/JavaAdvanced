package rabbits3;

public class Rabbit {
    private final String name;
    private final String species;
    private boolean available; // - true

    public Rabbit(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Rabbit (" + species + "): " + name;
    }
}