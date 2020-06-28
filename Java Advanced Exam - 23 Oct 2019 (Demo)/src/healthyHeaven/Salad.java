package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;

    public String getName() {
        return name;
    }

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }
    public int getTotalCalories(){
        return products.stream()
                .mapToInt(Vegetable::getCalories)
                .sum();
    }
    public int getProductCount(){
        return products.size();
    }
    public void add(Vegetable product){
        products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();

        print.append("* Salad ").append(this.name).append(" is ");
        print.append(getTotalCalories()).append(" calories and have ");
        print.append(getProductCount()).append(" products:");
        print.append(System.lineSeparator());

        products.forEach(product -> {
            print.append(product.toString()).append(System.lineSeparator());
        });

        return print.toString().trim();
    }
    // "+ getProductCount() +"
    //"* Salad {name} is {calories} calories and have {product count} products:
    //{Vegetable 1}
    //{Vegetable 2}
    //{Vegetable 3}
    //{…}"
}
