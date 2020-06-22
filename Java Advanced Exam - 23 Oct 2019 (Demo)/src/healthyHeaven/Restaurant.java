package healthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad){
        data.add(salad);
    }

    public boolean buy(String name){
        return data.remove(data.stream()
                        .filter(salad -> name.equals(salad.getName()))
                        .findAny()
                        .orElse(null));
    }

    public Salad getHealthiestSalad(){
        return this.data.stream()
                .min(Comparator.comparing(Salad::getTotalCalories))
                .orElse(null);
    }

    public String generateMenu() {
        StringBuilder menu = new StringBuilder();

        menu.append(name).append(" have ").append(data.size());
        menu.append(" salads:").append(System.lineSeparator());

        data.forEach(salad -> {
            menu.append(salad.toString()).append(System.lineSeparator());
        });

        return menu.toString().trim();
    }
    //"{name} have {salad count} salads:
    //{Salad 1}
    //{Salad 2}
    //{…}"
}
