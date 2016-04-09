package hu.gaborneorcsity.fruits;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FruitCollection {
    private List<Fruit> fruits;

    private double total;

    public FruitCollection() {
        this(new ArrayList<>());
    }

    public FruitCollection(List<Fruit> fruits) {
        if (fruits == null) {
            throw new IllegalArgumentException("The list of fruits cannot be null!");
        }

        for (Fruit fruit : fruits) {
            total += fruit.getUnitPrice();
        }

        this.fruits = fruits;
    }

    public List<Fruit> getFruits() {
        return Collections.unmodifiableList(fruits);
    }

    public double getTotal() {
        return total;
    }

    public JSONObject asJson() {
        JSONObject fruitCollectionAsJson = new JSONObject();
        fruitCollectionAsJson.put("total", total);

        JSONArray fruitListAsJson = new JSONArray();
        for (Fruit fruit : fruits) {
            fruitListAsJson.put(fruit.asJson());
        }

        fruitCollectionAsJson.put("results", fruitListAsJson);

        return fruitCollectionAsJson;
    }
}
