package christmas;

import java.util.LinkedList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        data = new LinkedList<>();
        this.color = color;
        this.capacity = capacity;
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (capacity > data.size()) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present datum : data) {
            if (datum.getName().equals(name)) {
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        double max = Double.MIN_VALUE;
        String name = "";
        String gender = "";
        for (Present datum : data) {
            if (datum.getWeight() > max) {
                max = datum.getWeight();
                name = datum.getName();
                gender = datum.getGender();
            }
        }
        for (Present datum : data) {
            if (datum.getWeight()== max && datum.getGender().equals(gender)&& datum.getName().equals(name)){
                return datum;
            }
        }
        return null;
    }

    public Present getPresent(String name){

        for (Present datum : data) {
            if (datum.getName().equals(name)){
                return datum;
            }
        }
        return null;

    }

    public String report(){
        String result = this.color+" bag contains:\n";
        String result1 = data.toString().replaceAll(", ","\n").replaceAll("[\\[\\]]","");
        return result+result1;
    }

}