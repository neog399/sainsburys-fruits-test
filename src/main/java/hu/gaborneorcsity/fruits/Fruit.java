package hu.gaborneorcsity.fruits;

import org.json.JSONObject;

import java.util.Objects;

public class Fruit {
    private final String title;

    private final double size;

    private final double unitPrice;

    private final String description;

    public Fruit(String title, double size, double unitPrice, String description) {
        this.title = title;
        this.size = size;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public double getSize() {
        return size;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public JSONObject asJson() {
        JSONObject fruitJson = new JSONObject();
        fruitJson.put("title", title);
        fruitJson.put("size", size + "kb");
        fruitJson.put("unit_price", unitPrice);
        fruitJson.put("description", description);

        return fruitJson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) o;

        return Double.compare(fruit.size, size) == 0 &&
                Double.compare(fruit.unitPrice, unitPrice) == 0 &&
                Objects.equals(title, fruit.title) &&
                Objects.equals(description, fruit.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, size, unitPrice, description);
    }
}
