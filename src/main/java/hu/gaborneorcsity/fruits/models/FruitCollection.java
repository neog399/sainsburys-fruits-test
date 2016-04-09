package hu.gaborneorcsity.fruits.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A class for representing a collection of Fruits
 */
public class FruitCollection {
    private List<Fruit> fruits;

    private BigDecimal total = new BigDecimal("0.0");

    /**
     * Creates an empty fruit collection
     */
    public FruitCollection() {
        this(new ArrayList<>());
    }

    /**
     * Creates a fruit collection containing the provided fruits
     * @param fruits the fruits to be included in this fruit collection
     */
    public FruitCollection(List<Fruit> fruits) {
        if (fruits == null) {
            throw new IllegalArgumentException("The list of fruits cannot be null!");
        }

        for (Fruit fruit : fruits) {
            total = total.add(fruit.getUnitPrice());
        }

        this.fruits = fruits;
    }

    public List<Fruit> getFruits() {
        return Collections.unmodifiableList(fruits);
    }

    public String getTotal() {
        return total.toPlainString();
    }

    /**
     * Generates and returns a fruit collection's JSON representation
     * @return the fruit collection's JSON representation
     */
    public JSONObject asJson() {
        JSONObject fruitCollectionAsJson = new JSONObject();
        fruitCollectionAsJson.put("total", total.setScale(2, RoundingMode.HALF_UP).doubleValue());

        JSONArray fruitListAsJson = new JSONArray();
        for (Fruit fruit : fruits) {
            fruitListAsJson.put(fruit.asJson());
        }

        fruitCollectionAsJson.put("results", fruitListAsJson);

        return fruitCollectionAsJson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitCollection that = (FruitCollection) o;

        return Objects.equals(fruits, that.fruits) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruits, total);
    }
}
