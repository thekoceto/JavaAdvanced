package parking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {
    private String type;
    private int capacity;
    private Collection<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (getCount() < capacity) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(car ->
                manufacturer.equals(car.getManufacturer()) &&
                model.equals(car.getModel()));
    }

    public Car getLatestCar() {
        return this.data.stream()
                .max(Comparator.comparing(Car::getYear))
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream()
                .filter(car -> manufacturer.equals(car.getManufacturer()))
                .filter(car -> model.equals(car.getModel()))
                .findAny()
                .orElse(null);
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        out.append("The cars are parked in ").append(type);
        out.append(":").append(System.lineSeparator());
        out.append(data.stream()
                .map(Car::toString)
                .collect(Collectors.joining(System.lineSeparator())));
        return out.toString().trim();

//        return String.format(
//                "The cars are parked in %s:%n%s", type,
//                data.stream()
//                        .map(Car::toString)
//                        .collect(Collectors.joining(System.lineSeparator())));
    }

}
//Field data – Collection that holds added cars
//Method add(Car car) – adds an entity to the data if there is an empty cell for the car.
//Method remove(String manufacturer, String model) – removes the car by given manufacturer and model, if such exists, and returns boolean.
//Method getLatestCar() – returns the latest car (by year) or null if have no cars.
//Method getCar(String manufacturer, String model) – returns the car with the given manufacturer and model or null if there is no such car.
//Getter getCount() – returns the number of cars.
//getStatistics() – returns a String in the following format:
//"The cars are parked in {parking type}:
//{Car1}
//{Car2}
//(…)"