package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;


    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<Present>(capacity);
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
        if (data.size() < capacity) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        return data.remove(this.getPresent(name));
    }

    public Present heaviestPresent() {
        return this.data.stream()
                .max(Comparator.comparing(Present::getWeight))
                .orElse(null);
    }

    public Present getPresent(String name) {
        return this.data.stream()
                .filter(customer -> name.equals(customer.getName()))
                .findAny()
                .orElse(null);
    }

    public String report() {

        StringBuilder report = new StringBuilder();

        report.append(color).append(" bag contains:").append(System.lineSeparator());
        this.data.forEach(present -> report.append(present).append(System.lineSeparator()));

        return report.toString().trim();
    }
}