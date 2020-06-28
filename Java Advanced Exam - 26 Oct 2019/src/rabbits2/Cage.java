package rabbits2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private Map<String, Rabbit> data;

    //private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
    public void add(Rabbit rabbit) {
        if (count() < capacity)
            data.putIfAbsent(rabbit.getName(), rabbit);
    }
    public boolean removeRabbit(String name){
        return data.remove(name) != null;
    }

    public void removeSpecies(String species){
        data.forEach((s, rabbit) -> removeSpecies(species));
    }

    public Rabbit sellRabbit(String name){
        data.get(name).setAvailable(false);
        return data.get(name);
    }

    public List<Rabbit> sellRabbitBySpecies(String species){
        List <Rabbit> result = data
                .values()
                .stream()
                .filter(rabbit -> rabbit.getSpecies().equals(species))
                .collect(Collectors.toList());
        data
                .values()
                .stream()
                .filter(rabbit -> rabbit.getSpecies().equals(species))
                .forEach(rabbit -> rabbit.setAvailable(false));

        return result;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder();

        result.append("Rabbits available at ").append(name);
        result.append(System.lineSeparator());
        data.entrySet()
                .stream()
                .filter(rabbit -> rabbit.getValue().isAvailable())
                .forEach(rabbit -> result.append(rabbit.getValue()).append(System.lineSeparator()));

        return result.toString().trim();
    }

}