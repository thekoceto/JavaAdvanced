package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.capacity > this.data.size()) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(rabbit -> rabbit.getName().equals(name) );
//        for (Rabbit rabbit : data) {
//            if (rabbit.getName().equals(name))
//                return data.remove(rabbit);
//        }
//        return false;
    }

    public void removeSpecies(String species) {
        data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
//        for (Rabbit rabbit : data) {
//            if (rabbit.getSpecies().equals(species))
//                return data.remove(rabbit);
//        }
//        return false;
    }

    public Rabbit sellRabbit(String name) {
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> removed = data.stream()
                .filter(rabbit -> rabbit.getSpecies().equals(species))
                .collect(Collectors.toList());

        for (Rabbit rabbit : removed) {
            data.remove(rabbit);
            rabbit.setAvailable(false);
        }
        return removed;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at %s:", this.getName()));
        sb.append(System.lineSeparator());
        for (Rabbit rabbit : this.data) {
            if (rabbit.isAvailable()) {
                sb.append(rabbit.toString());
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
//
//    public void аdd(Rabbit rabbit) {
//        if (capacity > data.size()) {
//            this.data.add(rabbit);
//        }
//    }
}