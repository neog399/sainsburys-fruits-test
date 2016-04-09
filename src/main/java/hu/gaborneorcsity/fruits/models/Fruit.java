package hu.gaborneorcsity.fruits.models;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Fruit {
    private final String title;

    private final double size;

    private final BigDecimal unitPrice;

    private final String description;

    public Fruit(String title, String description, String unitPrice, double size) {
        this.title = title;
        this.description = description;
        this.unitPrice = new BigDecimal(unitPrice);
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public double getSize() {
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
