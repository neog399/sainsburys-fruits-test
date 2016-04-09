package hu.gaborneorcsity.fruits.models;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * A class for representing a fruit
 */
public class Fruit {
    private final String title;

    private final int size;

    private final BigDecimal unitPrice;

    private final String description;

    /**
     * Creates a new fruit
     * @param title the fruit's title
     * @param description the fruit's description
     * @param unitPrice the fruit's unit price
     * @param size the size of the fruit's HTML page
     */
    public Fruit(String title, String description, String unitPrice, int size) {
        this.title = title;
        this.description = description;
        this.unitPrice = new BigDecimal(unitPrice);
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getUnitPriceAsString() {
        return unitPrice.toPlainString();
    }

    public String getDescription() {
        return description;
    }

    /**
     * Generates and returns the fruit's JSON representation
     * @return the fruit's JSON representation
     */
    public JSONObject asJson() {
        JSONObject fruitJson = new JSONObject();
        fruitJson.put("title", title);
        fruitJson.put("size", new BigDecimal(size / 1024).setScale(2, RoundingMode.HALF_UP).doubleValue() + "kb");
        fruitJson.put("unit_price", unitPrice.setScale(2, RoundingMode.HALF_UP).doubleValue());
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
                Objects.equals(title, fruit.title) &&
                Objects.equals(unitPrice, fruit.unitPrice) &&
                Objects.equals(description, fruit.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, size, unitPrice, description);
    }
}
