package rabbits3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private final String name;
    private final int capacity;
    private final List<Rabbit> data;

    public Cage(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public int count(){
        return this.data.size();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Rabbit rabbit){
        if (this.capacity > this.count()){
            this.data.add(rabbit);
        }
    }
    public boolean removeRabbit(String name){
        for (Rabbit rabbit : this.data){
            if (name.equals(rabbit.getName())){
                return this.data.remove(rabbit);
            }
        }
        return false;
    }
    public void removeSpecies(String species){
        data.stream()
                .filter(rabbit -> species.equals(rabbit.getSpecies()))
                .forEach(data::remove);
    }

    public Rabbit sellRabbit(String name){
        for (Rabbit rabbit : data) {
            if(name.equals(rabbit.getName())) {
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return null;
//        Rabbit toSell = data.stream()
//                .filter(rabbit -> name.equals(rabbit.getName()))
//                .findAny()
//                .orElse(null);
//        if (toSell != null)
//            toSell.setAvailable(false);
//        return toSell;
    }
    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> removed = data.stream()
                .filter(rabbit -> species.equals(rabbit.getSpecies()))
                .collect(Collectors.toList());

        for (Rabbit rabbit : removed){
            rabbit.setAvailable(false);
            data.remove(rabbit);
        }
        return removed;
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at: %s", this.getName()));
        sb.append(System.lineSeparator());
        for (Rabbit rabbit : this.data) {
            sb.append(rabbit.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}